package com.lhb.hutooldemo.date;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Month;
import cn.hutool.core.lang.Console;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author: Created By haibo.li01@hand-china.com
 * @time: 2019/11/18  22:41;
 * @description: 日期时间对象-DateTime
 */
public class DateTimeTest {


    /**
     * DateTime对象包含众多的构造方法，构造方法支持的参数有：
     *      Date
     *      Calendar
     *      String(日期字符串，第二个参数是日期格式)
     *      long 毫秒数
     */
    @Test
    public void test01(){
        Date date = new Date();
        //new 方式创建
        DateTime dateTime = new DateTime(date);
        Console.log("dateTime--->"+dateTime);
        //of方式创建
        DateTime dt = DateTime.of(date);
        Console.log("log--->"+dt);
    }

    @Test
    public void test02(){
        DateTime dateTime = new DateTime("2017-01-05 12:34:23", DatePattern.NORM_DATETIME_FORMAT);
        int year = dateTime.year();
        Month month = dateTime.monthEnum();
        int day = dateTime.dayOfMonth();
        Console.log(year+"年"+month+"月"+day+"日");
    }



}
