package com.example.demo.test.testmq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.io.InputStream;

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

    public static void main(String[] args) throws IOException {
//        AA a= new AA();
//        a.setAa("123");
//        String bb= a.getAa();
//
//        a.setAa("234");
//        System.out.println(bb);
//
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("");

        ResourceLoader resourceLoader = new PathMatchingResourcePatternResolver();
        Resource resource = resourceLoader.getResource("file:C:\\Users\\16372\\Desktop\\test.txt");
        long l = resource.contentLength();
        System.out.println(l);
        InputStream is = resource.getInputStream();
        //2.读取资源
        byte[] descBytes = new byte[is.available()];
        is.read(descBytes);
        System.out.println(new String(descBytes));
    }
}
