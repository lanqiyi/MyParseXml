package com.anjuke.minzhao.test;

import java.io.IOException;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
 

/**
 * 最简单的HTTP客户端,用来演示通过GET或者POST方式访问某个页面
 * 
 * 
 */
public class testHttpClient {

	public void PostHttpClient(String domain, int Port, String uri, NameValuePair[] values) throws IOException {
		
		HttpClient client = new HttpClient();
		client.getHostConfiguration().setHost(domain, Port,"http");
		

		HttpMethod method = getPostMethod(uri,values);
		client.executeMethod(method);
//		Header header = method.getResponseHeader("location");
//		System.out.print(header.getValue());
		System.out.print("~~~~~~~~~");
		// 打印服务器返回的状态
		System.out.println(method.getStatusLine());
		
		// 打印结果页面
		String response = new String(method.getResponseBodyAsString().getBytes("8859_1"));
		// 打印返回的信息
		System.out.println(response);
		method.releaseConnection();

	}

	
	public  HttpMethod getPostMethod(String uri,NameValuePair[] parametersBody) {
		
		PostMethod post = new PostMethod(uri);
		post.setRequestBody(parametersBody);
		return post;
	}
}
