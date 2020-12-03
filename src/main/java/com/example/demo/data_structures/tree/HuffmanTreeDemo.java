package com.example.demo.data_structures.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: HuffmanTreeDemo
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/12/3 19:58
 * @Version: 1.0
 */
public class HuffmanTreeDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{13,7,8,3,29,6,1};
        Node huffmanTree = createHuffmanTree(arr);
        huffmanTree.preOrder();
    }


    public static Node createHuffmanTree(int[] arr){
        List<Node> nodes = new ArrayList<>(arr.length);
        for (int val : arr) {
            nodes.add(new Node(val));
        }
        while (nodes.size() > 1){
            //1.排序
            Collections.sort(nodes);
            //2.
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(leftNode.getValue()+rightNode.getValue());
            parent.setLeft(leftNode);
            parent.setRight(rightNode);
            nodes.add(parent);
            nodes.remove(leftNode);
            nodes.remove(rightNode);
        }
        return nodes.get(0);
    }


    static class Node implements Comparable<Node>{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }

        public void preOrder(){
            System.out.println(this);
            if (this.left != null){
                this.left.preOrder();
            }
            if (this.right != null){
                this.right.preOrder();
            }
        }
    }
}

