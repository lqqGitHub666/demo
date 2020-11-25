package com.example.demo.data_structures.searchstructures;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DichotomySearch
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/11/24 20:37
 * @Version: 1.0
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,12,12,12,12,12,12,33,45,789,1235,3366};
        List list = binarySearchRepeat(arr, 0, arr.length - 1, 12);
        System.out.println(list);
    }

    public static int binarySearch(int[] arr,int left,int right, int val){
        if (right < left){
            return  -1;
        }
        int midIndex = (left+right)/2;
        if (val == arr[midIndex]){
            return midIndex;
        }else if (val > arr[midIndex]){
            return binarySearch(arr,midIndex+1,right,val);
        }else {
            return binarySearch(arr,left,midIndex-1,val);
        }
    }

    //找到所有的满足条件的数据都找出来
    public static List binarySearchRepeat(int[] arr, int left, int right, int val){
        if (right < left){
            return  null;
        }
        int midIndex = (left+right)/2;
        if (val == arr[midIndex]){
            List<Integer> list = new ArrayList<>();
            int index = midIndex -1;
            while (true){
                if (index < 0 || arr[index] != val){
                    break;
                }
                list.add(index);
                index --;
            }
            list.add(midIndex);
            index = midIndex + 1;
            while (true){
                if (index > arr.length || arr[index] != val){
                    break;
                }
                list.add(index);
                index ++;
            }
            return list;
        }else if (val > arr[midIndex]){
            return binarySearchRepeat(arr,midIndex+1,right,val);
        }else {
            return binarySearchRepeat(arr,left,midIndex-1,val);
        }
    }
}
