package org.talend.mdm.repository.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.IEditorReference;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import org.talend.commons.exception.LoginException;
import org.talend.commons.exception.PersistenceException;
import org.talend.commons.utils.VersionUtils;
import org.talend.commons.utils.workbench.resources.ResourceUtils;
import org.talend.core.context.RepositoryContext;
import org.talend.core.model.general.Project;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.ItemState;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.properties.Property;
import org.talend.core.model.properties.User;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.repository.model.ResourceModelUtils;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.core.IRepositoryNodeConfiguration;
import org.talend.mdm.repository.core.IRepositoryNodeLabelProvider;
import org.talend.mdm.repository.core.IRepositoryNodeResourceProvider;
import org.talend.mdm.repository.core.service.ContainerCacheService;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.models.FolderRepositoryObject;
import org.talend.repository.ProjectManager;
import org.talend.repository.model.ERepositoryStatus;
import org.talend.repository.model.IProxyRepositoryFactory;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ RepositoryResourceUtil.class,ProjectManager.class })
public class RepositoryResourceUtilTest {


    @Ignore
    @Test
    public void testIsLockedViewObject() {
        IRepositoryViewObject mockViewObject = mock(IRepositoryViewObject.class);

        PowerMockito.mockStatic(CoreRuntimePlugin.class);
        CoreRuntimePlugin coreRuntimePlugin = mock(CoreRuntimePlugin.class);
        when(CoreRuntimePlugin.getInstance()).thenReturn(coreRuntimePlugin);

        IProxyRepositoryFactory repositoryFactory = mock(IProxyRepositoryFactory.class);
        when(CoreRuntimePlugin.getInstance().getProxyRepositoryFactory()).thenReturn(repositoryFactory);

        // true
        when(repositoryFactory.getStatus(mockViewObject)).thenReturn(ERepositoryStatus.LOCK_BY_OTHER);
        boolean islockedViewObject = RepositoryResourceUtil.isLockedViewObject(mockViewObject);
        assertTrue(islockedViewObject);

        when(repositoryFactory.getStatus(mockViewObject)).thenReturn(ERepositoryStatus.LOCK_BY_USER);
        islockedViewObject = RepositoryResourceUtil.isLockedViewObject(mockViewObject);
        assertTrue(islockedViewObject);

        // false
        ERepositoryStatus[] statuss = { ERepositoryStatus.DEFAULT, ERepositoryStatus.DELETED, ERepositoryStatus.EDITABLE,
                ERepositoryStatus.ERROR, ERepositoryStatus.NEW, ERepositoryStatus.NOT_UP_TO_DATE, ERepositoryStatus.READ_ONLY,
                ERepositoryStatus.WARN };
        for (ERepositoryStatus status : statuss) {
            when(repositoryFactory.getStatus(mockViewObject)).thenReturn(status);
            islockedViewObject = RepositoryResourceUtil.isLockedViewObject(mockViewObject);
            assertFalse(islockedViewObject);
        }
    }

