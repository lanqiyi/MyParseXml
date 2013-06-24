package com.anjuke.minzhao.test;
import java.util.Scanner; //导入输入类




public class StringTest {
	public static void main(String[] args) {
		  
		  //创建输入对象
		  Scanner sc=new Scanner(System.in);
		  
		  //获取用户输入的字符串
		  String str=null;
		  System.out.print("请输入任意字符:");
		  str=sc.nextLine();
		  
		  System.out.println("你输入的字符为:"+str);
		  
		 }
}
