package com.example.demo;

import java.util.Arrays;

/**
 * @ClassName: TestSSS
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2021/3/18 17:10
 * @Version: 1.0
 */
public class TestSSS {

    public static void main(String[] args) {
        int[] a = {1,1,2,2,2,3,4,5};
        int i = 0;
        int j = 0;
        int x = 0;
        while (x < a.length -1){
            if (a[i] == a[i+1] && j < a.length-2){
                a[j+1] = a[j+2];
                j++;
                continue;
            }
            if (a[i] < a[i+1]){
                i++;
            }
            x++;
            j = i;
        }
        Arrays.stream(a).forEach(s -> System.out.println(s));
    }
}
