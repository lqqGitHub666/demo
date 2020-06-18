package com.example.demo.utils;


/**
 * @author 作者 lqq
 * @ClassName 类名 Test
 * @date 2019/10/9 14:44
 * @注释：
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(UUIDUtil.getUUID());
        int[] a = {1,3,5,4,2,9,8,6,7};
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length -1-i; j++) {
                if (a[j] >= a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        for (int i = 0; i <a.length; i++) {
            System.out.print(a[i]+"-->");
        }
    }


}
