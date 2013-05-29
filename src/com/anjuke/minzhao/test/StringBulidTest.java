package com.anjuke.minzhao.test;
/*想到的最搓的方法*/
public class StringBulidTest {
	
	public static String title = null;
	public static String description1 = null;
	public static String description2 = null;
	public static final String TITLE = "title=";
	public static final String DESCRIPTION1 = "description1=";
	public static final String DESCRIPTION2 = "description2=";
	public static final String NULL = null;
	
	public static void main(String args[]) {
	    String str = "title=d\rdescription1=e\rdescription2=f"; 
	    String str1 = "description1=e\rdescription2=f\rtitle=d";
	    String str2 = "description1=e\rdescription2=f";
	    String str3 ="title=d\rdescription1=e\rdescription2=f\rread=s";
	    
	    test ss = new StringBulidTest().new test();
		ss.tranfrom(str1);
	}
	public class test {
		
		public void tranfrom(String str) {
			if(str==null) {
				return;
			}
			else{
				String test1[] = str.split("\r");
			
				for(int i=0; i<test1.length; i++) {
					if(test1[i].startsWith(TITLE)){
						title = test1[i].replace(TITLE, "");
					}
					else if(test1[i].startsWith(DESCRIPTION1)) {
						description1 = test1[i].replace(DESCRIPTION1, "");
						
					}
					else if(test1[i].startsWith(DESCRIPTION2)) {
						description2 = test1[i].replace(DESCRIPTION2, "");
					}
					else {
						test1[i]=NULL;
					}
				}
				
				System.out.println("title="+title);
				System.out.println("description1="+description1);
				System.out.println("description2="+description2);
			}
			
		}
	}
}






