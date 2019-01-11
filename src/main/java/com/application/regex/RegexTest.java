package com.application.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	public static void main(String[] args) {
		
		String regex = "^[\\u4e00-\\u9fa5]*$";
		
		String matchStr = "boolean isHave =	permissionServiceImpl.findResource(\"请销假管理系统\",\"请销假管理\", \"系统设置\", this.loginUser(request).getUserID());";
		//Matcher matcher = Pattern.compile(regex).matcher(matchStr);

		//使用正则表达式
        Pattern pattern = Pattern.compile("[^\u4E00-\u9FA5]");
        //[\u4E00-\u9FA5]是unicode2的中文区间
        Matcher matcher = pattern.matcher(matchStr);
        String  tempStr = matcher.replaceAll("_");
        String[] strArray = tempStr.split("_");
        StringBuilder builder = new StringBuilder();
        for(String str : strArray) {
        	if( !str.isEmpty() ) {
        		if( !builder.toString().isEmpty() ) {
        			builder.append("、");
        		}
        		builder.append(str);
        	}
        }
        
        System.out.println(builder);
       
        
	}
	
}
