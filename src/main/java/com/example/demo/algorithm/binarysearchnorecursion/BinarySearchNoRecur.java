package com.example.demo.algorithm.binarysearchnorecursion;

/**
 * @ClassName: BinarySearchNoRecur
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/12/14 19:19
 * @Version: 1.0
 */
public class BinarySearchNoRecur {

    public static void main(String[] args) {
        //测试
        int[] arr = {1,3, 8, 10, 11, 67, 100};
        int index = binarySearch(arr, 1);
        System.out.println("index=" + index);//
    }

    public static int binarySearch(int [] arr,int target){
        int leftIndex = 0;
        int rightIndex = arr.length-1;
        while (leftIndex <= rightIndex){
            int midIndex = (leftIndex+rightIndex)/2;
            if (arr[midIndex] == target){
                return midIndex;
            }else if (arr[midIndex] > target){
                rightIndex = midIndex -1;
            }else {
                leftIndex = midIndex + 1;
            }
        }
        return -1;
    }
}
