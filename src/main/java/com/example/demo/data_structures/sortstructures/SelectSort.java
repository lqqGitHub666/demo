package com.example.demo.data_structures.sortstructures;

import java.util.Arrays;

/**
 * @ClassName: SelectSort
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/11/16 20:54
 * @Version: 1.0
 */
public class SelectSort {

    public static void main(String[] args) {

        //选择排序分解
        int[] array = new int[]{1,7,2,4,3};
//        System.out.println("原始数组：");
//        System.out.println(Arrays.toString(array));
//
//
//        int tempIndex = 0;
//        int temp = array[0];
//        for (int j = 0+1; j < array.length; j++) {
//            if (temp > array[j]){
//                tempIndex = j;
//                temp = array[j];
//            }
//        }
//        array[tempIndex] = array[0];
//        array[0] = temp;
//        System.out.println("第1趟排序后的数组：");
//        System.out.println(Arrays.toString(array));
//
//
//        tempIndex = 1;
//        temp = array[1];
//        for (int j = 1+1; j < array.length; j++) {
//            if (temp > array[j]){
//                tempIndex = j;
//                temp = array[j];
//            }
//        }
//        array[tempIndex] = array[1];
//        array[1] = temp;
//        System.out.println("第2趟排序后的数组：");
//        System.out.println(Arrays.toString(array));
//
//
//        tempIndex = 2;
//        temp = array[2];
//        for (int j = 2+1; j < array.length; j++) {
//            if (temp > array[j]){
//                tempIndex = j;
//                temp = array[j];
//            }
//        }
//        array[tempIndex] = array[2];
//        array[2] = temp;
//        System.out.println("第3趟排序后的数组：");
//        System.out.println(Arrays.toString(array));


        selectSort(array);
        System.out.println("排序后的数组"+Arrays.toString(array));
    }

    //选择排序整合,时间复杂度O(n²),但是效率比冒泡快
    private static void selectSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            int tempIndex = i;
            int temp = array[i];
            for (int j = i+1; j < array.length; j++) {
                if (temp > array[j]){
                    tempIndex = j;
                    temp = array[j];
                }
            }
            if (tempIndex != i){
                array[tempIndex] = array[i];
                array[i] = temp;
            }
        }
    }
}
