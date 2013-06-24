package com.anjuke.minzhao.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*在notepad++里面自动添加编号*/
public class autoAddNum {
	public static void main(String[] args) {

		try {
			String sourcefile = "D:/Workspace/MyParseXml/target.feature";
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(sourcefile), "UTF-8"));
			OutputStreamWriter out = new OutputStreamWriter(
					new FileOutputStream("D:/Workspace/MyParseXml/test.feature"),
					"UTF-8");
			BufferedWriter bw = new BufferedWriter(out); 
			String r = br.readLine();
			String str = "@";
			int count = 1;
			while (r != null) {
				if (r.contains(str)) {
					// System.out.println(r);
					String RowArray[] = r.split(" ");
					String[] Row = RowArray[1].split("@");
					int number = Integer.parseInt(Row[1]);
					if (count != number) {
						number = count;
						System.out.println(number);
					}
					r = r.replace(Row[1], String.valueOf(number));
					System.out.println(r);
					count++;

				}
				bw.write(r);
				bw.newLine();
				bw.flush();
				r = br.readLine();
			}
			br.close();
			out.close();
		} catch (Exception e) {
			System.out.println("no work");
			e.printStackTrace();
		}
	}
}
