package com.example.demo.algorithm.kmp;

/**
 * @ClassName: ViolenceMatch
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/12/14 19:56
 * @Version: 1.0
 */
public class ViolenceMatch {

    public static void main(String[] args) {
        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你";
        int index = violenceMatch(str1, str2);
        System.out.println("index=" + index);
    }

    public static int violenceMatch(String str1,String str2){
        char[] str1c = str1.toCharArray();
        char[] str2c = str2.toCharArray();
        int i = 0;
        int j = 0;
        while (i<str1c.length && j<str2c.length){
            if (str1c[i] == str2c[j]){
                i ++;
                j ++;
            }else {
                i = i -(j - 1);
                j = 0;
            }
        }
        if (j == str2c.length){
            return i-j;
        }else {
            return -1;
        }
    }
}
