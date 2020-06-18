package com.example.demo.test.other;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 作者 lqq
 * @ClassName 类名 Child1
 * @date 2019/9/12 15:13
 * @注释：
 */
public class Child1 extends Father {

    @Override
    protected void init() {
        code = "child1";
    }

    public static void main(String[] args) {
//        Child1 child1 = new Child1();
//        Child1.add(1);
//        int a = child1.hashCode();
//        System.out.println(a);
//        Map<String,String> map = new HashMap<>();
//        map.put(null,null);
//        System.out.println(map.keySet());
//        System.out.println(map.size());
//        System.out.println(map.get(null));
//        List<String> list = new ArrayList();
//        list.add("");
//        List<String> list1 = new Vector();
//        list1.add("");
//        List<String> list2 = new LinkedList<>();
//        list2.add("");
//
//        AtomicInteger ss = new AtomicInteger();
//        Lock lock = new ReentrantLock();

        System.out.println(1 & 3 );
        System.out.println(1 << 16);
    }
}
