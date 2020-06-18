package com.example.demo.test.testabstract;

/**
 * @author 作者 lqq
 * @ClassName 类名 Cook
 * @date 2019/8/30 16:04
 * @注释：
 */
public abstract class Cook {

    public abstract int chaoCai(int a);

    public abstract int zhuFan(int b);

    public int eat(int a,int b){
        int i = chaoCai(a);

        if (i==0){
            return 0;
        }
        int j = zhuFan(b);
        if (j==0){
            return 0;
        }
        int re = i+j;
        return re;
    }

}
