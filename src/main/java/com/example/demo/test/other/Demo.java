package com.example.demo.test.other;

/**
 * @author 作者 lqq
 * @ClassName 类名 Demo
 * @date 2019/9/3 13:53
 * @注释：
 */
public class Demo {

//    static int i = 1;
//
//    static {
//        i = 0;
//        System.out.println(i);
//    }

    public static void main(String[] args) {
//        System.out.println(i);
//        Demo demo = new Demo();
//        try {
//            Class c = demo.getClass().getClassLoader().loadClass("com.example.demo.test.other.DemoClinit");
//            DemoClinit demoClinit = (DemoClinit) c.newInstance();
//            demoClinit.say();
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
//            e.printStackTrace();
//        }

        BeanFactory beanFactory = new BeanFactory(Child1.class);
        Child1 child1 = (Child1) beanFactory.newIntence();
        BeanFactory beanFactory1 = new BeanFactory(Child2.class);
        Child2 child2 = (Child2) beanFactory1.newIntence();
        child1.doInit();
        System.out.println(child1.getCode());
        child2.doInit();
        System.out.println(child2.getCode());
        System.out.println(child1.getCode());
    }

}
