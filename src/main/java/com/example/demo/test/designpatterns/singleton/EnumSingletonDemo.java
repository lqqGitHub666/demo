package com.example.demo.test.designpatterns.singleton;

/**
 * @author 作者 lqq
 * @ClassName 类名 EnumSingletonDemo
 * @date 2019/8/29 20:32
 * @注释：
 */
public class EnumSingletonDemo {
    private EnumSingletonDemo() {

    }
    private enum EnumHolder{
        INSTANCE;
        private EnumSingletonDemo instance;
        EnumHolder(){
            this.instance = new EnumSingletonDemo();
        }

        private EnumSingletonDemo getInstance(){
            return instance;
        }

    }
    public static EnumSingletonDemo getInstance(){
        return EnumHolder.INSTANCE.instance;
    }
}
