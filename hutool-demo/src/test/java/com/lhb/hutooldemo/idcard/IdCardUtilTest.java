package com.lhb.hutooldemo.idcard;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.IdcardUtil;
import org.junit.jupiter.api.Test;

/**
 * @author: Created By haibo.li01@hand-china.com
 * @time: 2019/11/19  9:49;
 * @description: 身份证工具
 */
public class IdCardUtilTest {
    /**
     * isValidCard 验证身份证是否合法
     * convert15To18 身份证15位转18位
     * getBirthByIdCard 获取生日
     * getAgeByIdCard 获取年龄
     * getYearByIdCard 获取生日年
     * getMonthByIdCard 获取生日月
     * getDayByIdCard 获取生日天
     * getGenderByIdCard 获取性别
     * getProvinceByIdCard 获取省份
     */

    @Test
    public void idCardTest(){
        String cardId="429004199608122237";

        boolean validCard = IdcardUtil.isValidCard(cardId);
        Console.log("是否有效："+validCard);

        //获取年龄
        DateTime date = DateUtil.parse("2019-11-19");
        int age = IdcardUtil.getAgeByIdCard(cardId, date);
        Console.log("年龄："+age);

        String birth = IdcardUtil.getBirthByIdCard(cardId);
        Console.log("生日："+birth);

        String province = IdcardUtil.getProvinceByIdCard(cardId);
        Console.log("省份："+province);


    }
}
