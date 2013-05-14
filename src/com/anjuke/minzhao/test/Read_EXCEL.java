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
        	 String sourcefile = "E:/项目/[14863]SEO小区单页优化/BOOK.xls";
        	 InputStream is = new FileInputStream(sourcefile);
        	 book = Workbook.getWorkbook(is);         
          //  获得第一个工作表对象(excel中sheet的编号从0开始,0,1,2,3,....)
        	 sheet=book.getSheet(0); 
            i=2;
            maxLine=8200;
            System.out.println("it'sok1"); 
            for(j=0;maxLine>0;maxLine--)
            {
               // 获取每一行的单元格 
                cell1=sheet.getCell(i,j);//（列，行）
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

