package com.example.demo.data_structures.searchstructures;

/**
 * @ClassName: DichotomySearch
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/11/24 20:37
 * @Version: 1.0
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,12,33,45,789,1235,3366};
        int i = binarySearch(arr, 0, arr.length, 121);
        System.out.println(i);
    }

    public static int binarySearch(int[] arr,int left,int right, int val){
        if (right < left){
            return  -1;
        }
        int midIndex = (left+right)/2;
        if (val == arr[midIndex]){
            return midIndex;
        }else if (val > arr[midIndex]){
            return binarySearch(arr,midIndex,right,val);
        }else {
            return binarySearch(arr,left,midIndex,val);
        }
    }
}
