/**
 * Copyright (c) 2017， 西安长城数字软件有限公司[www.e-u.cn]。 
 * 
 * 
 * 
 */
package com.application.thread;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.SystemNanoClock;


/**
 * Thread Pool 线程池测试
 * 
 * @author $Author: liuyunpeng $
 * @version $Revision: 1.0 $
 */
public class ThreadPoolDemo {

	 public static void main(String[] args) {
	

		 
//		 ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 3, 10, TimeUnit.MILLISECONDS, 
//				 new SynchronousQueue<Runnable>(),
//				 Executors.defaultThreadFactory(),
//				 new ThreadPoolExecutor.CallerRunsPolicy()); 
		 
	
		 ScheduledThreadPoolExecutor  poolExecutor = new ScheduledThreadPoolExecutor(3,Executors.defaultThreadFactory());
		 ScheduledExecutorService executorService  = Executors.newScheduledThreadPool(3);
		 executorService.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("执行时间："+ LocalDateTime.now());
			}
			
		}, 0, 1* 1000, TimeUnit.MILLISECONDS);
		 
	
	 }
	 
	 
	 
}
