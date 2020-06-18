package com.example.demo.test.lazyload;

import org.springframework.stereotype.Service;

/**
 * @author 作者 lqq
 * @ClassName 类名 LazyLoadTest
 * @date 2019/8/8 10:52
 * @注释：
 */
@Service
//@Lazy()
public class LazyLoadTest {
    public LazyLoadTest() {
        System.out.println("加载了");
    }
}
