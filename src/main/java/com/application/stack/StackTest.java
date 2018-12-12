/**
 * Copyright (c) 2017， 西安长城数字软件有限公司[www.e-u.cn]。 
 * 
 * 
 * 
 */
package com.application.stack;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * Java8 Stream类练习测试
 * 
 * @author $Author: liuyunpeng $
 * @version $Revision: 1.0 $
 */
public class StackTest {

	public static void main(String[] args) {

		String[] strArr = { "Java8", "new", "feature", "Stream", "API" };
		int count = 0;
		for (String s : strArr) {
			if (s.length() > 3) {
				count++;
			}
		}
		
		long countNew = Stream.of(strArr).filter(w -> w.length() > 3).count();
//	    System.out.println("count:"+count);
//	    System.out.println("countNew:"+countNew);
//	    
	    
/*	    Arrays.asList(strArr).forEach( e ->{
	    	System.out.println(String.join(":" , e, String.valueOf(e.length()) ));
	    });*/
		
		Stack<String> stack = new Stack<>();
		// 添加
		stack.push("123");
		stack.push("223");
		stack.push("323");
		stack.push("423");
		System.out.println("stack:"+stack);
		stack.pop();
		stack.remove("123");
		System.out.println("stack:"+stack);
		
	   
		
		
	}
}