    @Ignore
    @Test
    public void testIsLockedAndEdited() {
        IRepositoryViewObject mockViewObject = mock(IRepositoryViewObject.class);

        PowerMockito.mockStatic(CoreRuntimePlugin.class);
        CoreRuntimePlugin coreRuntimePlugin = mock(CoreRuntimePlugin.class);
        when(CoreRuntimePlugin.getInstance()).thenReturn(coreRuntimePlugin);

        IProxyRepositoryFactory repositoryFactory = mock(IProxyRepositoryFactory.class);
        when(CoreRuntimePlugin.getInstance().getProxyRepositoryFactory()).thenReturn(repositoryFactory);

        // true
        when(repositoryFactory.getStatus(mockViewObject)).thenReturn(ERepositoryStatus.LOCK_BY_OTHER);
        boolean islockedViewObject = RepositoryResourceUtil.isLockedAndEdited(mockViewObject);
        assertTrue(islockedViewObject);
        
        PowerMockito.mockStatic(RepositoryResourceUtil.class);
        when(repositoryFactory.getStatus(mockViewObject)).thenReturn(ERepositoryStatus.LOCK_BY_USER);
        when(RepositoryResourceUtil.isOpenedInEditor(mockViewObject)).thenReturn(Mockito.any(IEditorReference.class));
        islockedViewObject = RepositoryResourceUtil.isLockedAndEdited(mockViewObject);
        assertTrue(islockedViewObject);
        //false
        when(RepositoryResourceUtil.isOpenedInEditor(mockViewObject)).thenReturn(null);
        islockedViewObject = RepositoryResourceUtil.isLockedAndEdited(mockViewObject);
        assertFalse(islockedViewObject);
        
        // false
        ERepositoryStatus[] statuss = { ERepositoryStatus.DEFAULT, ERepositoryStatus.DELETED, ERepositoryStatus.EDITABLE,
                ERepositoryStatus.ERROR, ERepositoryStatus.NEW, ERepositoryStatus.NOT_UP_TO_DATE, ERepositoryStatus.READ_ONLY,
                ERepositoryStatus.WARN };
        for (ERepositoryStatus status : statuss) {
            when(repositoryFactory.getStatus(mockViewObject)).thenReturn(status);
            islockedViewObject = RepositoryResourceUtil.isLockedViewObject(mockViewObject);
            assertFalse(islockedViewObject);
        }
    }
    @Ignore
    @Test
    public void testIsLockedItem() {
        Item mockItem = mock(Item.class);
        
        PowerMockito.mockStatic(CoreRuntimePlugin.class);
        CoreRuntimePlugin coreRuntimePlugin = mock(CoreRuntimePlugin.class);
        when(CoreRuntimePlugin.getInstance()).thenReturn(coreRuntimePlugin);

        IProxyRepositoryFactory repositoryFactory = mock(IProxyRepositoryFactory.class);
        when(CoreRuntimePlugin.getInstance().getProxyRepositoryFactory()).thenReturn(repositoryFactory);
        
        when(repositoryFactory.getStatus(mockItem)).thenReturn(ERepositoryStatus.LOCK_BY_OTHER);
        boolean islockedViewObject = RepositoryResourceUtil.isLockedItem(mockItem);
        assertTrue(islockedViewObject);
        
        when(repositoryFactory.getStatus(mockItem)).thenReturn(ERepositoryStatus.LOCK_BY_USER);
        islockedViewObject = RepositoryResourceUtil.isLockedItem(mockItem);
        assertTrue(islockedViewObject);
        
        // false
        ERepositoryStatus[] statuss = { ERepositoryStatus.DEFAULT, ERepositoryStatus.DELETED, ERepositoryStatus.EDITABLE,
                ERepositoryStatus.ERROR, ERepositoryStatus.NEW, ERepositoryStatus.NOT_UP_TO_DATE, ERepositoryStatus.READ_ONLY,
                ERepositoryStatus.WARN };
        for (ERepositoryStatus status : statuss) {
            when(repositoryFactory.getStatus(mockItem)).thenReturn(status);
            islockedViewObject = RepositoryResourceUtil.isLockedItem(mockItem);
            assertFalse(islockedViewObject);
        }
    }
    
