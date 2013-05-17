package com.anjuke.minzhao.test;
/**
 *  Writer:minzhao
 *  通过Dom解析XML文件
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class MyParseXml {
	public static void main(String []args){
		String[] targetString;
		String subNode="engineSandBox";
		targetString=read(subNode);
		System.out.println(targetString);
	}
	public static String[] read(String subNode){
		String tarNode="";
		String[] allNodes=new String[20];
		int i,num;
		DocumentBuilderFactory domFac=DocumentBuilderFactory.newInstance();
		try{
		DocumentBuilder domBuilder=domFac.newDocumentBuilder();	
		InputStream fileStream=new FileInputStream(new File("D:/workspace/MyParseXml/target.xml"));
		Document doc=domBuilder.parse(fileStream);
		Element root=doc.getDocumentElement();
		if(root==null) {return allNodes ;}
		//NodeList x=doc.getElementsByTagName(subNode);
		NodeList xNodes=root.getChildNodes();
		num=xNodes.getLength();
		System.out.println(num);
		for(i=0;i<num;i++)
		{
			Node y=xNodes.item(i);
			allNodes[i]=y.getNodeName();
		}
		}
		catch(Exception e) {  
			e.printStackTrace();
			System.out.println("NO WOrk");
		}
		return allNodes;
}
}


