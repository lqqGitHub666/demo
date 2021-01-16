package com.example.demo.algorithm.dac;

/**
 * @ClassName: Hanoitower
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/12/14 19:31
 * @Version: 1.0
 */
public class Hanoitower {

    static int i = 0;
    public static void main(String[] args) {
        hanoiTower(5,'A','B','C');
        System.out.println("移动次数:=" + i);
    }


    public static void hanoiTower(int num,char a,char b,char c){
        if (num == 1){
            i++;
            System.out.println("第1个盘从 " + a + "->" + c);
        }else {
            //a -> b
            hanoiTower(num-1,a,c,b);
            //a -> c
            i++;
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            //b -> c
            hanoiTower(num-1,b,a,c);
        }
    }
}
