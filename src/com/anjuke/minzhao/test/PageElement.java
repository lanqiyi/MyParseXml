package com.anjuke.minzhao.test;

public class PageElement {
	
	private String appName;
	private String HotWord;
	private String Rank;
	private String Weight;
	public String getAppName(){
		return appName;
	}
	public String getAppHotWord(){
		return HotWord;
	}
	public String getAppRank(){
		return Rank;
	}
	public String getAppWeight(){
		return Weight;
	}
	public void setAppName(String name){
		this.appName = name;
	}
	public void setAppHotWord(String word){
		this.HotWord = word;
	}
	public void setAppRank(String rank){
		this.Rank = rank;
	}
	public void setAppWeight(String weight){
		this.Weight = weight;
	}
}
