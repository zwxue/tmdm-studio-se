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
package com.amalto.workbench.utils;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.axis.utils.IOUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDCompositor;
import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTypeDefinition;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.models.TreeParent;
import com.amalto.workbench.webservices.WSRoutingRuleExpression;
import com.amalto.workbench.webservices.WSRoutingRuleOperator;
import com.amalto.workbench.webservices.WSStringPredicate;
import com.amalto.workbench.webservices.WSWhereCondition;
import com.amalto.workbench.webservices.WSWhereOperator;

public class UtilTest {

	XSDSchema schema;
	@Before
	public void setUp() throws Exception {
		initSchema();
	}
    private TreeParent getServerRoot() {
        String serverName = "localhost";
        String universe = "";
        String username = "username";
        String password = "passwd";
        String endpointaddress = "http://localhost";
        TreeParent serverRoot = new TreeParent(serverName, null, TreeObject._SERVER_, endpointaddress, ("".equals(universe) ? ""//$NON-NLS-1$//$NON-NLS-2$
                : universe + "/") + username + ":" + (password == null ? "" : password));//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
        UserInfo user = new UserInfo();
        user.setUsername(username);
        user.setPassword(password);
        user.setServerUrl(endpointaddress);
        user.setUniverse(universe);

        serverRoot.setUser(user);
        return serverRoot;
    }
	private void initSchema()throws Exception{
        String xsd = null;
        xsd = "<xsd:schema xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">" + //$NON-NLS-1$
                "<xsd:import namespace=\"http://www.w3.org/2001/XMLSchema\"/>" + //$NON-NLS-1$
                "<xsd:element name=\"Entity\">" + //$NON-NLS-1$
                "<xsd:complexType>" + //$NON-NLS-1$
                "<xsd:all>" + //$NON-NLS-1$
                "<xsd:element name=\"id\" type=\"xsd:string\"/>" + //$NON-NLS-1$
                "<xsd:element maxOccurs=\"1\" minOccurs=\"0\" name=\"field1\" type=\"xsd:string\"/>" //$NON-NLS-1$
                + "<xsd:element maxOccurs=\"1\" minOccurs=\"0\" name=\"field2\" type=\"xsd:string\"/>"//$NON-NLS-1$
                + "<xsd:element maxOccurs=\"1\" minOccurs=\"0\" name=\"field3\" type=\"xsd:string\"/>"//$NON-NLS-1$
                + "<xsd:element maxOccurs=\"1\" minOccurs=\"0\" name=\"field4\" type=\"xsd:string\"/>"//$NON-NLS-1$
                + "<xsd:element maxOccurs=\"1\" minOccurs=\"0\" name=\"field5\" type=\"xsd:string\"/>"//$NON-NLS-1$
                + "<xsd:element maxOccurs=\"1\" minOccurs=\"0\" name=\"field6\" type=\"xsd:string\"/>" + //$NON-NLS-1$
                "</xsd:all>" + //$NON-NLS-1$
                "</xsd:complexType>" + //$NON-NLS-1$
                "<xsd:unique name=\"Entity\">" + "<xsd:selector xpath=\".\"/>" //$NON-NLS-1$ //$NON-NLS-2$
                + "<xsd:field xpath=\"id\"/>" + //$NON-NLS-1$
                "</xsd:unique>" + //$NON-NLS-1$
                "</xsd:element>" + //$NON-NLS-1$
                "</xsd:schema>";//$NON-NLS-1$

        schema = Util.getXSDSchema(xsd);
        
	}
	/**
     * Test method for
     * {@link com.amalto.workbench.utils.Util#getComplexTypeDefinitionChildren(org.eclipse.xsd.XSDComplexTypeDefinition, boolean)}
     * .
     */
    @Test
    public void testGetComplexTypeDefinitionChildren() throws Exception{
        
        // get test model
        XSDSchema xsdSchema = getXSDSchema();

        EList<XSDElementDeclaration> elementDeclarations = xsdSchema.getElementDeclarations();
        // test
        assertEquals(1, elementDeclarations.size());
        XSDTypeDefinition typeDefinition = elementDeclarations.get(0).getTypeDefinition();
        ArrayList<Object> children = Util.getComplexTypeDefinitionChildren((XSDComplexTypeDefinition) typeDefinition, true);
        assertEquals(3, children.size());
        children = Util.getComplexTypeDefinitionChildren((XSDComplexTypeDefinition) typeDefinition, false);
        assertEquals(1, children.size());
    }

