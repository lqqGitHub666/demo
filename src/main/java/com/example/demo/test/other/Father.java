package com.example.demo.test.other;

/**
 * @author 作者 lqq
 * @ClassName 类名 Father
 * @date 2019/9/12 15:10
 * @注释：
 */
public abstract class Father {

    protected String code;

    public void doInit(){
        init();
    }

    protected abstract void init();

    public String getCode() {
        return code;
    }

    public static void add(int a){
        System.out.println(3);
    }

    public static void add(String a){
        System.out.println(3);
    }
}
