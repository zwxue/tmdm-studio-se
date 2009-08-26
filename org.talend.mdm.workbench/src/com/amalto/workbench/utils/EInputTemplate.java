package com.amalto.workbench.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum EInputTemplate {
	APPLICATION_ITEMPK(EContentType.APPLICATION_ITEMPK.getName(),"<item-pOJOPK><concept-name>?</concept-name><ids>?</ids><data-cluster-pOJOPK><ids>?</ids></data-cluster-pOJOPK></item-pOJOPK>"),
	//batchproject,codec,crossreferencing,csvparser,fixedlengthparser,groupedlinesreader,
	//linereader,partialupdate,project,regexp,replace,route,tisCall,xpath,xslt
	
	//transformer parameters
	BATCHPROJECT("batchproject","<parameters>\n\t\t<dataClusterName>?</dataClusterName>\n\t\t<dataModelName>?</dataModelName>\n\t\t<conceptName>?</conceptName>\n</parameters>"),
	CODEC("codec","<parameters>\n\t\t<method>?</method>\n\t\t<algorithm>?</algorithm>\n</parameters>"),
	CROSSREFERENCING("crossreferencing","<parameters>\n\t\t<CrossRef>\n\t\t\t<xrefName>?</xrefName>\n\t\t\t<xrefCluster>?</xrefCluster>\n\t\t\t<xrefRootElement>?</xrefRootElement>\n\t\t\t<xrefIn>\n\t\t\t\t<mapping>\n\t\t\t\t\t<xrefElement>?</xrefElement>\n\t\t\t\t\t<xrefPath>?</xrefPath>\n\t\t\t\t</mapping>\n\t\t\t</xrefIn>\n\t\t\t<xrefOut>\n\t\t\t\t<mapping>\n\t\t\t\t\t<xrefElement>?</xrefElement>\n\t\t\t\t\t<xrefPath>?</xrefPath>\n\t\t\t\t</mapping>\n\t\t\t</xrefOut>\n\t\t</CrossRef>\n</parameters>"),
	CSVPARSER("csvparser","<parameters>\n\t\t<separator>?</separator>\n\t\t<headersOnFirstLine>?</headersOnFirstLine>\n\t\t<template>\n\t\t<![CDATA[\n\t\t\t<MyXml>\n\t\t\t\t\t<Field1>?</Field1>\n\t\t\t\t\t<Combo>?</Combo>\n\t\t\t\t\t<NotInterpreted>?</NotInterpreted>\n\t\t\t\t\t<HeaderReference>?</HeaderReference>\n\t\t\t\t\t[LOOP lineNumber.*]\n\t\t\t\t\t<Line>\n\t\t\t\t\t\t\t<Quantity>?</Quantity> \n\t\t\t\t\t</Line>\n\t\t\t\t\t[/LOOP] \n\t\t\t</MyXml>\n\t\t]]>\n\t\t</template>\n</parameters>"),
	FIXEDLENGTHPARSER("fixedlengthparser","<parameters>\n\t\t<template>\n\t\t\t<MyXml>\n\t\t\t\t\t<Field1>?</Field1> \n\t\t\t\t\t<Combo>?</Combo>\n\t\t\t\t\t<NotInterpreted>?</NotInterpreted>\n\t\t\t</MyXml>\n\t\t</template>\n</parameters>"),
	GROUPEDLINESREADER("groupedlinesreader","<parameters>\n                 <ignoreFirstLines>?</ignoreFirstLines>\n                 <type>?</type>\n                 <position>?</position>\n                 <separator>?</separator>\n\n</parameters>"),
	LINEREADER("linereader","<parameters>\n\t\t<ignoreFirstLines>?</ignoreFirstLines>\n</parameters>"),
	PARTIALUPDATE("partialupdate","<parameters>\n\t\t<pivot>?</pivot>\n\t\t<overwrite>?</overwrite>\n\t\t<keyXPath>?</keyXPath>\n\t\t<startingPosition>?</startingPosition>\n\t\t<dataCluster>?</dataCluster>\n\t\t<dataModel>?</dataModel>\n</parameters>"),
	PROJECT("project","<parameters>\n\t\t<defaultDataCluster>?</defaultDataCluster>\n\t\t<defaultDataModel>?</defaultDataModel>\n\t\t<overwrite>?</overwrite>\n</parameters>"),
	REGEXP("regexp","<parameters>\n\t\t<regexp>?</regexp>\n\t\t<contentType>?</contentType>\n\t\t<resultPattern><![CDATA[\n\t\t\t\t<result>?</result>\n\t\t]]></resultPattern>\n</parameters>"),
	REPLACE("replace","<parameters>\n\t\t<regexp>?</regexp>\n\t\t<contentType>?</contentType>\n\t\t<replacement>?</replacement>\n</parameters>"),
	ROUTE("route",""),
	TISCALL("tisCall","<configuration>\n\t\t<url>?</url>\n\t\t<contextParam>\n\t\t\t<name>?</name>\n\t\t\t<value>?</value>\n\t\t</contextParam>\n\t\t<contextParam>\n\t\t\t<name>?</name>\n\t\t\t<value>?</value>\n\t\t</contextParam>\n\t\t<contextParam>\n\t\t\t<name>?</name>\n\t\t\t<value>?</value>\n\t\t</contextParam>\n\t\t<username>?</username>\n\t\t<password>?</password>\n\t\t<conceptMapping>\n\t\t\t<concept>?</concept>\n\t\t\t<fields>?</fields>\n\t\t</conceptMapping>\n</configuration>\n\n\n"),
	XPATH("xpath","<parameters>\n\t\t<xPath>?</xPath>\n\t\t<contentType>?</contentType>\n</parameters>"),
	XSLT("xslt","<Country\n\t\t\txrefCluster='?' \n\t\t\txrefIn='?' \n\t\t\txrefOut='?'\n\t>\n\t\t\t<xsl:value-of select='?'/>\n</Country>\n\n"),
	
	//calltransformer, dumptoconsole, itemdispatcher, jdbc, logging, loggingsmtp, svn
	CALLTRANSFORMER("calltransformer","transformer=?"),
	DUMPTOCONSOLE("dumptoconsole",""),
	ITEMDISPATCHER("itemdispatcher","<parameters>\n\t<transformer>\n\t\t<allInOne>?</allInOne>\n\t\t<assignTo>?</assignTo>\n\t</transformer>\n</parameters>"),
	JDBC("jdbc","<parameters>\n\t<driverClassName>?</driverClassName>\n\t<url>?</url>\n\t<username>?</username>\n\t<password>?</password>\n\t<transformer>?</transformer>\n</parameters>"),
	LOGGING("logging",""),
	LOGGINGSMTP("loggingsmtp","<parameters>\n\t<from>?</from>\n\t<to>?</to>\n\t<cc>?</cc>\n\t<bcc>?</bcc>\n\t<logFileName>?</logFileName>\n\t<subjectprefix>?</transformer>\n\t<logfilename>?</logfilename>\n\t<transformer>?</transformer>\n</parameters>"),
	SVN("svn","");
	
	
	String name;
	String content;
	EInputTemplate(String name, String content){
		this.name=name;
		this.content=content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public static Set<String> allTemplates(){
		Set<String> list=new HashSet<String>();
		for(EInputTemplate type:values()){
			list.add(type.name);
		}
		return list;
	}
	
	public static Map<String ,EInputTemplate> getXtentisObjexts(){
		
		Map<String,EInputTemplate> map=new HashMap<String, EInputTemplate>();
		for(int i=0; i<values().length; i++){
			map.put(String.valueOf(values()[i].getName()), values()[i]);
		}
		return map;
	}
}
