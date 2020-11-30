package com.example.demo.data_structures.tree;

/**
 * @ClassName: ArrBinaryTreeDemo
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/11/30 21:30
 * @Version: 1.0
 */
public class ArrBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
//        arrBinaryTree.preOrder();
        arrBinaryTree.infixOrder();
        arrBinaryTree.postOrder();
    }


}
class ArrBinaryTree{

    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }
    public void preOrder(){
        preOrder(0);
    }
    public void infixOrder(){
        infixOrder(0);
    }
    public void postOrder(){
        postOrder(0);
    }

    //前序遍历
    public void preOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("数组为空");
            return;
        }
        System.out.println(arr[index]);
        if ((2*index+1) < arr.length){
            this.preOrder(2*index + 1);
        }
        if ((2*index+2) < arr.length){
            this.preOrder(2*index + 2);
        }
    }

    //中序遍历
    public void infixOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("数组为空");
            return;
        }
        if ((2*index+1) < arr.length){
            this.infixOrder(2*index + 1);
        }
        System.out.println(arr[index]);
        if ((2*index+2) < arr.length){
            this.infixOrder(2*index + 2);
        }
    }

    //后序遍历
    public void postOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("数组为空");
            return;
        }
        if ((2*index+1) < arr.length){
            this.postOrder(2*index + 1);
        }
        if ((2*index+2) < arr.length){
            this.postOrder(2*index + 2);
        }
        System.out.println(arr[index]);
    }
}
