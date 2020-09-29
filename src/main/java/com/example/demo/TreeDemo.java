package com.example.demo;

/**
 * @ClassName: Tree
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/9/28 10:38
 * @Version: 1.0
 */
public class TreeDemo {


}

class Tree{

    private Long size;

    private Object root;

    public Tree(Long size) {
        this.size = size;
    }

    public void add(){

    }

    public static void main(String[] args) {
        Node node = new Node();
        Node temp = node;
        temp.data = 1;
        System.out.println(node.data);
    }

    static class Node<T>{
        private T data;

        private T right;

        private T left;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public T getRight() {
            return right;
        }

        public void setRight(T right) {
            this.right = right;
        }

        public T getLeft() {
            return left;
        }

        public void setLeft(T left) {
            this.left = left;
        }
    }


}
