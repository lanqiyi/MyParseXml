package com.anjuke.minzhao.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*在notepad++里面自动添加编号*/
public class autoAddNum {
    public static void main(String[] args) {

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            final String sourcefile = "D:/Workspace/MyParseXml/target.feature";
            final String targetFile = "D:/Workspace/MyParseXml/test.feature";
            final String charset = "UTF-8";

            br = new BufferedReader(new InputStreamReader(new FileInputStream(sourcefile),
                    charset));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
                    targetFile), charset));

            String line = br.readLine();
            String str = "@";
            int count = 1;

            while (line != null) {
                if (line.contains(str)) {
                    // System.out.println(r);
                    String RowArray[] = line.split(" ");
                    String[] Row = RowArray[1].split("@");
                    int number = Integer.parseInt(Row[1]);
                    if (count != number) {
                        number = count;
                        System.out.println(number);
                    }
                    line = line.replace(Row[1], String.valueOf(number));
                    System.out.println(line);
                    count++;
                }
                bw.write(line);
                bw.newLine();
                bw.flush();
                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println("no work");
            e.printStackTrace();
        } finally {
            try {
                br.close();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
