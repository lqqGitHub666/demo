package com.example.demo.hutool;

import cn.hutool.core.convert.Convert;

import java.util.Date;

/**
 * @ClassName: Test
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2021/3/22 17:00
 * @Version: 1.0
 */
public class Test {

    public static void main(String[] args) {
        String a = "2017/05/06";
        Date value = Convert.toDate(a);
        System.out.println(value);
    }
}
