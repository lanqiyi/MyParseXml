package com.anjuke.minzhao.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NewParseXml {
	
	public static void main(String []args){	
		String subNode="engineSandBox";
		String FilePath="D:/workspace/MyParseXml/target.xml";
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		try{
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document doc=db.parse(FilePath);
			Element root=doc.getDocumentElement();
			NodeList cnode=root.getElementsByTagName(subNode);
			GetElement(cnode);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void GetElement(NodeList nodelist){
		int i;
		if(nodelist.getLength()==0){
			return;
		}
		else {
			for(i=0;i<nodelist.getLength();i++){
				Node node=nodelist.item(i);
				if(!(node.hasChildNodes())){
					System.out.println("name"+i+":"+node.getNodeName()+";value"+i+":"+node.getNodeValue()+" "+node.getNodeType());
				}
				else{
					NodeList subNodeList= node.getChildNodes();
					GetElement(subNodeList);
				}
			}
			return ;
		}
	}
	private static String GetValue(Node node) {
		// TODO Auto-generated method stub
		node.getNodeType();
		
		return null;
	}
}
