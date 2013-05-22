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
	
	// 等号前后都需要加一个空格，这样 : int i = 0;
	public static void main(String []args) {	
		String subNode="onlineManager";
		String FilePath="D:/workspace/MyParseXml/target.xml";
		
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document doc=db.parse(FilePath);
			Element root=doc.getDocumentElement();
			NodeList cnode=doc.getElementsByTagName(subNode);
			System.out.println("���ĵ���������"+subNode+"�Ĺؼ��ʸ���Ϊ��"+cnode.getLength());
			GetElement(cnode);
		}
		catch(Exception e) {
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
				System.out.println(nodelist.getLength());
				Node node=nodelist.item(i);
				if(!(node.hasChildNodes())){
					System.out.println("�ڵ�����"+i+":"+node.getNodeName()+";value"+i+":"+node.getNodeValue());
				}
				else{
					NodeList subNodeList= node.getChildNodes();
					GetElement(subNodeList);
				}
				if(!(node.hasAttributes())){
					System.out.println("this node has no attributes");
				}
				else{
					System.out.println("the attributes of this node are:");
					for(int j=0;j<node.getAttributes().getLength();j++){
						System.out.println(node.getAttributes().item(j));
					}
				}
			}
			return ;
		}
	}

}