    @Ignore
    @Test
    public void testSaveItem() {
        fail("Not yet implemented");
    }
    @Ignore
    @Test
    public void testCreateItemWith2Args() throws PersistenceException, LoginException {
        String propLabel = "this is propLabel";
        String nextId = "UUID_NEXT";

        Item mockItem = mock(Item.class);
        ItemState mockItemState = mock(ItemState.class);
        when(mockItem.getState()).thenReturn(mockItemState);
        when(mockItem.getState().getPath()).thenReturn("");

        PowerMockito.mockStatic(CoreRuntimePlugin.class);
        CoreRuntimePlugin coreRuntimePlugin = mock(CoreRuntimePlugin.class);
        when(CoreRuntimePlugin.getInstance()).thenReturn(coreRuntimePlugin);

        IProxyRepositoryFactory repositoryFactory = mock(IProxyRepositoryFactory.class);
        when(CoreRuntimePlugin.getInstance().getProxyRepositoryFactory()).thenReturn(repositoryFactory);

        RepositoryContext mockContext = mock(RepositoryContext.class);
        when(repositoryFactory.getRepositoryContext()).thenReturn(mockContext);
        when(repositoryFactory.getNextId()).thenReturn(nextId);

        Property mockProperty = mock(Property.class);
        when(mockItem.getProperty()).thenReturn(mockProperty);

        PropertiesFactory proFactory = PropertiesFactory.eINSTANCE;
        PropertiesFactory spyProFactory = PowerMockito.spy(proFactory);
        when(spyProFactory.createProperty()).thenReturn(mockProperty);

        User user = mock(User.class);
        when(mockContext.getUser()).thenReturn(user);

        PowerMockito.mockStatic(RepositoryNodeConfigurationManager.class);
        IRepositoryNodeConfiguration mockConfManager = mock(IRepositoryNodeConfiguration.class);
        when(RepositoryNodeConfigurationManager.getConfiguration(Mockito.any(Item.class))).thenReturn(mockConfManager);

        IRepositoryNodeResourceProvider mockResourceProvider = mock(IRepositoryNodeResourceProvider.class);
        when(mockConfManager.getResourceProvider()).thenReturn(mockResourceProvider);
        when(mockResourceProvider.needSaveReferenceFile()).thenReturn(true);
        when(repositoryFactory.isEditableAndLockIfPossible(mockItem)).thenReturn(true);

        boolean createItem = RepositoryResourceUtil.createItem(mockItem, propLabel);
        verify(mockProperty, times(1)).setId(nextId);
        verify(mockProperty, times(1)).setVersion(Mockito.anyString());
        verify(mockProperty, times(1)).setAuthor(user);
        verify(mockProperty, times(1)).setLabel(propLabel);
        verify(repositoryFactory, times(1)).create(Mockito.any(Item.class), Mockito.any(IPath.class));
        verify(mockResourceProvider, times(1)).handleReferenceFile(mockItem);

        verify(repositoryFactory, times(1)).unlock(mockItem);

        assertTrue(createItem);
    }
    @Ignore
    @Test
    public void testGetVersionFileName() {
        String version = "0.1";
        String firstF = "datamodel";
        String endF = "xsd";
        File file = new File(firstF + "." + endF);

        String versionFileName = RepositoryResourceUtil.getVersionFileName(file, version);
        assertEquals(firstF + "_" + version + "." + endF, versionFileName);

        versionFileName = RepositoryResourceUtil.getVersionFileName(file, null);
        assertEquals(firstF + "_" + VersionUtils.DEFAULT_VERSION + "." + endF, versionFileName);

        versionFileName = RepositoryResourceUtil.getVersionFileName(new File(firstF), null);
        assertEquals(firstF, versionFileName);
    }
    @Ignore
    @Test
    public void testCopyOSFileTOProject() throws PersistenceException, CoreException {
        String path = "srcpath";
        IFolder desFolder = mock(IFolder.class);
        String version = VersionUtils.DEFAULT_VERSION;
        boolean overwrite = true;
        IProgressMonitor progressMonitor = mock(IProgressMonitor.class);

        IProject mockProject = mock(IProject.class);

        // verify that if second or third parameter is null will throws exception of IllegalArgumentException type
        try {
            RepositoryResourceUtil.copyOSFileTOProject(mockProject, null, desFolder, version, overwrite, progressMonitor);
            fail();
        } catch (Exception e) {
            if (e instanceof IllegalArgumentException)
                assertTrue(true);
            else {
                assertTrue(false);
            }
        }

        try {
            RepositoryResourceUtil.copyOSFileTOProject(mockProject, path, null, version, overwrite, progressMonitor);
            fail();
        } catch (Exception e) {
            if (e instanceof IllegalArgumentException)
                assertTrue(true);
            else {
                assertTrue(false);
            }
        }

        // if first parameter is null, verify it will call method to create a IProject instance
        PowerMockito.mockStatic(ProjectManager.class);
        RepositoryResourceUtil.copyOSFileTOProject(null, path, desFolder, version, overwrite, progressMonitor);
        PowerMockito.verifyStatic(times(1));
        ProjectManager.getInstance();
        ResourceModelUtils.getProject(Mockito.any(Project.class));

        // verify if the file that defined by second parameter does not exist, return null
        String invalidPath = "mm:\\ss";
        IFile copiedFile = RepositoryResourceUtil.copyOSFileTOProject(mockProject, invalidPath, desFolder, version, overwrite,
                progressMonitor);
        assertNull(copiedFile);

        // TODO is not done
    }

    /**
     * Test for: getFolder(ERepositoryObjectType type, Item item)
     */
    @Test
    public void testGetFolderERepositoryObjectTypeItem() {
        fail("Not yet implemented");
    }
    
