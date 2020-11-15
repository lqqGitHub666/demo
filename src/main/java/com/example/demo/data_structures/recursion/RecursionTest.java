package com.example.demo.data_structures.recursion;

/**
 * @ClassName: RecursionTest
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/11/15 10:47
 * @Version: 1.0
 */
public class RecursionTest {

    public static void main(String[] args) {
//        test(5);
        int factorial = factorial(5);
        System.out.println(factorial);
    }

    public static void test(int n){
        if (n > 1){
            test(n-1);
        }
        System.out.println(n);
    }

    public static int factorial(int n){
        if (n == 1){
            return 1;
        }else {
            return factorial(n-1) * n;
        }
    }
}
