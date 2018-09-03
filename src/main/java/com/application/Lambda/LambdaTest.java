/**
 * Copyright (c) 2017， 西安长城数字软件有限公司[www.e-u.cn]。 
 * 
 * 
 * 
 */

package com.application.Lambda;

import java.util.Arrays;

/**
 * Java8 Lambda类练习测试
 * 
 * @author $Author: liuyunpeng $
 * @version $Revision: 1.0 $
 */
public class LambdaTest {

	 public static void main(String[] args) {
         Arrays.asList( "a" , "b" , "c" ,"d" ).forEach(e -> System.out.println(e));
	 }
	 
}
