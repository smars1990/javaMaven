package com.application.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CollectioinDemo {

	public static void main(String[] args) {
		
		Map<String,String> map = new HashMap<>(8);
		Map<String,String> treeMap = new TreeMap();
		
		int falgNum = 0;
		while(falgNum < 100) {
			falgNum ++;
			map.put(String.valueOf(falgNum), String.valueOf(falgNum));
			treeMap.put(String.valueOf(falgNum), String.valueOf(falgNum));
			
		}
		
		System.out.println(map);
		System.out.println(treeMap);
	}
}
