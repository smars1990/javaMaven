package com.application.string;

import java.time.LocalDateTime;
import java.util.HashMap;

public class StringTest {
	
  public static void main(String[] args) {
	  
/*	  String a = "fantj";
      String b = "fantj";
      //a和b 会存到常量池里，常量池类似一个set集合，不允许有重复的值，所以加入第二个重复的值会返回已存在值的索引
      System.out.println(a == b);
      //new操作会实例化一个对象，会把他放到栈中。
      String c = new String("fantj");
      //所以a和c比较，a在常量池，b在堆，索引肯定不同，结果自然不同，返回false
      System.out.println(a == c);
      //a和c.intern比较，intern会把c搬到常量池，所以加入第二个重复的值会返回已存在值的索引，返回true
      System.out.println(a == c.intern());*/
	  
	  String  str = "";
	  System.out.println("str:"+Integer.parseInt(str));
	  
      LocalDateTime dateTime = LocalDateTime.now();
      
      System.out.println(dateTime.withHour(00));


      
  }
}
