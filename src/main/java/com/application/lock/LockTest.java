package com.application.lock;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private static  Logger logger = LoggerFactory.getLogger(LockTest.class);

    private static Lock lock = new ReentrantLock();
    private static Condition c1 = lock.newCondition();

    private static void test(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("thread 1");

                lock.lock();
                logger.info( "lock 1");

                try {
                    Thread.sleep(5000);
                    logger.info("wait 1");
                    c1.await(1000, TimeUnit.MILLISECONDS);
                    logger.info( "wait timeout 1");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                lock.unlock();
                logger.info( "unlock 1");

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info( "thread 2");

                lock.lock();
                logger.info( "lock 2");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //c1.signal();
                //logger.info("signal 2");

                lock.unlock();
                logger.info( "unlock 2");

            }
        }).start();
    }

    public static void main(String[] args) {
        test();
    }

}
