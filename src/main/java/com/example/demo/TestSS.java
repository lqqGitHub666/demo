package com.example.demo;

import java.util.Arrays;

/**
 * @ClassName: TestSS
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2021/3/18 16:50
 * @Version: 1.0
 */
public class TestSS {

    public static void main(String[] args) {
        int a[] = {1,3,4,9};
        int b[] = {2,5,6};
        int c[] = sort(a,b);
        Arrays.stream(c).forEach(value -> System.out.println(value));
    }

    public static int[] sort(int a[],int b[]){
        int n = 0;
        int m = 0;
        int c[] = new int[a.length+b.length];
        for (int i = 0; i < a.length; i++) {
            if (n < b.length && a[i] < b[n]){
                c[m] = a[i];
            }else {
                if (n == b.length){
                    c[m] = a[i];
                }else {
                    c[m] = b[n];
                    n = n+1;
                    i = i-1;
                }
            }
            m++;
        }
        return c;
    }
}
