package com.application.reflect;

import java.lang.reflect.Field;

public class ReflectTest {

	public static void main(String[] args) throws ClassNotFoundException {
		StudentDTO studentDTO = new  StudentDTO();
		Class stuClass1 = studentDTO.getClass();
		String name = stuClass1.getName();
		System.out.println("name:"+name);
		
		Class stuClass2 = StudentDTO.class; 
		System.out.println(stuClass1 == stuClass2);
		
		Class stuClass3 = Class.forName("com.application.reflect.StudentDTO");
		System.out.println(stuClass2 == stuClass3);
		
		Field[] fields = stuClass3.getFields();
		for(int i = 0; i < fields.length; i++) {
			Field  field = fields[i];
			System.out.println(field);
		}
	}
	
}
