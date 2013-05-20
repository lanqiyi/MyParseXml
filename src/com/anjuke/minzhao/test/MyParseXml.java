package com.anjuke.minzhao.test;
/**
 *  Writer:minzhao
 *  通过Dom解析XML文件
 */
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

public class MyParseXml {
	public static void main(String []args){	
		String subNode="SearchEngine";
		String FilePath="D:/workspace/MyParseXml/target.xml";
		ParseDom(subNode,FilePath);
		//System.out.println(targetString);
	}
	public static void ParseDom(String subNode,String FilePath){
		NodeList nodelist;
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		try{
		DocumentBuilder db=dbf.newDocumentBuilder();
		Document doc=db.parse(FilePath);
		Element root=doc.getDocumentElement();
		nodelist=root.getElementsByTagName(subNode);
		System.out.println("总共有"+nodelist.getLength()+"个ren");
		GetElement(nodelist);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private static void GetElement(NodeList nodelist) {
		// TODO Auto-generated method stub
		Node cnode;
        int i;
        if (nodelist.getLength() == 0) {
            return;
        }
       
        for (i = 0; i < nodelist.getLength(); i++) {
            cnode = nodelist.item(i); 
            NamedNodeMap list=cnode.getAttributes();
            for(int z=0;z<list.getLength();z++){
            	System.out.println("name:"+list.item(z).getNodeName()+";value:"+list.item(z).getNodeValue());
            }
        }
    }
        

}
	