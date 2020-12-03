package com.example.demo.data_structures.huffmancode;

import java.util.*;

/**
 * @ClassName: HuffmanCode
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/12/3 20:59
 * @Version: 1.0
 */
public class HuffmanCode {

    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        Node huffmanTree = createHuffmanTree(getNodes(contentBytes));
        huffmanTree.preOrder();
    }

    public static List<Node> getNodes(byte[] bytes){
        List<Node> nodes = new ArrayList<>();
        Map<Byte,Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        for (Map.Entry<Byte,Integer> entry : counts.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }

    public static Node createHuffmanTree(List<Node> nodes){
        while (nodes.size() > 1){
            //1.排序
            Collections.sort(nodes);
            //2.
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null,leftNode.getWeight()+rightNode.getWeight());
            parent.setLeft(leftNode);
            parent.setRight(rightNode);
            nodes.add(parent);
            nodes.remove(leftNode);
            nodes.remove(rightNode);
        }
        return nodes.get(0);
    }

    private static void preOrder(Node root){
        if (root != null){
            root.preOrder();
        }
    }
    static class Node implements Comparable<Node>{

        private Byte data;
        private int weight;
        private Node left;
        private Node right;

        public Node(Byte data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }

        //前序遍历
        public void preOrder(){
            System.out.println(this);
            if (this.left != null){
                this.left.preOrder();
            }
            if (this.right != null){
                this.right.preOrder();
            }
        }

        public Byte getData() {
            return data;
        }

        public void setData(Byte data) {
            this.data = data;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
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
    }
}
