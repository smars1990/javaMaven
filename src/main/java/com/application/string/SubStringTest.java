package com.application.string;

import net.sf.json.JSONArray;


public class SubStringTest {

	public static void main(String[] args) {
		/*String str = "浐灞工程数据整理##CB-34";
		
		System.out.println(str.split("##")[1]);
		
		*/
		
		String  str = "[{\"url\":\"hh002/images/001/20180625/20180625144125.jpg\"}]";
		JSONArray jsonArray = JSONArray.fromObject(str);
		
		System.out.println(jsonArray);
		
	}
}
