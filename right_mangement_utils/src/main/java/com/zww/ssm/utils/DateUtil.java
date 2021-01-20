package com.zww.ssm.utils;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式转换工具类
 */
public class DateUtil {

    //日期格式转字符串
    public static String date2Str(Date date,String pattern){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    //字符串格式转日期
    public static Date str2Date(String str,String pattern){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
           date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            System.out.println("日期格式错误");
            e.printStackTrace();
        }
        return date;
    }

    //测试
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        //注意要传入大写的月份MM
        String s = DateUtil.date2Str(date, "yyyy-MM-dd HH:mm");
        System.out.println(s);

        Date date1 = DateUtil.str2Date(s,"yyyy-MM-dd HH:mm");
        System.out.println(date1);
    }
}
