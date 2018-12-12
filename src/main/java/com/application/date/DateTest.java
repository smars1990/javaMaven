/**
 * Copyright (c) 2017， 西安长城数字软件有限公司[www.e-u.cn]。 
 * 
 * 
 * 
 */
package com.application.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.chrono.ChronoPeriod;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Java8 时间类练习测试
 * 
 * @author $Author: liuyunpeng $
 * @version $Revision: 1.0 $
 */
public class DateTest {

	public static void main(String[] args) throws ParseException, InterruptedException {
		// Instant 精确
		// jdk8InstantTest();

		// 本地日期
		//jdk8LocalDateTest();

		
		//jdk8CompareDates(LocalDate.now(), LocalDate.of(2018, 04, 9));
		// LocalDate.of(Integer.parseInt(Year.now().toString()), Month.DECEMBER, 12));

		 // 比较两段时间内有多少天、多少个月
	     //System.out.println(	getDaysInTimeLimit("2018-03-09",LocalDate.now().toString()));
		
		 // 本地时间
         //getCurrentYearFirstDayAndLastDay();

         //System.out.println(getNowDate());
		 // LocalDateTime localDate = LocalDateTime.now();
		 //System.out.println(LocalDate.now());
		
		/*
		DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.DAY_OF_WEEK_FIELD);
	    System.out.println(dateFormat.format("2018-05-29"));
		System.out.println(LocalDate.parse("2018-05-29",DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        */	
		
		LocalDate currentMonthDate = LocalDate.of(2018, 11, 1);
		System.out.println("currentMonthDate:"+currentMonthDate);
		
		
		//DateTimeFormatter  dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//System.out.print(ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.parse("2018-05-29", dateTimeFormatter)));
		
//		LocalDate startTime = LocalDate.parse("2018-06-15");
//		LocalDate endTime = LocalDate.parse("2018-06-20");
//		LocalDate clickTime = LocalDate.parse("2018-06-15");
		
		/*if( startTime.isBefore(clickTime) &&  endTime.isAfter(clickTime)){
			System.out.println("111");
		}*/
		
//		System.out.println(ChronoUnit.DAYS.between(startTime,clickTime));
//		System.out.println(ChronoUnit.DAYS.between(clickTime,endTime));
		
		
		/*
		
		System.out.println(monthFirstDay +":"+monthLastDay);
		
		Period period = Period.between(localDate, monthLastDay);

		System.out.println("相差天数："+period.getDays());
		
		LocalDateTime dateTime = LocalDateTime.now();
	    System.out.println("时："+ dateTime.getHour() +"分："+dateTime.getMinute());
 		
		
		System.out.println(localDate.getYear() +"-"+localDate.getMonthValue() + "-" +localDate.getDayOfMonth());
        */
		
		
		//LocalDate date = LocalDate.now();
		//System.out.println("当前日期："+ date);
		//System.out.println(date.plusDays(-21));
		
		//LocalDateTime localDateTime = LocalDateTime.now();
		//System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

		// 获取当前日期
		LocalDate localDate = LocalDate.now();
		//localDate = localDate.minusDays(1);
		//localDate = localDate.minusDays(7);
		System.out.println(localDate);
		
		// 上一周的周五
		LocalDate weeklyFirstTime = localDate.minusWeeks(1).with(DayOfWeek.FRIDAY);
		System.out.println(weeklyFirstTime.toString());
		
/*		int currentWeekDay = localDate.getDayOfWeek().getValue();
		//WeekFields weekFields = WeekFields.of(Locale.getDefault()); 
		WeekFields weekFields = WeekFields.ISO; 
		int weekNumber = localDate.get(weekFields.weekOfYear());
		
		System.out.println("周次1："+weekNumber);
		System.out.println("周1："+WeekFields.SUNDAY_START);
		System.out.println("周7："+weekFields);
		System.out.println("周几："+localDate.getDayOfWeek().getValue());*/
		
//    	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		String d1 = "2018-10-22";
//		LocalDate date = LocalDate.parse(d1, fmt);
//		
//		LocalDate lastWeeklyStartTime = LocalDate.parse("2018-10-22", DateTimeFormatter.BASIC_ISO_DATE).minusWeeks(1);
//		
//		System.out.println("lastWeeklyStartTime:"+date);

//		// 一周的第一天
//		String weekFristDay = null;
//		String weekFristDay1 = null;
//		// 一周的最后一天
//		String weekEndDay = null;
//		if( currentWeekDay <= 3 ) {
//			weekFristDay = localDate.with(DayOfWeek.MONDAY).minusWeeks(1).toString();
//			weekFristDay1 = localDate.with(DayOfWeek.MONDAY).toString();
//			weekEndDay = localDate.with(DayOfWeek.SUNDAY).toString();
//		}
//
//		System.out.println(weekFristDay +":"+weekFristDay1 +":"+weekEndDay);
	}
	
