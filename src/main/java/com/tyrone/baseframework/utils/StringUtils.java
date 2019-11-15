package com.tyrone.baseframework.utils;

import com.tyrone.baseframework.codec.MD5;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * @program: baseframework
 * @description:
 * @author: Tyrone
 * @create: 2019-11-14 13:59
 */
public class StringUtils {
    private final static String COMMA=",";

    public static boolean isEmpty(Object str){
        if(str==null||"".equals(str)){
            return true;
        }
        return false;
    }

    public static boolean isBlank(String str) {
        int length = 0;
        if ((str == null) || ((length = str.length()) == 0)) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 正则表达式验证
     */
    public static boolean regex(String str, String regex) {
        return str.matches(regex);
    }

    /**
     * 大于等于零的数字
     */
    public static boolean geZeroNumber(String number) {
        try{
            Long value=Long.valueOf(number);
            return value>=0;
        }catch(Exception e){
            return false;
        }
    }

    /**
     * 大于零的数字
     */
    public static boolean gtZeroNumber(String number) {
        try{
            Long value=Long.valueOf(number);
            return value>0;
        }catch(Exception e){
            return false;
        }
    }

    public static Object nullToObject(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj;
    }

    /**
     * 转字符
     */
    public static String nullToString(Object obj) {
        if (obj == null) {
            return null;
        }
        return String.valueOf(obj);
    }

    /**
     * 转Date
     */
    public static Date nullToDate(Object obj) {
        if (obj == null) {
            return null;
        }
        return (Date)obj;
    }

    /**
     * 转Integer
     */
    public static Integer nullToInteger(Object obj) {
        if (obj == null) {
            return null;
        }
        return Integer.parseInt(String.valueOf(obj));
    }

    /**
     * 转Long
     */
    public static Long nullToLong(Object obj) {
        if (obj == null) {
            return null;
        }
        return Long.parseLong(String.valueOf(obj));
    }

    /**
     * 转float
     */
    public static Float nullToFloat(Object obj) {
        if (obj == null) {
            return null;
        }
        return Float.parseFloat(String.valueOf(obj));
    }

    /**
     * 转Double
     */
    public static Double nullToDouble(Object obj) {
        if (obj == null) {
            return null;
        }
        return Double.parseDouble(String.valueOf(obj));
    }

    /**
     * 转BigInteger
     * @param obj
     * @return
     */
    public static BigInteger nullToBigInteger(Object obj) {
        if (obj == null) {
            return null;
        }
        return new BigInteger(String.valueOf(obj));
    }

    /**
     * 转BigDecimal
     * @param obj
     * @return
     */
    public static BigDecimal nullToBigDecimal(Object obj) {
        if (obj == null) {
            return null;
        }
        return new BigDecimal(String.valueOf(obj));
    }

    /**
     * 转枚举
     */
    public static <T>T nullToEnum(Object obj,Class<T> enumType) {
        if (obj == null) {
            return null;
        }
        String text=String.valueOf(obj);
        for(T e:enumType.getEnumConstants()) {
            if(String.valueOf(e).equals(text)) {
                return e;
            }
        }
        return null;
    }

    /**
     * 字符NULL转""
     */
    public static String nullToStr(String str) {
        if (str == null) {
            str = "";
        }
        return str;
    }

    /**
     * 字符NULL转""并去掉左右空格
     */
    public static String nullToStrTrim(String str) {
        if (str == null) {
            str = "";
        }
        return str.trim();
    }

    /**
     * 0=false
     * 1=true
     */
    public static boolean nullToBoolean(String str) {
        if(isEmpty(str)){
            return false;
        }
        if("0".equals(str)){
            return false;
        }else if("1".equals(str)){
            return true;
        }
        return Boolean.valueOf(str.trim());
    }

    public static int nullToInt(String str) {
        if(isEmpty(str)){
            return 0;
        }
        return Integer.valueOf(str.trim());
    }

    public static long nullToLong(String str) {
        if(isEmpty(str)){
            return 0;
        }
        return Long.valueOf(str.trim());
    }

    public static double nullToDouble(String str) {
        if(isEmpty(str)){
            return 0;
        }
        return Double.valueOf(str.trim());
    }

    public static String listToString(List<?> lists){
        return listToString(lists, COMMA);
    }

    public static String listToString(List<?> lists,String comma){
        StringBuilder strBuilder=new StringBuilder();
        for(Object str : lists){
            strBuilder.append(str);
            strBuilder.append(comma);
        }
        if(strBuilder.length()>0){
            return strBuilder.substring(0, strBuilder.length()-comma.length());
        }
        return strBuilder.toString();
    }

    public static String mapToString(Map<String,String> map, String comma){
        StringBuilder strBuilder=new StringBuilder();
        for(String key : map.keySet()){
            strBuilder.append(key+"="+map.get(key));
            strBuilder.append(comma);
        }
        if(strBuilder.length()>0){
            strBuilder.deleteCharAt(strBuilder.length()-1);
        }
        return strBuilder.toString();
    }

    /**
     * 生成随机数<br>
     * GUID： 即Globally Unique Identifier（全球唯一标识符） 也称作 UUID(Universally Unique
     * IDentifier) 。
     *
     * 所以GUID就是UUID。
     *
     * GUID是一个128位长的数字，一般用16进制表示。算法的核心思想是结合机器的网卡、当地时间、一个随即数来生成GUID。
     *
     * 从理论上讲，如果一台机器每秒产生10000000个GUID，则可以保证（概率意义上）3240年不重复。
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 生成随机数
     */
    public static String random(){
        return random("");
    }

    /**
     * 生成随机数
     */
    public static String random(String input){
        Random ra=new Random();
        return MD5.md5(getUUID() + System.currentTimeMillis() + ra.nextInt(999999999) + input);
    }

    /**
     * 生成随机码
     *
     * @param charCount
     * @return
     */
    public static String numberRandom(int charCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charCount; i++) {
            int from = 0;
            int to = 10;
            Random r = new Random();
            sb.append(from + r.nextInt(to - from));
        }
        return sb.toString();
    }

    /**
     * 字符串转数字
     * @param str
     * @return
     */
    public static String stringConverterNumber(String str) {
        StringBuilder sbStr=new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cs=str.charAt(i);
            if (cs >= 48 && cs<= 57) {
                sbStr.append(cs);
            }
        }
        return sbStr.toString();
    }
}
