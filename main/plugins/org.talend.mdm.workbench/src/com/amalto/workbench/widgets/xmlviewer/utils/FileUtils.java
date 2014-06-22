/*****************************************************************************
 * This file is part of Rinzo
 *
 * Author: Claudio Cancinos WWW: https://sourceforge.net/projects/editorxml Copyright (C): 2008, Claudio Cancinos
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation; either version 2 of the License, or (at your option) any
 * later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this program; If not, see
 * <http://www.gnu.org/licenses/>
 ****************************************************************************/
package com.amalto.workbench.widgets.xmlviewer.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Path;
import org.talend.core.model.general.Project;
import org.talend.core.repository.model.ResourceModelUtils;
import org.talend.repository.ProjectManager;

public class FileUtils {
	public static final String EOL;
	private static final String FILE_PROTOCOL = "file:"; //$NON-NLS-1$
	protected static final String PROTOCOL_PATTERN = ":";  //$NON-NLS-1$
	public static final String LINE_SEPARATOR = System.getProperty("line.separator"); //$NON-NLS-1$
	public static final String TAB = "\t"; //$NON-NLS-1$

	static {
		EOL = File.separatorChar != '\\' ?
				File.separatorChar != '/' ? "\r" //$NON-NLS-1$
				: "\n" : "\r\n"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String relPathToUrl(String s) {
		char c = File.separatorChar;
		return c == '/' ? s : s.replace(c, '/');
	}

	/**
	 * Creates an absolute URI from a relative one
	 *
	 * @param basePath
	 * @param relativePath
	 * @return
	 * @throws URISyntaxException
	 */
	public static URI resolveURI(String basePath, String relativePath) throws URISyntaxException {
		return XMLViewUtils.isEmpty(basePath) ? null : createURI(basePath).resolve(relativePath.replaceAll(" ", "%20")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static char[] readContents(Reader reader) throws IOException {
		int i = 4096;
		char ac[] = new char[i];
		char ac1[] = new char[0];
		int j = 0;
		do {
			int k = reader.read(ac, 0, i);
			if (k < 0)
				break;
			if (k > 0) {
				int l = ac1.length;
				char ac2[] = new char[l + k];
				System.arraycopy(ac1, 0, ac2, 0, l);
				System.arraycopy(ac, 0, ac2, l, k);
				ac1 = ac2;
				if (++j >= 8 && i < 300000) {
					j = 0;
					i *= 2;
					ac = new char[i];
				}
			}
		} while (true);
		return ac1;
	}

	public static String fileUrlToPath(String s) {
		String s1 = s;
		int i = s.indexOf(':');
		int j = s.indexOf('/');
		if (i > 0 && (j < 0 || i < j)) {
			if (!s.startsWith("file:")) //$NON-NLS-1$
				throw new IllegalArgumentException(
						"Url must begin with \"file:\""); //$NON-NLS-1$
			int k = "file:".length(); //$NON-NLS-1$
			int l = s.length();
			int i1;
			for (i1 = 0; k < l && s.charAt(k) == '/'; i1++)
				k++;

			if (i1 > 0 && (i1 & 1) == 0)
				k -= 2;
			s1 = (File.separatorChar != '/' ? "" : "/") + s.substring(k); //$NON-NLS-1$ //$NON-NLS-2$
		}
		if (File.separatorChar != '/')
			s1 = s1.replace('/', File.separatorChar);
		return s1;
	}

	public static String addProtocol(String uri) {
	    if (!hasProtocol(uri))
	    {
	      String prefix = FILE_PROTOCOL;
	      prefix += uri.startsWith("/") ? "//" : "///"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	      uri = prefix + uri;
	    }
	    return uri;
	}

	private static URI createURI(String path) throws URISyntaxException {
		return new URI(path.replaceAll(" ", "%20")); //$NON-NLS-1$ //$NON-NLS-2$
	}


	private static boolean hasProtocol(String uri)
	  {
	    boolean result = false;
	    if (uri != null)
	    {
	      int index = uri.indexOf(PROTOCOL_PATTERN);
	      if (index != -1 && index > 2) // assume protocol with be length 3 so that the'C' in 'C:/' is not interpreted as a protocol
	      {
	        result = true;
	      }
	    }
	    return result;
	  }


    /**
     * Guarda un documento localmente en la cache
     */
    public static void saveFile(String inputFileName, File outputFile) {
    	InputStream openStream = null;
    	BufferedReader reader = null;
    	BufferedWriter writer = null;
        try {
            File inputFile = new File(inputFileName);
            if (!inputFile.exists()) {
				openStream = new URL(inputFileName).openStream();
                InputStreamReader is = new InputStreamReader(openStream);
                String encoding = is.getEncoding();
				reader = new BufferedReader(is);
				writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile,
                        false), encoding));

				String line = reader.readLine();
				while(line != null) {
					writer.write(line);
					writer.newLine();
					writer.flush();
					line = reader.readLine();
				}
            }
        } catch (Exception exception) {
            throw new RuntimeException("Error trying to save \'" + inputFileName + "\' in the cache.", exception); //$NON-NLS-1$ //$NON-NLS-2$
        } finally {
        	try {
				if(writer != null) {
					writer.flush();
					writer.close();
				}
				if(reader != null) {
					reader.close();
				}
				if(openStream != null) {
					openStream.close();
				}
			} catch (IOException e) {
	            throw new RuntimeException("Error trying to close files while saving \'" + inputFileName + "\' in the cache.", e); //$NON-NLS-1$ //$NON-NLS-2$
			}
        }
    }

	public static boolean exists(String localCachedName) {
		return new File(localCachedName).exists();
	}

    public static IFile buildTempFileInWorkspace(String fileContent, String fileNameWithExtension) {
        IFile file = null;
        if (fileContent != null) {
            try {
                Project project = ProjectManager.getInstance().getCurrentProject();
                IProject prj = ResourceModelUtils.getProject(project);
                file = prj.getFile(new Path("temp/" + fileNameWithExtension)); //$NON-NLS-1$

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "utf-8"); //$NON-NLS-1$

                outputStreamWriter.write(fileContent);
                outputStreamWriter.flush();
                outputStreamWriter.close();

                ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
                if (file.exists()) {
                    file.setContents(inputStream, true, false, null);
                } else {
                    file.create(inputStream, true, null);
                }

                inputStream.close();
            } catch (Exception e) {
                throw new RuntimeException("Error trying to create file \'" + fileNameWithExtension + "\' in the cache.", e); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }

        return file;
    }

	public static void safeClose(Closeable c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (Exception e) {
		}
	}

	public static void safeDelete(File c) {
		try {
			if (c != null) {
				c.delete();
			}
		} catch (Exception e) {
		}
	}

}
