package org.talend.mdm.repository.ui.actions.process;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.ItemState;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.model.mdmproperties.ContainerItem;
import org.talend.mdm.repository.model.mdmproperties.MdmpropertiesFactory;
import org.talend.mdm.repository.model.mdmproperties.WSTransformerV2Item;
import org.talend.mdm.repository.model.mdmproperties.impl.MdmpropertiesFactoryImpl;
import org.talend.mdm.repository.model.mdmproperties.impl.WSTransformerV2ItemImpl;
import org.talend.mdm.repository.ui.actions.AbstractSimpleAddActionTest;
import org.talend.mdm.repository.utils.RepositoryResourceUtil;
import org.talend.repository.ProjectManager;

import com.amalto.workbench.MDMWorbenchPlugin;
import com.amalto.workbench.exadapter.ExAdapterManager;
import com.amalto.workbench.image.ImageCache;

@PrepareForTest({ ImageDescriptor.class, JFaceResources.class, ImageCache.class, ItemState.class, CoreRuntimePlugin.class,
        ProjectManager.class, RepositoryNodeConfigurationManager.class, ProxyRepositoryFactory.class,
        RepositoryResourceUtil.class, ExAdapterManager.class, MdmpropertiesFactoryImpl.class,
        MDMWorbenchPlugin.class })
public class NewProcessActionTest extends AbstractSimpleAddActionTest {

    @Test
    public void testCreateServerObject() throws Exception {
        //
        ContainerItem newItem = MdmpropertiesFactory.eINSTANCE.createContainerItem();
        ContainerItem mockContainerItem = spy(newItem);

        PowerMockito.mockStatic(MDMWorbenchPlugin.class);
        when(MDMWorbenchPlugin.getImageDescriptor(anyString())).thenReturn(mock(ImageDescriptor.class));

        NewProcessAction action = new NewProcessAction();
        NewProcessAction spyAction = spy(action);

        Whitebox.setInternalState(spyAction, "parentItem", mockContainerItem); //$NON-NLS-1$
        ItemState itemState = mock(ItemState.class);
        when(mockContainerItem.getState()).thenReturn(itemState);
        when(mockContainerItem.getState().getPath()).thenReturn(""); //$NON-NLS-1$

        WSTransformerV2Item item = MdmpropertiesFactory.eINSTANCE.createWSTransformerV2Item();
        WSTransformerV2Item spyTransformerV2Item = spy(item);
        Resource mockResource = mock(Resource.class);
        ResourceSet mockResourceSet = mock(ResourceSet.class);
        when(mockResource.getResourceSet()).thenReturn(mockResourceSet);
        when(spyTransformerV2Item.eResource()).thenReturn(mockResource);
        PowerMockito.whenNew(WSTransformerV2ItemImpl.class).withNoArguments()
                .thenReturn((WSTransformerV2ItemImpl) spyTransformerV2Item);

        // run
        Item addedItem = spyAction.createServerObject("abc"); //$NON-NLS-1$
        assertThat(addedItem, notNullValue());

    }

}
