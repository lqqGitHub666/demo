package com.example.demo.data_structures.tree;

import java.util.Arrays;

/**
 * @ClassName: HeapSort
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/12/2 20:33
 * @Version: 1.0
 */
public class HeapSort {

    public static void main(String[] args) {
        int [] arr = new int[]{4,6,8,5,9};
        heapSort(arr);
    }

    public static void heapSort(int[] arr){
        int temp = 0;
//        adjustHeap(arr,1,arr.length);
//        System.out.println("第一次"+ Arrays.toString(arr));
//        adjustHeap(arr,0,arr.length);
//        System.out.println("第二次"+ Arrays.toString(arr));
        for (int i = arr.length / 2 - 1;i>=0; i--) {
            adjustHeap(arr,i,arr.length);
        }

        for (int j = arr.length-1; j >0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
        System.out.println("数组"+Arrays.toString(arr));
    }



    public static void adjustHeap(int[] arr,int i, int length){

        int temp = arr[i];
        for (int k = 2*i+1; k < length; k = k*2+1){
            if (k+1 < length && arr[k] < arr[k+1]){
                k++;
            }
            if (arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
        arr[i] = temp;
    }
}
