package com.example.demo.data_structures.searchstructures;

import java.util.Arrays;

/**
 * @ClassName: FibnacciSearch
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/11/25 18:55
 * @Version: 1.0
 */
public class FibonacciSearch {

    private static final int maxSize = 20;
    public static void main(String[] args) {
        int[] arr = new int[]{1,8,10,89,1000,1234};
    }

    public static int fibonacciSearch(int [] a, int key){
        int low = 0;
        int high = a.length -1;
        int k = 0;
        int mid;
        int f[] = fib();
        while (high > f[k] - 1){
            k ++;
        }
        int[] temp = Arrays.copyOf(a,f[k]);
        for (int i = high +1; i < temp.length; i++) {
            temp[i] = a[high];
        }
        // 使用while来循环处理，找到我们的数 key
        while (low <= high) { // 只要这个条件满足，就可以找
            mid = low + f[k - 1] - 1;
            if(key < temp[mid]) { //我们应该继续向数组的前面查找(左边)
                high = mid - 1;
                //为甚是 k--
                //说明
                //1. 全部元素 = 前面的元素 + 后边元素
                //2. f[k] = f[k-1] + f[k-2]
                //因为 前面有 f[k-1]个元素,所以可以继续拆分 f[k-1] = f[k-2] + f[k-3]
                //即 在 f[k-1] 的前面继续查找 k--
                //即下次循环 mid = f[k-1-1]-1
                k--;
            } else if ( key > temp[mid]) { // 我们应该继续向数组的后面查找(右边)
                low = mid + 1;
                //为什么是k -=2
                //说明
                //1. 全部元素 = 前面的元素 + 后边元素
                //2. f[k] = f[k-1] + f[k-2]
                //3. 因为后面我们有f[k-2] 所以可以继续拆分 f[k-1] = f[k-3] + f[k-4]
                //4. 即在f[k-2] 的前面进行查找 k -=2
                //5. 即下次循环 mid = f[k - 1 - 2] - 1
                k -= 2;
            } else { //找到
                //需要确定，返回的是哪个下标
                if(mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }

    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }
}