    @Ignore
    @Test
    public void testGetTextFileContent() throws Exception {
        String encode = "UTF-8";
        String filePath = "testfile.txt";//
        
        IFile mockFile = mock(IFile.class);
        IPath mockPath = mock(IPath.class);        
        when(mockFile.getLocation()).thenReturn(mockPath);
        when(mockFile.getLocation().toOSString()).thenReturn(filePath);
        when(mockFile.exists()).thenReturn(true);
        
        File file = mock(File.class);
        when(file.exists()).thenReturn(true);       
        PowerMockito.whenNew(File.class).withArguments(Mockito.anyString()).thenReturn(file);
        PowerMockito.doNothing().when(mockFile).refreshLocal(0, null);
        
        String textContent = "this is the test content!";
        byte[] buf = textContent.getBytes(encode);
        ByteArrayInputStream spyInputStream = PowerMockito.spy(new ByteArrayInputStream(buf));
        when(mockFile.getContents()).thenReturn(spyInputStream);
        
        ByteArrayOutputStream spyOutputStream = Mockito.spy(new ByteArrayOutputStream());
        PowerMockito.whenNew(ByteArrayOutputStream.class).withNoArguments().thenReturn(spyOutputStream);
        
        String content = RepositoryResourceUtil.getTextFileContent(mockFile, encode);
        assertEquals(textContent, content);
        
        verify(spyInputStream, Mockito.atLeastOnce()).close();
        verify(spyOutputStream, Mockito.atLeastOnce()).close();
    }

    @Test
    public void testFindReferenceFile() {
        fail("Not yet implemented");
    }

    /**
     * Test for: getFolder(ERepositoryObjectType type)
     * @throws Exception 
     */
    @Ignore
    @Test
    public void testGetFolderERepositoryObjectType() throws Exception {
        
        PowerMockito.mockStatic(ProjectManager.class);
        ProjectManager mockProjectManager = mock(ProjectManager.class);
        Project mockProject = mock(Project.class);
        IProject mockIProject = mock(IProject.class);
        when(ProjectManager.getInstance()).thenReturn(mockProjectManager);
        when(ProjectManager.getInstance().getCurrentProject()).thenReturn(mockProject);
        
        PowerMockito.mockStatic(ResourceModelUtils.class);
        PowerMockito.doReturn(mockIProject).when(ResourceModelUtils.class, "getProject", Mockito.any(Project.class));
//        when(ResourceModelUtils.getProject(Mockito.any(Project.class))).thenReturn(mockIProject);
        
        String folder = "folderA";
        PowerMockito.mockStatic(ERepositoryObjectType.class);
        when(ERepositoryObjectType.getFolderName(Mockito.any(ERepositoryObjectType.class))).thenReturn(folder);
        
        PowerMockito.mockStatic(ResourceUtils.class);
        when(ResourceUtils.getFolder(mockIProject, folder, true)).thenReturn(mock(IFolder.class));
        
        RepositoryResourceUtil.getFolder(Mockito.any(ERepositoryObjectType.class));
    }

    @Ignore
    @Test
    public void testCreateFolderViewObject() throws Exception {
        boolean isSystem = false;
        String folderName = "folderName";
        
        PowerMockito.mockStatic(ProjectManager.class);
        ProjectManager mockProjectManager = mock(ProjectManager.class);
        Project mockProject = mock(Project.class);
        IProject mockIProject = mock(IProject.class);
        when(ProjectManager.getInstance()).thenReturn(mockProjectManager);
        when(ProjectManager.getInstance().getCurrentProject()).thenReturn(mockProject);
        
        IFolder mockFolder = mock(IFolder.class); 
        PowerMockito.mockStatic(ResourceModelUtils.class);
        when(ResourceModelUtils.getProject(mockProject)).thenReturn(mockIProject);
        when(mockIProject.getFolder(Mockito.anyString())).thenReturn(mockFolder);
        when(mockFolder.exists()).thenReturn(false);
        PowerMockito.mockStatic(ResourceUtils.class);
        PowerMockito.doNothing().when(ResourceUtils.class, "createFolder", mockFolder);
        
        ItemState mockItemState = mock(ItemState.class);
        when(mockItemState.getPath()).thenReturn("mocked_path");
        
        PowerMockito.mockStatic(ERepositoryObjectType.class);
        when(ERepositoryObjectType.getFolderName(Mockito.any(ERepositoryObjectType.class))).thenReturn(folderName);
        
        
        Item mockItem = mock(Item.class);
        PowerMockito.spy(RepositoryResourceUtil.class);
        IRepositoryViewObject folderViewObject = RepositoryResourceUtil.createFolderViewObject(null, folderName, mockItem, isSystem);
        
        assertNotNull(folderViewObject);
    }
    

