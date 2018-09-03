
/**
 * Copyright (c) 2017， 西安长城数字软件有限公司[www.e-u.cn]。
 *
 */
package com.application.velocity;

import java.io.StringWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 * Velocity 模板引擎
 * 
 * @author $Author: liuyunpeng $
 * @version $Revision: 1.0 $
 */
public class HelloVelocity {

	public static void main(String[] args) {
		 VelocityEngine ve = new VelocityEngine(); 
		 ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath"); 
		 ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName()); 
		 
		 ve.init(); 
		 
		 Template t = ve.getTemplate("hellovelocity.vm"); 
		 VelocityContext ctx = new VelocityContext(); 
		 
		 DateTimeFormatter  dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		 LocalDate localDate = LocalDate.now();
		 LocalDateTime localDateTime = LocalDateTime.now();
		 
		 ctx.put("name", "velocity"); 
		 ctx.put("date", localDate); 
		 ctx.put("dateTime", dateTimeFormatter.format(localDateTime)); 
		 
		 List<String> temp = new ArrayList<String>(); 
		 temp.add("1"); 
		 temp.add("2"); 
		 ctx.put("list", temp); 
		 
		 StringWriter sw = new StringWriter(); 
		 
		 t.merge(ctx, sw); 
		 
		 System.out.println(sw.toString()); 
	}
}
