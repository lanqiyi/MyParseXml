 package com.anjuke.minzhao.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.poi.ss.usermodel.Workbook;

import com.anjuke.minzhao.test.ReadDataFromASO.POITest;

public class testASO {
	private static String domain ="cms.yangcui.dev.anjuke.com";
	
	private static String uri_app_ranking = "/user/api/m/?act=app_ranking";
	private static String uri_app_hotword ="/user/api/m/?act=app_words";
	private static String uri_delete_hotwords ="/user/api/m/?act=delete&item=words";
	private static String uri_delete_app_ranking ="/user/api/m/?act=delete&item=ranking";
	private static int port =80;
	public static void main(String[] args){

		testDeleteAppAPI();
		//testDeleteHotWordsAPI();
		
	}
	public static void testDeleteHotWordsAPI(){
		NameValuePair[] simcard = new NameValuePair[2];
		GetMD5Security mdtest = new GetMD5Security();	
		String name = "9";
		
		String x = mdtest.getMD5Str(name+"&46b5742601ef99db4da653dd3f332bf3");
		
		System.out.println(x);
		System.out.println(domain);
		simcard[0] = new NameValuePair("ids",name);
		simcard[1] = new NameValuePair("signcode", x);
	
		testHttpClient ss = new testHttpClient();
		try {
			ss.PostHttpClient(domain,port,uri_delete_hotwords,simcard);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void testDeleteAppAPI(){
		NameValuePair[] simcard = new NameValuePair[2];
		GetMD5Security mdtest = new GetMD5Security();	
		String name = "497,498,499,500,501,502";
		
		String x = mdtest.getMD5Str(name+"&46b5742601ef99db4da653dd3f332bf3");
		
		System.out.println(x);
		System.out.println(domain);
		simcard[0] = new NameValuePair("ids",name);
		simcard[1] = new NameValuePair("signcode", x);
	
		testHttpClient ss = new testHttpClient();
		try {
			ss.PostHttpClient(domain,port,uri_delete_app_ranking,simcard);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testInsertApp_ranking(){
//		NameValuePair[] simcard = new NameValuePair[6];
//		GetMD5Security mdtest = new GetMD5Security();	
//		String name = null;
//		try {
//			name = java.net.URLEncoder.encode("测试iPad", "utf-8");
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		}	
//		String x = mdtest.getMD5Str(name+"&46b5742601ef99db4da653dd3f332bf3");
//		System.out.println(x);
//		System.out.println(domain);
//		simcard[0] = new NameValuePair("names",name);
//		simcard[1] = new NameValuePair("types", "3");
//		simcard[2] = new NameValuePair("rankings", "0");
//		simcard[3] = new NameValuePair("signcode", x);
//		simcard[4] = new NameValuePair("init", "1");
//		simcard[5] = new NameValuePair("dates", "03-05");
//		testHttpClient ss = new testHttpClient();
//		try {
//			ss.PostHttpClient(domain,port,uri_app_ranking,simcard);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		

	}
	public static void testInsertAPIHotWords(){
		
//		NameValuePair[] simcard = new NameValuePair[5];
//		GetMD5Security mdtest = new GetMD5Security();	
//		String name = null;
//		String appHotWordEncode =null;
//		try {
//			name = java.net.URLEncoder.encode("小主", "utf-8");
//			appHotWordEncode = java.net.URLEncoder.encode("小主","utf-8");
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		}	
//		String x = mdtest.getMD5Str(name+"&46b5742601ef99db4da653dd3f332bf3");
//		System.out.println(x);
//		simcard[0] = new NameValuePair("names",name);
//		simcard[1] = new NameValuePair("words", appHotWordEncode);
//		simcard[2] = new NameValuePair("rankings", "10");
//		simcard[3] = new NameValuePair("weights", "0");
//		simcard[4] = new NameValuePair("signcode", x);
//		System.out.println(domain);
//		testHttpClient ss = new testHttpClient();
//		try {
//			ss.PostHttpClient(domain,port,uri_app_hotword,simcard);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
