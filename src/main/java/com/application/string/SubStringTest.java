package com.application.string;

import net.sf.json.JSONArray;


public class SubStringTest {

	public static void main(String[] args) {
		/*String str = "浐灞工程数据整理##CB-34";
		
		System.out.println(str.split("##")[1]);
		
		*/
		
	/*	String  str = "[{\"url\":\"hh002/images/001/20180625/20180625144125.jpg\"}]";
		JSONArray jsonArray = JSONArray.fromObject(str);
		
		System.out.println(jsonArray);
		*/
		
//		String tempPicAxis = "";
//		String objectPostion = "(243.0,341.0),(215.0,309.0)";
//		
//		// 获取XY轴坐标
//		String XYAxis = objectPostion.split("\\),\\(")[1];
//		// 获取X轴坐标
//		tempPicAxis = XYAxis.substring(0, XYAxis.length()-1);
//		// 对X 轴坐标值进行处理
//		System.out.println("x:"+(int)Double.parseDouble(tempPicAxis.split(",")[0]));
//		
//		// 对Y 轴坐标值进行处理
//		System.out.println("y:"+(int)Double.parseDouble(tempPicAxis.split(",")[1]));
//		
//		// 获取对角点(width、height)
//		String diagonalPoint = objectPostion.split("\\),\\(")[0];
//		// 获取对角点坐标
//		tempPicAxis = diagonalPoint.substring(1, diagonalPoint.length());
//		// 对width坐标值进行处理
//		System.out.println("width:"+(int)Double.parseDouble(tempPicAxis.split(",")[0]));
//		
//		// 对height坐标值进行处理
//		System.out.println("height:"+(int)Double.parseDouble(tempPicAxis.split(",")[1]));
		
		
		//System.out.println((int)Double.parseDouble("10.0") );
		
		String[] strArray = {"findResource"};
		
		String str = "public String findResource(Map<String,String> aMap)";
		System.out.println(str.lastIndexOf(strArray[0]) +"===="+str.length());
		str = str.substring(str.lastIndexOf(strArray[0]), str.length()-1);
		
		System.out.println(str);
		

	}
}
