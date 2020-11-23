package com.example.demo.data_structures.sortstructures;

import java.util.Arrays;

/**
 * @ClassName: QuickSort
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/11/23 19:03
 * @Version: 1.0
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{-9,78,0,23,-567,-70};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }




    public static void quickSort(int[] arr,int leftIndex,int rightIndex){
        int temp;
        int l = leftIndex;
        int r = rightIndex;
        int pivot = arr[(leftIndex+rightIndex)/2];
        while (l < r){
            while (arr[l] < pivot ) {
                l+=1;
            }
            while (arr[r] > pivot){
                r-=1;
            }
            if (l>=r){
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot){
                r-=1;
            }
            if (arr[r] == pivot){
                l+=1;
            }
        }
        if (l == r){
            l+=1;
            r-=1;
        }
        if (leftIndex<r){
            quickSort(arr,leftIndex,r);
        }
        if (rightIndex>l){
            quickSort(arr,l,rightIndex);
        }
    }
}
