package com.example.demo.data_structures.searchstructures;

/**
 * @ClassName: SeqSearch
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/11/24 20:27
 * @Version: 1.0
 */
public class SeqSearch {

    public static void main(String[] args) {

        int[] arr = {1,9,11,-1,34,89};
        int i = seqSearch(arr, -1);
        if (i == -1){
            System.out.println("没找到");
        }else {
            System.out.println("下表为  "+ i);
        }

    }

    public static int seqSearch(int[] arr,int value){
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]){
                return i;
            }
        }
        return -1;
    }
}
