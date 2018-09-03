package com.application.string;

public class StackLogTest {

	public static void main(String[] args) {
	    new StackLogTest().methodA();
	}
	
	private  void methodA() {
		System.out.println("进入methodA");
		methodB();
	}

	@SuppressWarnings("static-access")
	private void methodB() {
		System.out.println("进入methodB");
        StackTraceElement[] stackTraceElements = new Thread().currentThread().getStackTrace();
		
        
		for (int i = 0; i < stackTraceElements.length; i++) {
			StackTraceElement stackTraceElement = stackTraceElements[i];
			String className = stackTraceElement.getClassName();
			String methodName = stackTraceElement.getMethodName();
			String fileName = stackTraceElement.getFileName();
			int lineNumber = stackTraceElement.getLineNumber();
			System.out.println("fileName=" + fileName + ",className=" + className + ",methodName=" + methodName
					+ ",lineNumber=" + lineNumber);
		}		
	}
}
