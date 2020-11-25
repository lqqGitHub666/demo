package com.example.demo.data_structures.searchstructures;

/**
 * @ClassName: InsertValueSearch
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/11/25 13:06
 * @Version: 1.0
 */
public class InsertValueSearch {

    public static void main(String[] args) {

        int[] arr = new int[]{1,8,10,89,1000,1234};
        int i = insertValueSearch(arr, 0, arr.length - 1, 1234);
        System.out.println(i);
    }

    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {

        if (left > right || findVal < arr[left] || findVal > arr[right]){
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left])/(arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal){
            return insertValueSearch(arr,mid+1,right,findVal);
        }else if (findVal < midVal){
            return insertValueSearch(arr,left,mid-1,findVal);
        }else {
            return mid;
        }
    }


}
