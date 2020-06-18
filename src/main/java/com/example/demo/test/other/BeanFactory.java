package com.example.demo.test.other;


/**
 * @author 作者 lqq
 * @ClassName 类名 BeanFactory
 * @date 2019/9/12 15:17
 * @注释：
 */
public class BeanFactory {

    private Class aClass;

    public BeanFactory(Class aClass) {
        this.aClass = aClass;
    }

    public Object newIntence(){
        Object o = null;
        try {
             o = aClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return o;
    }
}
