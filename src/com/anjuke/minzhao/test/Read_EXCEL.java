package com.anjuke.minzhao.test;

import jxl.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Read_EXCEL{
	
    public static void main(String[] args) {
        int i,j,maxLine;
        Sheet sheet;
        Workbook book;
        Cell cell1;
        try { 
        	 String sourcefile = "E:/��Ŀ/[14863]SEOС����ҳ�Ż�/BOOK.xls";
        	 InputStream is = new FileInputStream(sourcefile);
        	 book = Workbook.getWorkbook(is);         
          //  ��õ�һ�����������(excel��sheet�ı�Ŵ�0��ʼ,0,1,2,3,....)
        	 sheet=book.getSheet(0); 
            i=2;
            maxLine=8200;
            System.out.println("it'sok1"); 
            for(j=0;maxLine>0;maxLine--)
            {
               // ��ȡÿһ�еĵ�Ԫ�� 
                cell1=sheet.getCell(i,j);//���У��У�
               System.out.println(cell1.getContents());
                j++;
            }
            book.close(); 
            System.out.println("it'sok2"); 
        }
        catch(Exception e)  {
        	System.out.println("no work");
        	e.printStackTrace();
        } 
    }
}

