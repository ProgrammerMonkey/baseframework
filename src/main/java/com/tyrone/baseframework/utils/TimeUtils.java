package com.tyrone.baseframework.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @program: baseframework
 * @description:
 * @author: Tyrone
 * @create: 2021-01-27 11:30
 **/
public class TimeUtils {
    public static final String yyyyMMdd_C = "yyyy年MM月dd日";
    public static final String yyyyMM_F = "yyyy-MM";
    public static final String yyyyMMdd_F = "yyyy-MM-dd";
    public static final String yyyyMMddHHmmss_F = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyyMMddHHmmsssss_F = "yyyy-MM-dd HH:mm:ss,SSS";
    public static final String yyyyMMddTHHmmssZ = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final String yyyy = "yyyy";
    public static final String yyyyMM = "yyyyMM";
    public static final String yyyyMMdd = "yyyyMMdd";
    public static final String HHmmss = "HHmmss";
    public static final String yyyyMMddHH = "yyyyMMddHH";
    public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
    public static final String yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
    public static final String yyyyMMddHHmmssSSSZ = "yyyyMMddHHmmssSSSZ";
    public static final String yyyyMMddHHmmssZ = "yyyyMMddHHmmssZ";

    public TimeUtils() {
    }

    public static String getSysTime(String pattern) {
        return formatSysTime(new SimpleDateFormat(pattern));
    }

    private static String formatSysTime(SimpleDateFormat format) {
        return format.format(Calendar.getInstance().getTime());
    }

    public static String format(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public static Date getDate(int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(5, days);
        return cal.getTime();
    }

    public static Date getHour(int hours) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(11, hours);
        return cal.getTime();
    }

    public static boolean validTime(String str, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);

        Date date;
        try {
            date = formatter.parse(str);
        } catch (ParseException var5) {
            throw new RuntimeException(var5);
        }

        return str.equals(formatter.format(date));
    }

    public static Date format(String str, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);

        try {
            return formatter.parse(str);
        } catch (ParseException var4) {
            throw new RuntimeException(var4);
        }
    }

    public static String getSysYear() {
        return getSysTime("yyyy");
    }

    public static String getSysTime() {
        return getSysTime("yyyy-MM-dd HH:mm:ss");
    }

    public static String getSysTimeS() {
        return getSysTime("yyyy-MM-dd HH:mm:ss,SSS");
    }

    public static String getSysTimeLong() {
        return getSysTime("yyyyMMddHHmmss");
    }

    public static String getSysTimeSLong() {
        return getSysTime("yyyyMMddHHmmssSSS");
    }

    public static String getSysdate() {
        return getSysTime("yyyy-MM-dd");
    }

    public static String getSysyearmonthInt() {
        return getSysTime("yyyyMM");
    }

    public static String getSysdateInt() {
        return getSysTime("yyyyMMdd");
    }

    public static String getSysdateTimeStart() {
        return getSysdate() + " 00:00:00";
    }

    public static String getSysdateTimeEnd() {
        return getSysdate() + " 23:59:59";
    }

    public static String getSysDateLocal() {
        return getSysTime("yyyy年MM月dd日");
    }

    public static String getTimeFormat(String str) {
        return format(format(str, "yyyyMMddHHmmss"), "yyyy-MM-dd HH:mm:ss");
    }

    public static String getDateFormat(String str) {
        return format(format(str, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd");
    }

    public static String getDateFormatLocal(String str) {
        return format(format(str, "yyyy-MM-dd HH:mm:ss"), "yyyy年MM月dd日");
    }

    public static String getTheDayBefore() {
        return format(getDate(-1), "yyyyMMdd");
    }

    public static String getTheDayBefore_F() {
        return format(getDate(-1), "yyyy-MM-dd");
    }

    public static String getDateFormat(int days) {
        return format(getDate(days), "yyyy-MM-dd");
    }

    public static String getDateFormatLocal(int days) {
        return format(getDate(days), "yyyy年MM月dd日");
    }

    public static String getTimeFormatHour(int hours) {
        return format(getHour(hours), "yyyy-MM-dd HH:mm:ss");
    }

    public static Date getHourTime(int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(11, hour);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static Date getHourTime(int hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(11, hour);
        calendar.set(12, minute);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static Date getTomorrowHourTime(int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(5, 1);
        calendar.set(11, hour);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static Date getTomorrowHourTime(int hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(5, 1);
        calendar.set(11, hour);
        calendar.set(12, minute);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static Date getThismonthTime(int day, int hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(5, day);
        calendar.set(11, hour);
        calendar.set(12, minute);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static Date getNextmonthTime(int day, int hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(2, 1);
        calendar.set(5, day);
        calendar.set(11, hour);
        calendar.set(12, minute);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static Date getMinute(int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(12, minute);
        return calendar.getTime();
    }

    public static Date getSecond(int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(13, second);
        return calendar.getTime();
    }

    public static long subtract(String start) throws ParseException {
        return format(getSysTimeS(), "yyyy-MM-dd HH:mm:ss,SSS").getTime() - format(start, "yyyy-MM-dd HH:mm:ss,SSS").getTime();
    }

    public static long subtract(String end, String start) throws ParseException {
        return format(end, "yyyy-MM-dd HH:mm:ss,SSS").getTime() - format(start, "yyyy-MM-dd HH:mm:ss,SSS").getTime();
    }

    public static String getFormatTime(String pattern, String TimeZoneFormat) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        format.setTimeZone(TimeZone.getTimeZone(TimeZoneFormat));
        return format.format(Calendar.getInstance().getTime());
    }

    public static String formatTime(String str, String strpattern, String pattern, String TimeZoneFormat) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(strpattern, Locale.ENGLISH);
        Date date = dateFormat.parse(str);
        SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.ENGLISH);
        format.setTimeZone(TimeZone.getTimeZone(TimeZoneFormat));
        return format.format(date);
    }

    public static String timeStampToDate(long seconds, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(seconds));
    }

    public static long dateToTimeStamp(String date_str, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(date_str).getTime();
    }
}
