package com.lhb.hutooldemo.date;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Month;
import cn.hutool.core.date.TimeInterval;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: Created By haibo.li01@hand-china.com
 * @time: 2019/11/18  21:52;
 * @description: HuTool 工具类库单元测试
 */

public class DateUtilTest {

    /**
     * Date、long、Calendar之间的相互转换
     */
    @Test
    public void dateUtilTest() {
        //当前时间1
        DateTime date1 = DateUtil.date();
        System.out.println("date1--->" + date1);
        //当前时间2
        Date date2 = DateUtil.date(Calendar.getInstance());
        System.out.println("date2--->" + date2);
        //当前时间3
        DateTime date3 = DateUtil.date(System.currentTimeMillis());
        System.out.println("date3--->" + date3);
        //当前时间字符串，格式 yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        System.out.println("now---->" + now);
        //当前日期字符串，格式：yyyy-MM-dd
        String today = DateUtil.today();
        System.out.println("today--->" + today);
    }


    /**
     * 字符串转日期
     * 格式化日期输出
     */
    @Test
    public void dateParseTest() {
        /**
         * DateUtil.parse方法会自动识别一些常用格式，包括：
         *   yyyy-MM-dd HH:mm:ss
         *   yyyy-MM-dd
         *   HH:mm:ss
         *   yyyy-MM-dd HH:mm
         *   yyyy-MM-dd HH:mm:ss.SSS
         */
        String dateStr = "2019-11-18";
        Date parse = DateUtil.parse(dateStr, "yyyy-MM-dd");
        System.out.println("parse-->" + parse);

        //我们也可以使用自定义日期格式转换
        String dateStr2 = "2019-11-18";
        DateTime parse2 = DateUtil.parse(dateStr2);
        System.out.println("parse2-->" + parse2);


        String dateStr3 = "2017-03-01";
        Date date = DateUtil.parse(dateStr3);

        //结果 2017/03/01
        String format = DateUtil.format(date, "yyyy/MM/dd");
        System.out.println("format-->" + format);

        //常用格式的格式化，结果：2017-03-01
        String formatDate = DateUtil.formatDate(date);
        System.out.println("formatDate-->" + formatDate);

        //结果：2017-03-01 00:00:00
        String formatDateTime = DateUtil.formatDateTime(date);
        System.out.println("formatDateTime-->" + formatDateTime);

        //结果：00:00:00
        String formatTime = DateUtil.formatTime(date);
        System.out.println("formatTime-->" + formatTime);
    }

    /**
     * 获取Date对象的某个部分
     */
    @Test
    public void getDate() {
        Date date = DateUtil.date();
        //获得年的部分
        int year = DateUtil.year(date);
        System.out.println("year--->" + year);
        //获得月份，从0开始计数
        int month = DateUtil.month(date);
        System.out.println("month--->" + month);
        //获得月份枚举
        Month monthEnum = DateUtil.monthEnum(date);
        System.out.println("monthEnum--->" + monthEnum);
    }

    /**
     * 开始和结束时间
     */
    @Test
    public void startAndEndDateTest() {
        String dateStr = "2017-03-01 22:33:23";
        Date date = DateUtil.parse(dateStr);

        //一天的开始，结果：2017-03-01 00:00:00
        Date beginOfDay = DateUtil.beginOfDay(date);
        System.out.println("beginOfDay--->" + beginOfDay);

        //一天的结束，结果：2017-03-01 23:59:59
        Date endOfDay = DateUtil.endOfDay(date);
        System.out.println("endOfDay--->" + endOfDay);
    }


    /**
     * 计时器
     */
    @Test
    public void timerTest() {
        TimeInterval timer = DateUtil.timer();
        int count=0;
        for (int i = 0; i < 1000000000; i++) {
            count += i;
        }
        System.out.println("count--->"+count);
        System.out.println("花费毫秒数："+timer.interval());
        System.out.println("花费分钟数："+timer.intervalMinute());
        System.out.println("返回花费时间，并重置开始时间："+timer.intervalRestart());

    }

}