    @Test
    public void testCreateDeletedFolderViewObject() throws Exception {
        ERepositoryObjectType type = null;
        String path = "mocked_path";
        String folderName = "folderName";
        
        List<IRepositoryViewObject> children = new ArrayList<IRepositoryViewObject>();
        List<IRepositoryViewObject> spychildren = PowerMockito.spy(children);
        
        FolderRepositoryObject mockParentFolderObject = mock(FolderRepositoryObject.class);
        when(mockParentFolderObject.getChildren()).thenReturn(spychildren);
        
        PowerMockito.mockStatic(ContainerCacheService.class);
        PowerMockito.doNothing().when(ContainerCacheService.class, "putContainer", Mockito.any(IRepositoryViewObject.class));
        
        FolderRepositoryObject deletedFolderViewObject = RepositoryResourceUtil.createDeletedFolderViewObject(type, path, folderName, mockParentFolderObject);
        
        assertNotNull(deletedFolderViewObject);
    }


    /**
     * Test for: getCategoryViewObject(IRepositoryNodeConfiguration conf)
     */
    @Test
    public void testGetCategoryViewObject() throws Exception {
        IRepositoryNodeConfiguration mockConfiguration = mock(IRepositoryNodeConfiguration.class);
        
        IRepositoryNodeResourceProvider mockResourceProvider = mock(IRepositoryNodeResourceProvider.class);
        when(mockConfiguration.getResourceProvider()).thenReturn(mockResourceProvider);
        
        ERepositoryObjectType mockType = mock(ERepositoryObjectType.class);
        when(mockConfiguration.getResourceProvider().getRepositoryObjectType(Mockito.any(Item.class))).thenReturn(mockType);
        
        IRepositoryNodeLabelProvider mockLabelProvider = mock(IRepositoryNodeLabelProvider.class);
        when(mockConfiguration.getLabelProvider()).thenReturn(mockLabelProvider);
        when(mockConfiguration.getLabelProvider().getCategoryLabel(Mockito.any(ERepositoryObjectType.class))).thenReturn(Mockito.anyString());
        
        PowerMockito.mockStatic(ContainerCacheService.class);
        PowerMockito.doNothing().when(ContainerCacheService.class, "putContainer", Mockito.any(IRepositoryViewObject.class));
        
        IRepositoryViewObject categoryViewObject = RepositoryResourceUtil.getCategoryViewObject(mockConfiguration);
        assertNotNull(categoryViewObject);
    }

    @Test
    public void testRemoveViewObjectPhysically() {
        
    }

    /**
     * Test for: findAllViewObjects(ERepositoryObjectType type, boolean useRepositoryViewObject, boolean withDeleted)
     */
    @Test
    public void testFindAllViewObjects() {
        fail("Not yet implemented");
    }

    @Test
    public void testIsExistByName() {
        fail("Not yet implemented");
    }

    @Test
    public void testFindViewObjectByNameERepositoryObjectTypeString() {
        fail("Not yet implemented");
    }

    @Test
    public void testIsDeletedFolder() {
        fail("Not yet implemented");
    }

    /**
     * Test for: findViewObjects(ERepositoryObjectType type, Item parentItem, boolean useRepositoryViewObject, boolean withDeleted)
     */
    @Test
    public void testFindViewObjects4Args() {
        fail("Not yet implemented");
    }

    @Test
    public void testFindViewObjects5Args() {
        fail("Not yet implemented");
    }

    @Test
    public void testFindViewObjectsInFolderERepositoryObjectTypeItemBoolean() {
        fail("Not yet implemented");
    }

    @Test
    public void testFindViewObjectsInFolderERepositoryObjectTypeItemBooleanBoolean() {
        fail("Not yet implemented");
    }

    @Test
    public void testFindViewObjectByNameContainerItemStringBoolean() {
        fail("Not yet implemented");
    }

    @Test
    public void testFindViewObjectsByTypeERepositoryObjectTypeItemInt() {
        fail("Not yet implemented");
    }

    @Test
    public void testFindViewObjectsByTypeERepositoryObjectTypeItemIntBoolean() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetItemFromRepViewObj() {
        fail("Not yet implemented");
    }

    @Test
    public void testHasContainerItem() {
        fail("Not yet implemented");
    }

    @Test
    public void testConvertToNode() {
        fail("Not yet implemented");
    }

    @Test
    public void testIsOpenedInEditor() {
        fail("Not yet implemented");
    }

    @Test
    public void testCloseEditorIEditorReferenceBoolean() {
        fail("Not yet implemented");
    }

    @Test
    public void testCloseEditorIRepositoryViewObjectBoolean() {
        fail("Not yet implemented");
    }

    @Test
    public void testInitialize() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetTypeByPath() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetLastServerDefIRepositoryViewObject() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetLastServerDefItem() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetLastServerDef() {
        fail("Not yet implemented");
    }

    @Test
    public void testIsOpenedItemInEditor() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetBusinessConceptKey() {
        fail("Not yet implemented");
    }

}
