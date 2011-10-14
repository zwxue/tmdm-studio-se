// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
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

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.ui.editor.DiagramEditorFactory;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDXPathDefinition;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.form.model.components.ComponentsFactory;
import org.talend.mdm.form.model.components.TextField;
import org.talend.mdm.form.model.mdmform.Component;
import org.talend.mdm.form.model.mdmform.MdmformFactory;
import org.talend.mdm.form.model.mdmform.Panel;
import org.talend.mdm.repository.core.IRepositoryNodeActionProvider;
import org.talend.mdm.repository.core.IRepositoryNodeConfiguration;
import org.talend.mdm.repository.core.service.RepositoryQueryService;
import org.talend.mdm.repository.extension.RepositoryNodeConfigurationManager;
import org.talend.mdm.repository.model.mdmserverobject.WSDataModelE;
import org.talend.mdm.repository.models.CustomFormElement;
import org.talend.mdm.repository.ui.editors.IRepositoryViewEditorInput;

import com.amalto.workbench.utils.Util;
import com.amalto.workbench.utils.XtentisException;
import com.amalto.workbench.webservices.WSConceptKey;
import com.amalto.workbench.webservices.WSGetBusinessConceptKey;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class CustomFormUtil {

    private static final String DIAGRAM_PROVIDER_ID = "org.talend.mdm.form.editor.type.provider"; //$NON-NLS-1$

    private static Logger log = Logger.getLogger(CustomFormUtil.class);

    public void createDomainModel(IFile diagramFile, String diagramName, final List<CustomFormElement> allElements,
            final CustomFormElement ancestor,
            final int columnCount) {
        final TransactionalEditingDomain editingDomain = DiagramEditorFactory.createResourceSetAndEditingDomain();
        URI diagramFileUri = URI.createFileURI(diagramFile.getLocation().toOSString());
        final Resource resource = editingDomain.getResourceSet().createResource(diagramFileUri);
        final CommandStack commandStack = editingDomain.getCommandStack();

        final Diagram diagram = createDiagram(diagramName);

        commandStack.execute(new RecordingCommand(editingDomain) {

            @Override
            protected void doExecute() {
                resource.setTrackingModification(true);
                resource.getContents().add(diagram);
                IDiagramTypeProvider dtp = GraphitiUi.getExtensionManager().createDiagramTypeProvider(diagram,
                        DIAGRAM_PROVIDER_ID); //$NON-NLS-1$

                IFeatureProvider featureProvider = dtp.getFeatureProvider();
                // create column
                Panel containeModel = MdmformFactory.eINSTANCE.createPanel();
                PictogramElement fistColumn = createColumn(featureProvider, columnCount, containeModel.getChildren(), diagram,
                        ancestor);
                // element
                Integer h = 5;
                if (fistColumn != null) {
                    h = createElements(featureProvider, allElements, fistColumn, h);
                }
                // reset first column's height
                IGaService gaService = Graphiti.getGaService();

                gaService.setHeight(fistColumn.getGraphicsAlgorithm(), Math.max(h, 200));
            }
        });

        // resource.getContents().addAll(containeModel.getChildren());
        try {
            resource.save(new HashMap());
        } catch (IOException e) {

        }
    }

    public static void openCustomForm(IRepositoryViewObject viewObject) {
        if (viewObject == null)
            return;
        IRepositoryNodeConfiguration configuration = RepositoryNodeConfigurationManager.getConfiguration(viewObject);
        if (configuration != null) {
            IRepositoryNodeActionProvider actionProvider = configuration.getActionProvider();
            if (actionProvider != null) {
                IRepositoryViewEditorInput editorInput = actionProvider.getOpenEditorInput(viewObject);
                IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                try {
                    page.openEditor(editorInput, editorInput.getEditorId());
                } catch (PartInitException e) {
                }
            }
        }

    }
    public static WSConceptKey getBusinessConceptKey(WSGetBusinessConceptKey businessConcepKey) throws RemoteException,
            XtentisException {
        String pk = businessConcepKey.getWsDataModelPK().getPk();
        String concept = businessConcepKey.getConcept();
        WSDataModelE dataModel = RepositoryQueryService.findDataModelByName(pk);
        if (dataModel != null) {
            try {
                XSDSchema xsdSchema = Util.getXSDSchema(dataModel.getXsdSchema());
                for (XSDIdentityConstraintDefinition idDef : xsdSchema.getIdentityConstraintDefinitions()) {

                    if (idDef.getName().equals(concept)) {
                        WSConceptKey key = new WSConceptKey();
                        //
                        XSDXPathDefinition selector = idDef.getSelector();
                        key.setSelector(selector.getValue());
                        //
                        EList<XSDXPathDefinition> fields = idDef.getFields();
                        String[] keyFields = new String[fields.size()];
                        int i = 0;
                        for (XSDXPathDefinition pathDef : fields) {
                            keyFields[i] = pathDef.getValue();
                            i++;
                        }
                        key.setFields(keyFields);
                        return key;
                    }
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        return null;
    }
    private Diagram createDiagram(String diagramName) {
        Diagram diagram = Graphiti.getPeCreateService().createDiagram("mdmform", diagramName, true); //$NON-NLS-1$
        return diagram;
    }

    private PictogramElement createColumn(IFeatureProvider featureProvider, int col, List<Component> columns, Diagram diagram,
            CustomFormElement ancestor) {
        PictogramElement firstColumn = null;
        int x = 10;
        for (int i = 0; i < col; i++) {
            // domain model
            Panel column = MdmformFactory.eINSTANCE.createPanel();
            column.setLabel("");
            columns.add(column);
            // pe
            AddContext context = new AddContext();
            context.setNewObject(column);
            context.setTargetContainer(diagram);
            //
            context.setX(x);
            context.setY(20);
            x += 320;
            IAddFeature feature = featureProvider.getAddFeature(context);
            if (feature != null && feature.canAdd(context)) {
                PictogramElement columnPe = feature.add(context);
                if (firstColumn == null) {
                    firstColumn = columnPe;
                    column.setCanMove(ancestor.isCanMove());
                }
            }
        }
        return firstColumn;
    }

    private int createElements(IFeatureProvider featureProvider, List<CustomFormElement> allElements,
            PictogramElement columnElement, int h) {
        Panel columnModel = (Panel) columnElement.getLink().getBusinessObjects().get(0);
        int x = 5;
        int y = 5;
        h += 5;
        for (CustomFormElement formE : allElements) {
            Component domainModel = null;
            if (formE.getType() == null) {
                Panel panel = MdmformFactory.eINSTANCE.createPanel();
                panel.setCanMove(formE.isCanMove());
                domainModel = panel;
            } else {
                TextField textField = ComponentsFactory.eINSTANCE.createTextField();

                domainModel = textField;
            }
            // model
            domainModel.setLabel(formE.getName());
            domainModel.setMinOccurs(formE.getMinOccurs());
            domainModel.setMaxOccurs(formE.getMaxOccurs());
            domainModel.setXpath(formE.getXpath());
            domainModel.setIsKey(formE.isKey());
            columnModel.getChildren().add(domainModel);
            domainModel.setParent(columnModel);
            // pe
            AddContext context = new AddContext();
            context.setX(x);
            context.setY(y);
            context.setNewObject(domainModel);
            if (formE.getType() == null && formE.getChildren() != null) {
                // set the child panel's size
                int height = formE.getChildren().size() * 25 + 10;
                height = Math.min(height, 200);
                context.setHeight(height);
                context.setWidth(300 - 10);
                h += 5 + height;
                y += 5 + height;
            } else {
                h += 20 + 5;
                y += 20 + 5;
            }
            context.setTargetContainer((ContainerShape) columnElement);
            IAddFeature feature = featureProvider.getAddFeature(context);
            if (feature != null && feature.canAdd(context)) {
                PictogramElement childPanel = feature.add(context);
                if (formE.getType() == null && formE.getChildren() != null) {
                    createElements(featureProvider, formE.getChildren(), childPanel, h);
                }
            }
        }
        return h;
    }

}
