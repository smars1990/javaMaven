package com.application.reflect;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO implements Serializable{

	/**
	 * 生成唯一序列号
	 */
	private static final long serialVersionUID = 5446247472681608784L;

	/** 名称 */
	private String name = "";
	
	/** 性别 */
	private int gender = 0;
	
	/** 年龄 */
	private int age;
	
	
}
