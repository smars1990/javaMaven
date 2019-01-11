/**
 * Copyright (c) 2017， 西安长城数字软件有限公司[www.e-u.cn]。 
 * 
 * 
 * 
 */
package com.application.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * log4j2日志
 * 
 * @author $Author: liuyunpeng $
 * @version $Revision: 1.0 $
 */
public class Log4j2Test {

	public static void main(String[] args) throws Exception {
		// Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
		Logger logger = LogManager.getLogger(Log4j2Test.class.getName());
		for (int i = 0; i < 50000; i++) {
			logger.trace("trace level");
			logger.debug("debug level");
			logger.info("info level");
			logger.warn("warn level");
			logger.error("error level");
			logger.fatal("fatal level");
			
			Thread.sleep(1000 * 2);
		}

		logger.trace("trace level");
		logger.debug("debug level");
		logger.info("info level");
		logger.warn("warn level");
		logger.error("error level");
		logger.fatal("fatal level");
	}
}
