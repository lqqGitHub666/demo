package com.example.demo.data_structures.sortstructures;

import java.util.Arrays;

/**
 * @ClassName: BubblingSort
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/11/16 19:57
 * @Version: 1.0
 */
public class BubblingSort {

    public static void main(String[] args) {
        int[] array = new int[]{7,2,4,3};


        //排序分解
        for (int i = 0; i < array.length-1; i++) {
            int temp = array[i];
            if (array[i]>array[i+1]){
                array[i] = array[i+1];
                array[i+1] = temp;
            }
        }
        System.out.println("第一趟排序后的数组：");
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length-1-1; i++) {
            int temp = array[i];
            if (array[i]>array[i+1]){
                array[i] = array[i+1];
                array[i+1] = temp;
            }
        }
        System.out.println("第二趟排序后的数组：");
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length-1-1-1; i++) {
            int temp = array[i];
            if (array[i]>array[i+1]){
                array[i] = array[i+1];
                array[i+1] = temp;
            }
        }
        System.out.println("第三趟排序后的数组：");
        System.out.println(Arrays.toString(array));

//        int[] array1 = new int[]{7,5,4,3,9,10,1,2,-1,8,6};
//        bubbleSort(array1);
//        System.out.println("排序后的数组：");
//        System.out.println(Arrays.toString(array1));

    }

    //排序方法整合,时间复杂度O(n²)
    private static void bubbleSort(int[] arr){
        boolean flag = false;
        for (int j = 1; j < arr.length; j++) {
            for (int i = 0; i < arr.length-j; i++) {
                int temp = arr[i];
                if (arr[i]>arr[i+1]){
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }else {
                flag = false;
            }
        }
    }

}
