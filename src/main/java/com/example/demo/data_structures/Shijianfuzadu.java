package com.example.demo.data_structures;

/**
 * @ClassName: Shijianfuzadu
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/11/15 16:14
 * @Version: 1.0
 */
public class Shijianfuzadu {

    public static void main(String[] args) {

    }
    //常数阶O(1)
    public void test1(int i,int j){
        ++i;
        j++;
        int m = i + j;
    }

    //对数阶O(log2n)
    public void test2(int n){
        int i = 1;
        while (i < n){
            i = i * 2;
        }
    }

    //线性阶O(n)
    public void test3(int num){
        for (int i = 0; i < num; i++) {
            int j = i;
            j ++;
        }
    }

    //线性对数阶O(nlogN)
    public void test4(int n){
        for (int m = 0; m < n; m++) {
            int i = 1;
            while (i<n){
                i = i*2;
            }
        }
    }

    //平方阶O(n²)
    public void test5(int n){
        for (int x = 0; x <= n; x++) {
            for (int i = 0; i <= n; i++) {
                int j = i;
                j++;
            }
        }
    }


}
