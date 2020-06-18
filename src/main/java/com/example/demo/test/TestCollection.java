package com.example.demo.test;


import java.util.HashMap;
import java.util.Map;

/**
 * @author 作者 lqq
 * @ClassName 类名 TestCollection
 * @date 2020/4/26 10:40
 * @注释：
 */
public class TestCollection {

    public static void main(String[] args) {

        Map<Integer,Integer> map = new HashMap<>(2);
        map.put(1,1);

        System.out.println(map.size());

    }
}
