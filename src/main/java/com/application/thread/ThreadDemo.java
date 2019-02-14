package com.application.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDemo implements Runnable {
	
	public synchronized void run() {
		System.out.println(1);
	}
	
	public static void main(String[] args) throws Exception {
		
		ExecutorService execuService = Executors.newScheduledThreadPool(3);
		// submit方法有多重参数版本，及支持callable也能够支持runnable接口类型.
		Future future = execuService.submit(new ThreadDemo());
		// 运行状态
		boolean isDone = future.isDone();
		System.out.println("isDone:"+isDone);
		
		System.out.println("isCancel:"+future.isCancelled());
		
		
		// return 返回值，阻塞直到该线程运行结束
		System.out.println(future.get());
		
		execuService.shutdown();
				
	}
}
