package com.anjuke.minzhao.test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;


/*��notepad++�����Զ���ӱ��*/
public class autoAddNum {
	public static void main(String[] args) {
      
        try { 
        	 String sourcefile = "E:/��Ŀ/15227[����]�û��˺ϲ�/����������Ӧ���б�ҳ�͵�ҳ������ʽ.feature";
        	 BufferedReader br=new BufferedReader(new FileReader(sourcefile));
        	 FileWriter fw =new FileWriter("E:/��Ŀ/15227[����]�û��˺ϲ�/test.feature");
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
