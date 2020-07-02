package com.example.demo.test.testmq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 作者 lqq
 * @ClassName 类名 Test
 * @date 2020/7/1 15:40
 * @注释：
 */
public class Test {

    static class AA{
        private String aa;

        public String getAa() {
            return aa;
        }

        public void setAa(String aa) {
            this.aa = aa;
        }
    }

    public static void main(String[] args) {
        AA a= new AA();
        a.setAa("123");
        String bb= a.getAa();

        a.setAa("234");
        System.out.println(bb);

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("");
    }
}
