package com.tyrone.baseframework.utils;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * @program: topbridge
 * @description: 日期工具类
 * @author: Tyrone
 * @create: 2020-01-02 14:54
 **/
public class DateUtil extends TimeUtils {

    /**
     * 获取昨天的时间
     */
    public static Date getYesterdayDate() {
        Date date = new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);//把日期往后增加一天.整数往后推,负数往前移动
        return calendar.getTime();
    }

    public static Calendar getYesterdayCalendar() {
        Date date = new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);//把日期往后增加一天.整数往后推,负数往前移动
        return calendar;
    }

    public static Calendar getYesterdayCalendar(String zoneIdShort) {
        Date date = new Date();//取时间
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(ZoneId.of(ZoneId.SHORT_IDS.get(zoneIdShort))));
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);//把日期往后增加一天.整数往后推,负数往前移动
        return calendar;
    }

    /**
     * 获取明天的时间
     */
    public static Date getTomorrowDate() {
        Date date = new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);//把日期往后增加一天.整数往后推,负数往前移动
        return calendar.getTime();
    }

    public static Calendar getTomorrowCalendar() {
        Date date = new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);//把日期往后增加一天.整数往后推,负数往前移动
        return calendar;
    }

    /**
     * 获取当前天的起始时间
     */
    public static Date getStartTime(Calendar day) {
        day.set(Calendar.HOUR_OF_DAY, 0);
        day.set(Calendar.MINUTE, 0);
        day.set(Calendar.SECOND, 0);
        day.set(Calendar.MILLISECOND, 0);
        return day.getTime();
    }

    /**
     * 获取当前天的结束时间
     */
    public static Date getEndTime(Calendar day) {
        day.set(Calendar.HOUR_OF_DAY, 23);
        day.set(Calendar.MINUTE, 59);
        day.set(Calendar.SECOND, 59);
        day.set(Calendar.MILLISECOND, 999);
        return day.getTime();
    }

    /**
     * timestamp 转固定的时区String
     */
    public static String convertToZoneTimeString(Long timestamp, String timeZone) {
        Date date = new Date(timestamp);
        SimpleDateFormat sdf8 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf8.setTimeZone(TimeZone.getTimeZone(timeZone));//设置时区
        return sdf8.format(date);
    }

    public static String convertToZoneDateString(Long timestamp, String timeZone) {
        Date date = new Date(timestamp);
        SimpleDateFormat sdf8 = new SimpleDateFormat("yyyy-MM-dd");
        sdf8.setTimeZone(TimeZone.getTimeZone(timeZone));//设置时区
        return sdf8.format(date);
    }


}
