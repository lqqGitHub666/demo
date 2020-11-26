package com.example.demo.test;


import com.example.demo.TreeDemo;
import com.example.demo.dto.TreeTest;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author 作者 lqq
 * @ClassName 类名 TestCollection
 * @date 2020/4/26 10:40
 * @注释：
 */
public class TestCollection {

    public static void main(String[] args) {

        Map<Integer,Integer> map = new HashMap<>(2);
//        map.put(1,1);
//
//        System.out.println(map.size());
//
//        List<String> list = new ArrayList<>();
//        Iterator<String> iterator = list.iterator();
        TreeTest treeDemo = new TreeTest(1l);
        treeDemo.add(1);
        System.out.println();

    }
}
