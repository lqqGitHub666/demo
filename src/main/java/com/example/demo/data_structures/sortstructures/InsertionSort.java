package com.example.demo.data_structures.sortstructures;

import java.util.Arrays;

/**
 * @author 作者 lqq
 * @ClassName 类名 InsertionSort
 * @date 2020/11/17 22:27
 * @注释：
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{101,34,119,10,18,9,1};
        insertSort(arr);
//        insertSort2(arr);
    }

    //插入排序，时间复杂度O(n²)
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i-1;
            while (insertIndex >= 0 && arr[insertIndex] > insertVal){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex --;
            }
            arr[insertIndex+1] = insertVal;
            System.out.println("第( "+i+" )轮排序后的数组：");
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void insertSort2(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for ( int j = i-1; j >=0 ; j--) {
                int temp = arr[j];
                if (arr[j] > arr[j+1]){
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("第( "+i+" )轮排序后的数组：");
            System.out.println(Arrays.toString(arr));
        }
    }
}