    private XSDSchema getXSDSchema()throws Exception {
        InputStream in= UtilTest.class.getResourceAsStream("TestGetComplexTypeDefinitionChildren_0.1.xsd");
        try {
            byte[] buf = new byte[in.available()];
            IOUtils.readFully(in, buf);
            String xsdString = new String(buf);
            if (xsdString != null) {
                XSDSchema xsdSchema = Util.getXSDSchema(xsdString);
                return xsdSchema;
            }
            return null;
        } finally {
            in.close();
        }
    }

	@Test
	public void testJoinStrings() {
		String[] strs={"a","b"};
		String str=Util.joinStrings(strs, ";");
		assertEquals("a;b",str );
	}

	@Test
	public void testGetConceptFromPath() {
		String xpath="Entity/Id[aa>0]";
		String entity=Util.getConceptFromPath(xpath);
		assertEquals("Entity",entity );
	}

	@Test
	public void testGetConceptName() {
		XSDElementDeclaration el=schema.getElementDeclarations().get(0);
		XSDComplexTypeDefinition type= (XSDComplexTypeDefinition) el.getType();
		ArrayList<Object> children=Util.getComplexTypeDefinitionChildren(type);
		String concept=Util.getConceptName((XSDConcreteComponent)children.get(0));
		assertEquals("Entity",concept );
	}

	@Test
	public void testNodeToString()throws Exception {
		String xml="<a>a</a>";
		Node node=Util.parse(xml).getDocumentElement();
		String xml2=Util.nodeToString(node);
		assertEquals(xml2.trim(), xml);
	}

	@Test
	public void testGetNodeList()throws Exception {
		String xml="<node><id>id</id><name>name</name></node>";
		Node node=Util.parse(xml).getDocumentElement();
		NodeList list=Util.getNodeList(node, "id");
		assertEquals(list.item(0).getNodeName(),"id");
	}

	@Test
	public void testGetRootElement() throws Exception {
		Element root=Util.getRootElement("elementName", "namespace", null);
		assertEquals(root.getNamespaceURI(),"namespace");
	}

	@Test
	public void testParse() throws Exception {
		String xml="<a>a</a>";
		Document d=Util.parse(xml);
		assertEquals(d.getDocumentElement().getNodeName(), "a");
	}

	@Test
	public void testGetAllCustomSimpleDataType() {
		List<String> list=Util.getAllCustomSimpleDataType(schema);
		assertEquals(list.size(),0);
	}

	@Test
	public void testGetAllSchemaSimpleDataType() {
		List<String> list=Util.getAllSchemaSimpleDataType(schema);
		assertEquals(list.size(),56);
	}

	@Test
	public void testGetKeyInfo() {
		List<Object> list=Util.getKeyInfo(schema.getElementDeclarations().get(0));
		assertEquals(list, null);
	}


	@Test
	public void testGetForeingKeyInSchema() {
		Set<String> list=new HashSet<String>();
		Util.getForeingKeyInSchema(list, schema);
		assertEquals(list.size(), 0);
	}

	@Test
	public void testGetChildElementNames()throws Exception {
		List<String> list=Util.getChildElementNames(schema, "Entity");
		assertEquals(list.size(), 7);
		assertEquals(list.get(0), "Entity/id");
	}

	@Test
	public void testConvertWhereCondition() {
		WSWhereCondition wc=new WSWhereCondition("Entity/Id", WSWhereOperator.CONTAINS, "id1", WSStringPredicate.OR, false);
		String[] lines=Util.convertWhereCondition(wc);
		assertEquals(lines.length, 4);
		assertEquals(lines[0], "Entity/Id");
		assertEquals(lines[1], "Contains");
		assertEquals(lines[2], "id1");
		assertEquals(lines[3], "Or");
	}

