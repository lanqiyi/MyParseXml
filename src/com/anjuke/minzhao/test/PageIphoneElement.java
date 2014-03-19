package com.anjuke.minzhao.test;

public class PageIphoneElement {
	private String appName;
	private String Date;
	private String Rank;
	private String Type;
	public String getAppName(){
		return appName;
	}
	public String getDate(){
		return Date;
	}
	public String getAppRank(){
		return Rank;
	}
	public String getAppRankType(){
		return Type;
	}
	public void setAppName(String name){
		this.appName = name;
	}
	public void setDate(String date){
		this.Date = date;
	}
	public void setAppRank(String rank){
		this.Rank = rank;
	}
	public void setAppRankType(String type){
		this.Type = type;
	}
}
