package com.example.demo.test.testcglibproxy;

/**
 * @author 作者 lqq
 * @ClassName 类名 LiuDeHua
 * @date 2019/8/1 17:56
 * @注释：
 */
public class LiuDeHua implements Star {
    @Override
    public String sing(String name) {
        System.out.println("给我一杯忘情水");
        return "唱完";
    }

    @Override
    public String dance(String name) {
        System.out.println("开心的马骝");
        return "跳完";
    }
}
