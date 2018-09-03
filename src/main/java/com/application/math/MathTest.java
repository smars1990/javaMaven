package com.application.math;

/**
 * 文件名：MathTest.java<br>
 * 版权：Copyright (c) 2017 长城数字[www.e-u.cn]<br>
 * 描述：类描述<br>
 * 修改人：Author: liuyunpeng <br>
 * 版本：Revision: 1.0.0.0 
 */
public class MathTest{

    public static void main(String[] args) {
        int weeks = 0;   // 周期
        int days = 0;      // 天数
        int hours = 0;    // 小时
        String workLoadName = "";  //工作时长
        
        int tempworkLoad =  18000 / 3600;
        
        if( tempworkLoad <  8) {
            workLoadName +=  tempworkLoad +"小时";
        }
        
        if(tempworkLoad >=8  && tempworkLoad < 3 ) {
           workLoadName +=  hours +"时" +days +"天" +weeks +"周"; 
           System.out.println(workLoadName);
        }
     
    }
}
