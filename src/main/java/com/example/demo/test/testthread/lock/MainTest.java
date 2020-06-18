package com.example.demo.test.testthread.lock;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 作者 lqq
 * @ClassName 类名 MainTest
 * @date 2019/8/6 16:48
 * @注释：
 */
public class MainTest {
//    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
//        MyThread myThread0 = new MyThread();
//        new Thread(myThread0).start();
//        new Thread(myThread0).start();
//        new Thread(myThread0).start();
//        new Thread(myThread0).start();
//        new Thread(myThread0).start();

//        Map<String,String> map = new HashMap<>();
//        map.put("1","2");
//        map.put("3","4");
//        List<String> list = new ArrayList<String>(map.values());
//        System.out.println(list)

//        for (int i = 0; i <5 ; i++) {
//            for (int j = 0; j <3 ; j++) {
//                if (j == 2){
//                    break;
//                }
//            }
//
//        }
//
//     }

    private static String getPatientContent(Object o) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        String patientContent = "";
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields){
            String name = field.getName();
            Method method = o.getClass().getMethod("get"+name.substring(0,1).toUpperCase()+name.substring(1));
            Object value = method.invoke(o);
            sb.append(value == null ? " " : value.toString()).append("\r\n");
            patientContent = sb.toString().substring(0,sb.length());
        }
        return patientContent;
    }


    private volatile int a = 0;

    private MyLock lock = new MyLock();

    public void add(){
        lock.lock();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a = a+1;
        System.out.println(Thread.currentThread().getName() +" ---- "+ a);
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        MainTest mainTest = new MainTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                mainTest.add();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                mainTest.add();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                mainTest.add();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                mainTest.add();
            }
        }).start();

        Thread.sleep(1000);
        System.out.println( mainTest.a);
    }

}
