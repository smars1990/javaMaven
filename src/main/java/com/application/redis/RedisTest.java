package com.application.redis;

import java.util.HashMap;

import redis.clients.jedis.Jedis;

public class RedisTest {

	
	public static void main(String[] args) {
		/*
		 * 1.先把本地redis服务启动起来
		 *   先在CMD中启动服务：redis-server.exe redis.windows.conf 
		 * 
		 * 2.可以CMD中进行测试
		 *  redis-cli.exe -h 127.0.0.1 -p 6379 
		 *	设置键值对 set myKey abc
		 *	取出键值对 get myKey
		 *
		 */
		
		// 连接本地的Redis服务
		Jedis jedis = new Jedis("localhost");
		
		System.out.println("连接成功！");
		
		// 查看服务是否在运行
		System.out.println( "服务正在运行:" + jedis.ping() );
		
		
		// key 为String类型
		jedis.set("mykey", "abc");
		jedis.set("mykey", "abcd");
		
		System.out.println( jedis.get("mykey") );
		
		
		// key 为listjieh 
		jedis.lpush("mylist", "abc");
		jedis.lpush("mylist", "123");
		jedis.lpush("mylist", "wer");
		jedis.lpush("mylist", "ou");
		
		System.out.println( jedis.lrange("mylist", 1, 10) );
		
		// key 为set类型
		jedis.sadd("myset", "1");
		jedis.sadd("myset", "5");
		jedis.sadd("myset", "3");
		jedis.sadd("myset", "2");
		
		
		System.out.println( jedis.smembers("myset") );
		
		// key 为 sort set类型
		jedis.zadd("mySortSet", 0, new HashMap<String,String>().put("key1", "1"));
		jedis.zadd("mySortSet", 2, new HashMap<String,String>().put("key3", "3"));
		jedis.zadd("mySortSet", 1, new HashMap<String,String>().put("key2", "2"));
		
		
	}
	
	
}