	@Test
	public void testConvertRoleWhereCondition(){
		RoleWhereCondition rc=new RoleWhereCondition();
		rc.setLeftPath("Entity/Id");
		rc.setOperator("Contains");
		rc.setRightValueOrPath("id1");
		rc.setPredicate("Or");
		
		String[] lines=Util.convertRoleWhereCondition(rc);
		assertEquals(lines.length, 4);
		assertEquals(lines[0], "Entity/Id");
		assertEquals(lines[1], "Contains");
		assertEquals(lines[2], "id1");
		assertEquals(lines[3], "Or");
	}
	@Test
	public void testConvertRouteCondition(){
		WSRoutingRuleExpression wr=new WSRoutingRuleExpression("name","Entity/Id",WSRoutingRuleOperator.CONTAINS, "value");
		String[] lines=Util.convertRouteCondition(wr);
		assertEquals(lines.length, 4);
		assertEquals(lines[0], "Entity/Id");
		assertEquals(lines[1], "Contains");
		assertEquals(lines[2], "value");
		assertEquals(lines[3], "name");
		
	}
	@Test
	public void testConvertLineRoute(){
		String[] values={"Entity/Id","Contains","value","name"};
		WSRoutingRuleExpression wr=Util.convertLineRoute(values);
		assertEquals(wr.getXpath(), "Entity/Id");
		assertEquals(wr.getWsOperator().getValue(), "CONTAINS");
		assertEquals(wr.getValue(), "value");
		assertEquals(wr.getName(), "name");
	}
	@Test
	public void testConvertLine(){
		String[] values={"Entity/Id","Contains","id1","Or"};
		WSWhereCondition wc=Util.convertLine(values);
		assertEquals(wc.getLeftPath(), "Entity/Id");
		assertEquals(wc.getOperator().getValue(), "CONTAINS");
		assertEquals(wc.getRightValueOrPath(), "id1");
		assertEquals(wc.getStringPredicate().getValue(), "OR");
	}
	@Test
	public void testConvertLineToRC(){
		String[] values={"Entity/Id","Contains","id1","Or"};
		RoleWhereCondition wc=Util.convertLineToRC(values);
		assertEquals(wc.getLeftPath(), "Entity/Id");
		assertEquals(wc.getOperator(), "Contains");
		assertEquals(wc.getRightValueOrPath(), "id1");
		assertEquals(wc.getPredicate(), "Or");
	}

	@Test
	public void testGetItemContent() {
		String xmlstring="<c>Entity></c><t>1313434343</t><p>abcdefg</p>";
		String xml=Util.getItemContent(xmlstring);
		assertEquals(xml, "abcdefg");
		xmlstring="<c>Entity></c><t>1313434343</t><p/>";
		xml=Util.getItemContent(xmlstring);
		assertEquals(xml, "");
	}

	@Test
	public void testGetAllComplexTypeChildren() {
		ArrayList<Object> list=Util.getAllComplexTypeChildren(schema.getElementDeclarations().get(0));
		assertEquals(list.size(), 1);
	}

	@Test
	public void testGetConcepts() {
		List<String> list=Util.getConcepts(schema);
		assertEquals(list.size(), 1);
		assertEquals(list.get(0), "Entity");
	}

	@Test
	public void testGetNewLabelString() {
		String oldString="Routing Engine V2";
		String newLabel=Util.getNewLabelString(oldString);
		assertEquals("Event Manager", newLabel);
	}

	@Test
	public void testCheckInCOpyTypeParticle() {
		Object[] sel={schema.getElementDeclarations().get(0)};
		boolean ret=Util.checkInCOpyTypeParticle(sel);
		assertEquals(ret, false);
	}

	@Test
	public void testCheckInCopyTypeElement() {
		Object[] sel={schema.getElementDeclarations().get(0)};
		boolean ret=Util.checkInCopyTypeElement(sel);
		assertEquals(ret, true);
	}

	@Test
	public void testGetParticleName() {
		XSDComplexTypeDefinition complexType= (XSDComplexTypeDefinition)schema.getElementDeclarations().get(0).getTypeDefinition();
		XSDModelGroup group=(XSDModelGroup)((XSDParticle)complexType.getContent()).getTerm();
		String name=Util.getParticleName(group.getParticles().get(0));
		assertEquals(name, "id");
	}

	@Test
	public void testGetParticleReferenceName() {
		XSDComplexTypeDefinition complexType= (XSDComplexTypeDefinition)schema.getElementDeclarations().get(0).getTypeDefinition();
		XSDModelGroup group=(XSDModelGroup)((XSDParticle)complexType.getContent()).getTerm();
		XSDParticle curXSDParticle= group.getParticles().get(0);
		String name=Util.getParticleReferenceName(curXSDParticle);
		assertEquals(name, "");
	}

	@Test
	public void testGetAllCustomTypeNames() {
		List<String> list=Util.getAllCustomTypeNames(schema);
		assertEquals(list.size(), 4);
	}

	@Test
	public void testIsUUID() {
		boolean ret=Util.isUUID(schema.getElementDeclarations().get(0));
		assertEquals(ret, false);
	}

	@Test
	public void testIsCustomrType() {
		boolean ret=Util.isCustomrType(schema, "id");
		assertEquals(ret, false);
	}

	@Test
	public void testGetAllBuildInTypes() {
		List<XSDSimpleTypeDefinition> list=Util.getAllBuildInTypes(schema);
		assertEquals(list.size(), 56);
	}

