package com.anjuke.minzhao.test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;


/*在notepad++里面自动添加编号*/
public class autoAddNum {
	public static void main(String[] args) {
      
        try { 
        	 String sourcefile = "E:/项目/15227[导航]用户端合并/二级导航对应的列表页和单页搜索样式.feature";
        	 BufferedReader br=new BufferedReader(new FileReader(sourcefile));
        	 FileWriter fw =new FileWriter("E:/项目/15227[导航]用户端合并/test.feature");
        	 BufferedWriter bw=new BufferedWriter(fw); 
        	 String r = br.readLine();
        	 String str ="@";
        	int count =1;
        	while(r != null){
        		if(r.contains(str)){
        			//System.out.println(r);
        			String RowArray[] = r.split(" ");
        			String[]  Row = RowArray[1].split("@");
        			int number = Integer.parseInt(Row[1]);
        			if (count != number){
        				number =count;
        				System.out.println(number);
        			}
        			r.replace(Row[1], String.valueOf(number));
        			System.out.println(r);
        			count++;
        			
        	}
        		bw.write(r);
        		bw.newLine();
        		r =br.readLine();
        	}
        	 br.close();
        	 fw.close();
        }
        catch(Exception e)  {
        	System.out.println("no work");
        	e.printStackTrace();
        } 
    }
}
