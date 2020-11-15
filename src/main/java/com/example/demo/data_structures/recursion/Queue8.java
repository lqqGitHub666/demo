package com.example.demo.data_structures.recursion;

/**
 * @ClassName: Queue8
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/11/15 12:50
 * @Version: 1.0
 */
public class Queue8 {

    int max = 8;
    int[] array = new int[max];
    int num = 0;
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println(queue8.num);
    }

    private void check(int n){
        if (n == max){
            print();
            num++;
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)){
                check(n+1);
            }
        }


    }

    private void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

}
