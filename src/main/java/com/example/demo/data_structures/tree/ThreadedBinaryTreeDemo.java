package com.example.demo.data_structures.tree;

/**
 * @ClassName: ThreadedBinaryTree
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/12/1 21:02
 * @Version: 1.0
 */
public class ThreadedBinaryTreeDemo {


    public static void main(String[] args) {
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        ThreadedBinaryTree.Node root = new ThreadedBinaryTree.Node(1,"tom");
        ThreadedBinaryTree.Node node2 = new ThreadedBinaryTree.Node(3,"jack");
        ThreadedBinaryTree.Node node3 = new ThreadedBinaryTree.Node(6,"smith");
        ThreadedBinaryTree.Node node4 = new ThreadedBinaryTree.Node(8,"marry");
        ThreadedBinaryTree.Node node5 = new ThreadedBinaryTree.Node(10,"king");
        ThreadedBinaryTree.Node node6 = new ThreadedBinaryTree.Node(14,"dim");
        threadedBinaryTree.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        threadedBinaryTree.threadedNodes();
        System.out.println(node5.getLeft());
        System.out.println(node5.getRight());
    }


}

class ThreadedBinaryTree{

    private Node root;

    private Node pre = null;

    public void setRoot(Node root) {
        this.root = root;
    }

    public void threadedNodes(){
        threadedNodes(root);
    }

    public void threadedNodes(Node node){
        if (node == null){
            return;
        }
        threadedNodes(node.left);
        if (node.left == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.right == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        threadedNodes(node.right);
    }

    static class Node {

        private int no;

        private String data;

        private Node left;

        private Node right;

        private int leftType;

        private int rightType;

        public int getLeftType() {
            return leftType;
        }

        public void setLeftType(int leftType) {
            this.leftType = leftType;
        }

        public int getRightType() {
            return rightType;
        }

        public void setRightType(int rightType) {
            this.rightType = rightType;
        }

        public Node(int no, String data) {
            this.no = no;
            this.data = data;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
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
                    "no=" + no +
                    ", data='" + data + '\'' +
                    '}';
        }
    }
}
