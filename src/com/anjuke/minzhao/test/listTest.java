package com.anjuke.minzhao.test;

import java.util.ArrayList;
import java.util.List;

public class listTest {
//	private List<PageIphoneElement> AppiPhoneRank = new ArrayList<PageIphoneElement>();
//	private List<PageElement> AppHotWordDistrubution = new ArrayList<PageElement>();
	public static void main(String[] args){
		
		List<PageIphoneElement> AppiPhoneRank = new ArrayList<PageIphoneElement>();

		for(int i=0;i<2;i++){
			
			PageIphoneElement ss= new PageIphoneElement();
			ss.setAppName("abc"+i);
			ss.setDate("2-27");
			ss.setAppRankType("1");
			ss.setAppRank("10"+i);
			
			AppiPhoneRank.add(ss);
		}
		
		for( PageIphoneElement x : AppiPhoneRank){
			System.out.println(x.getAppName());
			System.out.println(x.getAppRank());
		}
		
		
	}
	
	
}
