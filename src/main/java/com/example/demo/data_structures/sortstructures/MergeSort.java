package com.example.demo.data_structures.sortstructures;

import java.util.Arrays;

/**
 * @ClassName: MergeSort
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/11/23 20:25
 * @Version: 1.0
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] arr = new int[]{8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr,int left,int right,int[] temp){

    }
}
