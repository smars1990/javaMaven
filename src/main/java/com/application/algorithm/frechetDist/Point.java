package com.application.algorithm.frechetDist;

import lombok.Data;

@Data
public class Point {
	private double longitude; // 定义经度
	private double latitude; // 定义纬度
	private String collectTime;

	public Point() {
	}

	public Point(double lon, double lat, String time) {
		super();
		this.longitude = lon;
		this.latitude = lat;
		this.collectTime = time;
	}
}