	@Test
	public void testIsBuildInType() {
		XSDComplexTypeDefinition complexType= (XSDComplexTypeDefinition)schema.getElementDeclarations().get(0).getTypeDefinition();
		XSDModelGroup group=(XSDModelGroup)((XSDParticle)complexType.getContent()).getTerm();
		XSDElementDeclaration el= (XSDElementDeclaration)group.getParticles().get(0).getTerm();
		boolean ret=Util.isBuildInType((XSDSimpleTypeDefinition)el.getType());
		assertEquals(ret, true);
	}

	@Test
	public void testIsSequenceComplexType() {
		XSDComplexTypeDefinition complexType= (XSDComplexTypeDefinition)schema.getElementDeclarations().get(0).getTypeDefinition();
		boolean ret=Util.isSequenceComplexType(complexType);
		assertEquals(ret, false);
	}

	@Test
	public void testIsAllComplexType() {
		XSDComplexTypeDefinition complexType= (XSDComplexTypeDefinition)schema.getElementDeclarations().get(0).getTypeDefinition();
		boolean ret=Util.isAllComplexType(complexType);
		assertEquals(ret, true);
	}

	@Test
	public void testIsChoiceComplexType() {
		XSDComplexTypeDefinition complexType= (XSDComplexTypeDefinition)schema.getElementDeclarations().get(0).getTypeDefinition();
		boolean ret=Util.isChoiceComplexType(complexType);
		assertEquals(ret, false);
	}

	@Test
	public void testGetComplexTypeGroupType() {
		XSDComplexTypeDefinition complexType= (XSDComplexTypeDefinition)schema.getElementDeclarations().get(0).getTypeDefinition();
		XSDCompositor compositor=Util.getComplexTypeGroupType(complexType);
		assertEquals(compositor.getName(), "all");
	}

	@Test
	public void testUpdateChildrenReferenceToComplexType() {
		XSDComplexTypeDefinition complexType= (XSDComplexTypeDefinition)schema.getElementDeclarations().get(0).getTypeDefinition();
		Util.updateChildrenReferenceToComplexType(complexType);
	}

	@Test
	public void testGetParentTypes() {
		XSDComplexTypeDefinition complexType= (XSDComplexTypeDefinition)schema.getElementDeclarations().get(0).getTypeDefinition();
		List<XSDTypeDefinition> list=Util.getParentTypes(complexType);
		assertEquals(list.size(), 1);
	}

	@Test
	public void testIsDouble() {
		XSDComplexTypeDefinition complexType= (XSDComplexTypeDefinition)schema.getElementDeclarations().get(0).getTypeDefinition();
		XSDModelGroup group=(XSDModelGroup)((XSDParticle)complexType.getContent()).getTerm();
		XSDElementDeclaration el= (XSDElementDeclaration)group.getParticles().get(0).getTerm();
		boolean ret=Util.isDouble((XSDSimpleTypeDefinition)el.getTypeDefinition());
		assertEquals(ret, false);
	}

	@Test
	public void testIsFloat() {
		XSDComplexTypeDefinition complexType= (XSDComplexTypeDefinition)schema.getElementDeclarations().get(0).getTypeDefinition();
		XSDModelGroup group=(XSDModelGroup)((XSDParticle)complexType.getContent()).getTerm();
		XSDElementDeclaration el= (XSDElementDeclaration)group.getParticles().get(0).getTerm();
		boolean ret=Util.isFloat((XSDSimpleTypeDefinition)el.getTypeDefinition());
		assertEquals(ret, false);
	}

	@Test
	public void testIsDecimal() {
		XSDComplexTypeDefinition complexType= (XSDComplexTypeDefinition)schema.getElementDeclarations().get(0).getTypeDefinition();
		XSDModelGroup group=(XSDModelGroup)((XSDParticle)complexType.getContent()).getTerm();
		XSDElementDeclaration el= (XSDElementDeclaration)group.getParticles().get(0).getTerm();
		boolean ret=Util.isDecimal((XSDSimpleTypeDefinition)el.getTypeDefinition());
		assertEquals(ret, false);
	}

	@Test
	public void testIsSpecifiedBuildInType() {
		XSDComplexTypeDefinition complexType= (XSDComplexTypeDefinition)schema.getElementDeclarations().get(0).getTypeDefinition();
		XSDModelGroup group=(XSDModelGroup)((XSDParticle)complexType.getContent()).getTerm();
		XSDElementDeclaration el= (XSDElementDeclaration)group.getParticles().get(0).getTerm();
		boolean ret=Util.isSpecifiedBuildInType((XSDSimpleTypeDefinition)el.getTypeDefinition(), "string");
		assertEquals(ret, true);
	}


	@Test
	public void testFormatErrorMessage() {
		String sourceMessage="[aaa]:3:5:a: ";
		String xml=Util.formatErrorMessage(sourceMessage);
		assertEquals(xml, sourceMessage);
		
	}	
}
