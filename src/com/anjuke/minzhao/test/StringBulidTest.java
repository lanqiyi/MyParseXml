package com.anjuke.minzhao.test;
import java.util.*;
import java.util.regex.*;

public class StringBulidTest {


public static void main(String args[]) {
	
    //String str = "title=d\rdescription1=e\rdescription2=f"; 
    class Weixueyuan{
    	String title=new String("d");
    	String description1 = "e";
    	String des = "f";
    	public void say(){
            System.out.println("title��ֵ"+ title+"");
            System.out.println("description1��ֵ"+ description1+"");
            //System.out.println("description2��ֵ"+ des);
            System.out.println("");��
        }
    }
    Weixueyuan obj1=new Weixueyuan();  //���������ͬʱ���г�ʼ��
    obj1.say();
    

}
}
