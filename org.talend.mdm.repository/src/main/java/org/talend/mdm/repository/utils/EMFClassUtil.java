// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.talend.core.model.properties.ByteArray;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.ProcessItem;
import org.talend.core.model.properties.ReferenceFileItem;
import org.talend.mdm.repository.model.mdmproperties.MDMServerObjectItem;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesPackage;
import org.talend.mdm.repository.model.mdmserverobject.MDMServerObject;
import org.talend.mdm.repository.model.mdmserverobject.MdmserverobjectPackage;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class EMFClassUtil {

    static Logger log = Logger.getLogger(EMFClassUtil.class);

    private List<EClass> definedClass = new LinkedList<EClass>();

    private EMFClassUtil() {
    }

    private static EMFClassUtil instance = new EMFClassUtil();

    /**
     * Getter for instance.
     * 
     * @return the instance
     */
    public static EMFClassUtil getInstance() {
        return instance;
    }

    public List<EClass> getAllEClass() {
        if (definedClass.isEmpty()) {
            Class cls = MdmserverobjectPackage.Literals.class;
            for (Field field : cls.getDeclaredFields()) {
                if (field.getType() == EClass.class) {
                    try {
                        Object object = field.get(cls);
                        definedClass.add((EClass) object);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        return definedClass;
    }

    public String caculateDigestValue(Item item) {
        DigestCalStrategyEnum strategy = getDigetValueCaculateStrategy(item);
        switch (strategy) {
        case OBJ_RESOURCE:
            return calculateDigestValueByObjectResource(item);
        case REF_FILE:
            return calculateDigestValueByRefFile(item);
        case SORTED_OBJ_RESOURCE:
            return calculateDigestValueBySortedObject(item);

        }
        return null;
    }

    enum DigestCalStrategyEnum {
        // compare the object 's resource file
        OBJ_RESOURCE,
        // same with OBJ_RESOURCE except the property is sorted
        SORTED_OBJ_RESOURCE,
        // only compare the reference file
        REF_FILE

    }

    private DigestCalStrategyEnum getDigetValueCaculateStrategy(Item item) {
        if (item instanceof ProcessItem) {
            return DigestCalStrategyEnum.OBJ_RESOURCE;
        }
        if (item instanceof MDMServerObjectItem) {
            int id = item.eClass().getClassifierID();
            switch (id) {
            case MdmpropertiesPackage.WS_CUSTOM_FORM_ITEM:
            case MdmpropertiesPackage.WS_DATA_MODEL_ITEM:
            case MdmpropertiesPackage.WS_RESOURCE_ITEM:

                return DigestCalStrategyEnum.REF_FILE;
            case MdmpropertiesPackage.WS_WORKFLOW_ITEM:
                return DigestCalStrategyEnum.SORTED_OBJ_RESOURCE;
            default:
                return DigestCalStrategyEnum.OBJ_RESOURCE;
            }
        }
        return DigestCalStrategyEnum.OBJ_RESOURCE;
    }

    private String calculateDigestValueByObjectResource(Item item) {
        EObject copy = null;
        if (item instanceof ProcessItem) {
            copy = EcoreUtil.copy(((ProcessItem) item).getProcess());
        } else if (item instanceof MDMServerObjectItem) {
            MDMServerObject mdmServerObject = ((MDMServerObjectItem) item).getMDMServerObject();
            copy = EcoreUtil.copy(mdmServerObject);
            // remove server def property
            MDMServerObject copiedMdmObj = (MDMServerObject) copy;
            copiedMdmObj.setLastServerDef(null);
            // restore the timestamp to default
            copiedMdmObj.setTimestamp(0L);

        } else {
            // unsupport to caculate object md5 which not belong to MDM
            throw new UnsupportedOperationException();
        }
        if (copy != null) {
            //
            Resource resource = new XMIResourceImpl();
            resource.getContents().add(copy);
            return calculateDigestValueByEMFResource(resource);
        }
        return null;
    }

    private String calculateDigestValueByEMFResource(Resource resource) {
        ByteArrayOutputStream os = null;
        try {
            os = new ByteArrayOutputStream();
            resource.save(os, Collections.EMPTY_MAP);
            String digestValue = DigestUtil.encodeByMD5(os.toByteArray());
            return digestValue;
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return null;
        } finally {
            IOUtils.closeQuietly(os);
        }
    }

    private IFile getReferenceFile(Item item) {
        List refResources = item.getReferenceResources();
        if (refResources != null && !refResources.isEmpty()) {
            ReferenceFileItem fileItem = (ReferenceFileItem) refResources.get(0);
            ByteArray content = fileItem.getContent();

            URI uri = content.eResource().getURI();
            if (uri.isPlatformResource()) {
                IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
                IPath path = new Path(uri.toPlatformString(true));
                IFile file = root.getFile(path);
                return file;
            }
        }
        return null;
    }

    private String calculateDigestValueByRefFile(Item item) {

        IFile file = getReferenceFile(item);
        if (file.exists()) {
            InputStream in = null;
            ByteArrayOutputStream out = null;
            try {
                in = file.getContents();
                out = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = -1;
                while ((len = in.read(buffer)) != -1) {
                    out.write(buffer, 0, len);
                }
                //
                String digestValue = DigestUtil.encodeByMD5(out.toByteArray());
                return digestValue;
            } catch (CoreException e) {
                log.error(e.getMessage(), e);
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            } finally {
                IOUtils.closeQuietly(in);
                IOUtils.closeQuietly(out);
            }

        }
        return null;
    }

    private String calculateDigestValueBySortedObject(Item item) {
        if (item.eClass().getClassifierID() == MdmpropertiesPackage.WS_WORKFLOW_ITEM) {

            IFile file = getReferenceFile(item);
            if (file.exists()) {
                try {
                    URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
                    Resource rawResource = new XMIResourceImpl(uri);
                    rawResource.load(Collections.EMPTY_MAP);
                    Resource resource = new XMIResourceImpl();
                    SortEMFCopier copier = new SortEMFCopier();
 
                    for (EObject next : rawResource.getContents()) {
                        EObject copy = copier.duplicate(next);
                        resource.getContents().add(copy);
                    }
                    return calculateDigestValueByEMFResource(resource);
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }

            }
        }
        return null;
    }

    public class SortEMFCopier extends EcoreUtil.Copier {

        @Override
        protected void copyAttribute(EAttribute eAttribute, EObject eObject, EObject copyEObject) {

            if (eObject.eIsSet(eAttribute)) {
                if (FeatureMapUtil.isFeatureMap(eAttribute)) {
                    FeatureMap featureMap = (FeatureMap) eObject.eGet(eAttribute);
                    for (int i = 0, size = featureMap.size(); i < size; ++i) {
                        EStructuralFeature feature = featureMap.getEStructuralFeature(i);
                        if (feature instanceof EReference && ((EReference) feature).isContainment()) {
                            Object value = featureMap.getValue(i);
                            if (value != null) {
                                copy((EObject) value);
                            }
                        }
                    }
                } else if (eAttribute.isMany()) {
                    List<?> source = (List<?>) eObject.eGet(eAttribute);

                    @SuppressWarnings("unchecked")
                    List<Object> target = (List<Object>) copyEObject.eGet(getTarget(eAttribute));
                    if (source.isEmpty()) {
                        target.clear();
                    } else {
                        Object[] array = source.toArray();
                        Arrays.sort(array);
                        for (Object object : array) {
                            target.add(object);
                        }

                    }
                } else {
                    copyEObject.eSet(getTarget(eAttribute), eObject.eGet(eAttribute));
                }
            }

        }

        public <T extends EObject> T duplicate(T eObject) {
            SortEMFCopier copier = new SortEMFCopier();
            EObject result = copier.copy(eObject);
            copier.copyReferences();

            @SuppressWarnings("unchecked")
            T t = (T) result;
            return t;
        }
    }
}
