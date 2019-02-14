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
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
		// jdk8LocalDateTest();

		// jdk8CompareDates(LocalDate.of(2018, 04, 12), LocalDate.of(2018, 04, 9));
		// LocalDate.of(Integer.parseInt(Year.now().toString()), Month.DECEMBER, 12));

		// 比较两段时间内有多少天、多少个月
		// getDaysInTimeLimit("2018-03-09",LocalDate.now().toString()));

		// 本地时间
		// getCurrentYearFirstDayAndLastDay();

		// System.out.println(getNowDate());
	     LocalDateTime localDate = LocalDateTime.now();
		// System.out.println( localDate.with(DayOfWeek.MONDAY) );

		// 在国内的话，一般默认locale就是CHINA, 可以不指定
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-w E").withLocale(Locale.CHINESE);
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-w e");

		System.out.println(localDate.minusWeeks(1).getDayOfWeek().getValue());

		/*
		 * DateFormat dateFormat =
		 * DateFormat.getTimeInstance(DateFormat.DAY_OF_WEEK_FIELD);
		 * System.out.println(dateFormat.format("2018-05-29"));
		 * System.out.println(LocalDate.parse("2018-05-29",DateTimeFormatter.ofPattern(
		 * "yyyy-MM-dd")));
		 */

		/*
		 * LocalDate currentMonthDate = LocalDate.of(2018, 11, 1);
		 * System.out.println("currentMonthDate:"+currentMonthDate.getDayOfYear());
		 */

		// DateTimeFormatter dateTimeFormatter =
		// DateTimeFormatter.ofPattern("yyyy-MM-dd");
		// System.out.print(ChronoUnit.DAYS.between(LocalDate.now(),
		// LocalDate.parse("2018-05-29", dateTimeFormatter)));

		// LocalDate startTime = LocalDate.parse("2018-06-15");
		// LocalDate endTime = LocalDate.parse("2018-06-20");
		// LocalDate clickTime = LocalDate.parse("2018-06-15");

		/*
		 * if( startTime.isBefore(clickTime) && endTime.isAfter(clickTime)){
		 * System.out.println("111"); }
		 */

		// System.out.println(ChronoUnit.DAYS.between(startTime,clickTime));
		// System.out.println(ChronoUnit.DAYS.between(clickTime,endTime));

		// LocalDate date = LocalDate.now();
		// System.out.println("当前日期："+ date);
		// System.out.println(date.minusDays(1));
		// System.out.println(date.minusDays(1));

		// LocalDateTime localDateTime = LocalDateTime.now();
		// System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd
		// HH:mm:ss")));

		// DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		// String d1 = "2018-10-22";
		// LocalDate date = LocalDate.parse(d1, fmt);
		//
		// LocalDate lastWeeklyStartTime = LocalDate.parse("2018-10-22",
		// DateTimeFormatter.BASIC_ISO_DATE).minusWeeks(1);
		//
		// System.out.println("lastWeeklyStartTime:"+date);

		// // 一周的第一天
		// String weekFristDay = null;
		// String weekFristDay1 = null;
		// // 一周的最后一天
		// String weekEndDay = null;
		// if( currentWeekDay <= 3 ) {
		// weekFristDay = localDate.with(DayOfWeek.MONDAY).minusWeeks(1).toString();
		// weekFristDay1 = localDate.with(DayOfWeek.MONDAY).toString();
		// weekEndDay = localDate.with(DayOfWeek.SUNDAY).toString();
		// }
		//
		// System.out.println(weekFristDay +":"+weekFristDay1 +":"+weekEndDay);

		// 根据 年份-周次获取 周次开始和结束时间范围
		// System.out.println( parseWithISOWeekFields("2019-52", DayOfWeek.MONDAY) );
		// System.out.println( parseWithISOWeekFields("2018-1", DayOfWeek.SUNDAY) );

		// 获取周次
		// getCurrentWeeks();

		// LocalDate localDate1 = LocalDate.of(2018, 01, 30);
		// LocalDate localDate1 = LocalDate.of(2018, 01, 29);

		// 获取Period 、ChronoUnit 、Duration 三者之间的区别
	    //getDay1AndDay2Poor();

		// 获取周次
		//getCurrDayWeeks();
		
	    // 对日期进行对比    
		compareDate("2019-01-11","2019-01-11");
		
		
	}

	/**
	 * 对日期进行对比
	 * @param string 
	 * @param string2
	 * @return String 返回时间比对
	 */
	private static boolean compareDate(String beginDateStr, String endDateStr) {
		// 对日期进行对比
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    
	    LocalDate beginDate = LocalDate.parse(beginDateStr, formatter);
	    LocalDate endDate = LocalDate.parse(endDateStr, formatter);
	    
	    boolean isBigDate = beginDate.isBefore(endDate);
	    System.out.printf("开始时间："+beginDateStr + ", 和结束时间：" +endDateStr + "， 开始时间大于结束时间："+isBigDate);
		
	    // 返回字符串比对
	    return isBigDate;
	}

	/**
	 * 获取周次
	 */
	private static void getCurrDayWeeks() {
		// 获取当前日期
		LocalDate localDate = LocalDate.now();
		localDate = localDate.minusDays(1);
		localDate = localDate.minusDays(7);
		System.out.println(localDate);

		// 上一周的周五
		LocalDate weeklyFirstTime = localDate.minusWeeks(1).with(DayOfWeek.FRIDAY);
		System.out.println(weeklyFirstTime.toString());

		int currentWeekDay = localDate.getDayOfWeek().getValue();
		// WeekFields weekFields = WeekFields.of(Locale.getDefault());
		WeekFields weekFields = WeekFields.ISO;
		int weekNumber = localDate.get(weekFields.weekOfYear());

		System.out.println("周次1：" + weekNumber);
		System.out.println("周1：" + WeekFields.SUNDAY_START);
		System.out.println("周7：" + weekFields);
		System.out.println("周几：" + localDate.getDayOfWeek().getValue());
		
		
	}

	/**
	 * Period 、ChronoUnit 、Duration 三者之间的区别
	 * 
	 */
	private static void getDay1AndDay2Poor() {
		// Period可以不用，似乎是月内想减 才可以
		LocalDate localDate1 = LocalDate.of(2018, 01, 28);
		LocalDate localDate2 = LocalDate.of(2018, 01, 27);
		Period period = Period.between(localDate1, localDate2);
		System.out.println("period days:" + period.getDays());

		// ChronoUnit两数字想减
		System.out.println("ChronoUnit days:" + ChronoUnit.DAYS.between(localDate1, localDate2));

		// 根据时间得出 相差得秒数
		LocalTime localTime1 = LocalTime.of(14, 10);
		LocalTime localTime2 = LocalTime.of(14, 15);
		Duration duration = Duration.between(localTime1, localTime2);
		System.out.println("duration seconds:" + duration.getSeconds());
	}

	/**
	 * 获取周次、周一和周日
	 */
	private static void getCurrentWeeks() {
		LocalDate localDate = LocalDate.now().minusWeeks(1).with(DayOfWeek.FRIDAY);
		System.out.println(localDate);

		// 获取周次
		// WeekFields weekFields = WeekFields.of(Locale.getDefault());
		WeekFields weekFields = WeekFields.ISO;
		int weekNumber = localDate.get(weekFields.weekOfYear());
		System.out.println(weekNumber);

		// 当前周的第一天
		LocalDate weeklyFirstTime = localDate.minusDays(7);
		System.out.println(weeklyFirstTime);
		// 当前周的最后一天
		LocalDate weeklyLastTime = localDate.with(DayOfWeek.FRIDAY);
		System.out.println(weeklyLastTime);

	}

	public static LocalDate parseWithISOWeekFields(String text, DayOfWeek dayOfWeek) {
		// 未对text做格式校验，格式不对会产生异常，如有需要自行补充, 表示第几周的数字不满二位需要补0
		String[] split = text.split("-");
		String year = split[0];
		String week = split[1];
		if (week.length() <= 1) {
			week = "0" + week;
		}
		String isoWeekDate = String.format("%s-W%s-%s", year, week, dayOfWeek.getValue());
		return LocalDate.parse(isoWeekDate, DateTimeFormatter.ISO_WEEK_DATE);
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

		for (int i = 0; i < monthLastDay.getDayOfMonth(); i++) {
			System.out.println(monthFirstDay.plusDays(i));
		}
	}

	/**
	 * 获取当前时间所在的小时
	 * 
	 * @return
	 */
	public static String getNowDate() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHH");
		return sf.format(new Date()).substring(sf.format(new Date()).length() - 2, sf.format(new Date()).length());
	}

	/**
	 * 获取当前年的第一天 和最后一天
	 */
	@SuppressWarnings("unused")
	private static void getCurrentYearFirstDayAndLastDay() {
		LocalDate localDate = LocalDate.now();
		// 当前年第一天
		System.out.println(localDate.withYear(localDate.getYear()).with(TemporalAdjusters.firstDayOfYear()));
		System.out.println(localDate.withYear(localDate.getYear()).with(TemporalAdjusters.lastDayOfYear()));
		System.out.println(localDate.minusMonths(1));
		System.out.println(localDate);
	}

	/**
	 * 对java8 本地日期LocalDate进行测试练习
	 * 
	 * @param startDate
	 *            LocalDate 开始时间
	 * @param endDate
	 *            LocalDate 结束时间
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
	 * @param startTime
	 *            Date对象为开始时间
	 * @param endTime
	 *            Date对象为结束时间
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
	 * 获取开始时间到今天范围内的天数
	 * 
	 * @param startTime
	 *            开始时间
	 * @return 返回开始时间到今天范围内的天数
	 */
	public static int getDaysInTimeLimit(String startTime, String endTime) {
		// 默认定义0天
		int days = 0;

		/*
		 * try {
		 * 
		 * DateFormat fmtDateTime = new SimpleDateFormat("yyyy-MM-dd"); Date date1 =
		 * fmtDateTime.parse(startTime); Calendar calendar1 = Calendar.getInstance();
		 * calendar1.setTime(date1); Calendar today = Calendar.getInstance(); days =
		 * (today.getTimeInMillis() - calendar1.getTimeInMillis()) / (1000 * 60 * 60 *
		 * 24); } catch (ParseException e) { e.printStackTrace(); }
		 */

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		days = (int) ChronoUnit.DAYS.between(LocalDate.parse(endTime, dateTimeFormatter),
				LocalDate.parse(startTime, dateTimeFormatter));
		System.out.printf("相差%d天\n", days);

		return (int) days;
	}

}
