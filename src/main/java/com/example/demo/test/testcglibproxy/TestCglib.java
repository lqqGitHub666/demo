package com.example.demo.test.testcglibproxy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 作者 lqq
 * @ClassName 类名 Test
 * @date 2019/10/29 11:25
 * @注释：
 */
public class TestCglib {

    public static void main(String[] args) throws ParseException {
//        Enhancer enhancer = new Enhancer();
//        //增强父类，cglib是基于继承来的
//        enhancer.setSuperclass(User.class);
//        enhancer.setCallback(new MyMethodInterceptor());
//        User user= (User) enhancer.create();
//        user.sys();
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
//        System.out.println(dateTimeFormatter.parse("09:00"));
        SimpleDateFormat sDateFormat=new SimpleDateFormat("HH:mm");
        System.out.println();
        Date date1 = sDateFormat.parse("00:00");
        Date date30 = sDateFormat.parse("00:30");
        Date date2 = sDateFormat.parse("09:00");
        long a = date2.getTime() - date1.getTime();
        System.out.println(a);
        System.out.println(date30.getTime());
        System.out.println(a/(date30.getTime()));

    }
}