	/**
	 * 获取当前月的每一天
	 */
	public static void getCurrentMonthDays() {
		// 获取当前日期
		LocalDate localDate = LocalDate.now();
		// 获取当前月最后一天日期
		LocalDate monthLastDay = localDate.with(TemporalAdjusters.lastDayOfMonth());
		// 获取当前月最后一天日期
		LocalDate monthFirstDay = localDate.with(TemporalAdjusters.firstDayOfMonth());
		
		System.out.println(monthLastDay.getDayOfMonth() + ":" + monthFirstDay.getDayOfMonth());
		
		
		for(int i = 0; i < monthLastDay.getDayOfMonth(); i++ ) {
			System.out.println(monthFirstDay.plusDays(i));
		}
	}
	
	/**
	 * 获取当前时间所在的小时
	 * @return 
	 */
	public static String getNowDate() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHH");
		return sf.format(new Date()).substring(sf.format(new Date()).length()-2, sf.format(new Date()).length());
	}

	/**
	 *  获取当前年的第一天 和最后一天
	 */
	@SuppressWarnings("unused")
	private static void getCurrentYearFirstDayAndLastDay() {
		 LocalDate localDate = LocalDate.now();
		 // 当前年第一天
		 System.out.println( localDate.withYear(localDate.getYear()).with(TemporalAdjusters.firstDayOfYear()));
		 System.out.println( localDate.withYear(localDate.getYear()).with(TemporalAdjusters.lastDayOfYear()));
		 System.out.println(localDate.minusMonths(1));
		 System.out.println(localDate);		
	}

	/**
	 * 对java8 本地日期LocalDate进行测试练习
	 * 
	 * @param startDate  LocalDate 开始时间
	 * @param endDate  LocalDate 结束时间
	 */
	@SuppressWarnings("unused")
	private static void jdk8CompareDates(LocalDate startDate, LocalDate endDate) {

		System.out.println("开始时间：" + startDate + " , 结束时间：" + endDate);
		System.out.println("开始和结束时间比较:" + startDate.isBefore(endDate));

		Period period = Period.between(endDate, startDate);

		System.out.printf("日期%s和日期%s相差%s", startDate, endDate, period.getDays());
		System.out.println();
		System.out.printf("日期%s和日期%s相差%s", startDate, endDate, period.getMonths());

	}

	/**
	 * 对java8 本地日期LocalDate进行测试练习
	 */
	@SuppressWarnings("unused")
	private static void jdk8LocalDateTest() {
		// 本地时间
		LocalDate localDate = LocalDate.now();

		System.out.println("当前天日期：" + localDate);
		System.out.println("1天前的日期：" + localDate.minusDays(1));
		System.out.println("1天后的日期：" + localDate.plusDays(1));
		System.out.println("1周后的日期：" + localDate.plusWeeks(1));
		System.out.println("1月后的日期：" + localDate.plusMonths(1));
		System.out.println("1年后的日期：" + localDate.plusYears(1));
		System.out.println();

		System.out.println("现在日期：" + localDate.withDayOfMonth(12));
		System.out.println("现在年份日期：" + localDate.withDayOfYear(11));
		System.out.println("现在月份日期：" + localDate.withMonth(10));
		System.out.println("现在年份：" + localDate.withYear(2016));
		System.out.println("现在年份：" + localDate.withMonth(11));
		System.out.println();

		System.out.println("两段时间比较：" + localDate.isBefore(LocalDate.of(2018, 12, 8)));

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime localDateTime = LocalDateTime.now();

		System.out.println("无格式时间：" + localDateTime);
		System.out.println("现在时间：" + dateTimeFormatter.format(localDateTime));
		System.out.println(
				"现在时间：" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(localDateTime));
		System.out.println("环境相关的格式化格式时间1：" + DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(localDateTime));
		System.out.println("环境相关的格式化格式时间2：" + DateTimeFormatter.BASIC_ISO_DATE.format(localDateTime));
		System.out.println("环境相关的格式化格式时间3："
				+ DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.LONG).format(localDateTime));
	}

	/**
	 * 对java8 时间类Instant进行测试练习
	 * 
	 * @throws InterruptedException
	 */
	@SuppressWarnings("unused")
	private static void jdk8InstantTest() throws InterruptedException {
		// Instant 表示一个精确的时间
		Instant instantStart = Instant.now();
		Thread.sleep(1000 * 1);
		Instant instantEnd = Instant.now();

		// 比较两个时间段 的值
		Duration timeElapsed = Duration.between(instantStart, instantEnd);

		System.out.println(timeElapsed.isNegative());

		System.out.println("millis:" + timeElapsed.toMillis());
		System.out.println("seconds:" + timeElapsed.getSeconds());
		System.out.println("minutes:" + timeElapsed.toMinutes());
		System.out.println("hours:" + timeElapsed.toHours());
		System.out.println("days:" + timeElapsed.toDays());
		System.out.println("nano:" + timeElapsed.toNanos());
	}

	/**
	 * 统计这段时间范围内的工作日
	 * 
	 * @param startTime  Date对象为开始时间
	 * @param endTime   Date对象为结束时间
	 * @return Double 返回这段时间范围内的工作日
	 */
	public static double countLeaveDays(Date startTime, Date endTime) {
		double leaveDays = 0;
		// 从startTime开始循环，若该日期不是节假日或者不是周六日则请假天数+1
		Date flag = startTime;// 设置循环开始日期
		Calendar cal = Calendar.getInstance();
		// 循环遍历每个日期
		while (flag.compareTo(endTime) != 1) {
			cal.setTime(flag);
			// 判断是否为周六日
			int week = cal.get(Calendar.DAY_OF_WEEK) - 1;
			if (week == 0 || week == 6) {// 0为周日，6为周六
				// 是周末、周六
				leaveDays = leaveDays + 1;

				// 跳出循环进入下一个日期
				cal.add(Calendar.DAY_OF_MONTH, +1);
				flag = cal.getTime();
				continue;
			}

			// 日期往后加一天
			cal.add(Calendar.DAY_OF_MONTH, +1);
			flag = cal.getTime();
		}
		return leaveDays;
	}
	
	
	  
    /**
     *  获取开始时间到今天范围内的天数
     * @param startTime 开始时间
     * @return 返回开始时间到今天范围内的天数
     */
    public  static int getDaysInTimeLimit(String startTime,String endTime) {
    	// 默认定义0天
    	int  days = 0;
    	
    	/*try {
    		
			DateFormat fmtDateTime = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = fmtDateTime.parse(startTime);
			Calendar calendar1 = Calendar.getInstance();
			calendar1.setTime(date1);
			Calendar  today = Calendar.getInstance();
			days = (today.getTimeInMillis() - calendar1.getTimeInMillis()) / (1000 * 60 * 60 * 24);
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
    	
		DateTimeFormatter  dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		days = (int) ChronoUnit.DAYS.between(LocalDate.parse(endTime, dateTimeFormatter), LocalDate.parse(startTime, dateTimeFormatter));
		System.out.printf("相差%d天\n" ,days);
    	
    	return (int) days;
    }

}
