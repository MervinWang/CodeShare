package com.test.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * Created by wanghaiyang on 2017/9/27.
 */
public class DateUtils {
    //java8 新引入类 LocalDate LocalTime Instant Duration Period

    private static String strDate = "2017-09-27";
    private static String strTime = "11:42:46";
    private static String DATE_TIME_FORMAT = "yyyy-MM-dd hh:mm:ss";

    public static Date formatDate(Date date, String patten) {
        return date;
    }

    public static void main(String[] args) {


        LocalDate date = LocalDate.now();
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();

        //使用TemporalField读取LocalDate值
        int year2 = date.get(ChronoField.YEAR);
        int month2 = date.get(ChronoField.MONTH_OF_YEAR);
        int day2 = date.get(ChronoField.DAY_OF_MONTH);
        System.out.println(year2 + "-" + month2 + "-" + day2);

        //创建LocalTime
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.getHour()+ ":" + localTime.getMinute() + ":" + localTime.getSecond());

        //时间格式化
        LocalDate date2 = LocalDate.parse(strDate);
        LocalTime time2 = LocalTime.parse(strTime);
        System.out.println(date2.toString() + "   " + time2.toString());
        //合并时间
        LocalDateTime localDateTime = LocalDateTime.of(date2, time2);
        System.out.println(localDateTime.toString());





    }
}
