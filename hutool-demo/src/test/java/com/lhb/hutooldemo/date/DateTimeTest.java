package com.lhb.hutooldemo.date;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
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
        DateTime dateTime = new DateTime(date);
        Console.log("dateTime--->"+dateTime);
    }

}
