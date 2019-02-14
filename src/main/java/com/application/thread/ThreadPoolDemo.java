/**
 * Copyright (c) 2017， 西安长城数字软件有限公司[www.e-u.cn]。 
 * 
 * 
 * 
 */
package com.application.thread;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Thread Pool 线程池测试
 * 
 * @author $Author: liuyunpeng $
 * @version $Revision: 1.0 $	
 */
public class ThreadPoolDemo {

	public static void main(String[] args) {

		// 任务定时器
		getScheduledThreadPool(1, TimeUnit.MINUTES);

	}

	/**
	 * 任务定时器执行时间
	 * 
	 * @param minutesNum
	 *            int对象为时间分
	 * @param minutes
	 *            TimeUnit对象为时间类型
	 */
	public static void getScheduledThreadPool(int minutesNum, TimeUnit minutes) {
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
		executorService.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				System.out.println("执行时间：" + LocalDateTime.now());
			}

		}, 0, minutesNum, minutes);
	}

}
