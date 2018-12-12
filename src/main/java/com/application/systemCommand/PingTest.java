package com.application.systemCommand;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class PingTest {

	public static void main(String[] args) throws IOException {
		// 执行ping命令操作
		Runtime runtime = Runtime.getRuntime();
		Process process  =  runtime.exec("ping "+"baidu.com -t");
		
		InputStream inputStream = process.getInputStream();
		
		FileOutputStream osa = new FileOutputStream("E://a.txt",true);
		FileOutputStream osb = new FileOutputStream("E://b.txt",true);
		FileOutputStream osc = new FileOutputStream("E://c.txt",true);
		
		// 定义BufferedReader输入流来读取URL的响应
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream,"GBK"));
        
    	// 建立输入流，向指向的URL传入参数
        String line;
        String wrap = "\r\n";
        while ((line = in.readLine()) != null){
        	line = "ping执行时间"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA)) +":"+line+"";
    		System.out.println(line);
        	// 记录全部数据
        	osa.write(line.getBytes());
        	osa.write(wrap.getBytes());
        	
        	// 执行ping不通数据时间
    		if(line.indexOf("TTL") > 0) {
    			osc.write(line.getBytes());
    			osc.write(wrap.getBytes());
    		}else {
    			osb.write(line.getBytes());
    			osb.write(wrap.getBytes());
    		}
        }
        
        in.close();     
		inputStream.close();     
		
	}
}
