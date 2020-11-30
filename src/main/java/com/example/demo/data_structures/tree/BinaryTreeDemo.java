package com.example.demo.data_structures.tree;

/**
 * @ClassName: BinaryTree
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/11/26 20:05
 * @Version: 1.0
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(4,"a");
        binaryTree.add(2,"b");
        binaryTree.add(3,"c");
        binaryTree.add(1,"d");
        binaryTree.add(6,"f");
        binaryTree.add(5,"e");
        binaryTree.add(7,"f");
//        System.out.println(binaryTree);
//        binaryTree.proOrder();
//        binaryTree.infixOrder();
//        binaryTree.postOrder();
        System.out.println(binaryTree.preGet(6));
        System.out.println(binaryTree.infixGet(6));
        System.out.println(binaryTree.postGet(6));
    }


}
class BinaryTree{

    private Node root;

    //前序遍历
    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }
    }

    //中续遍历
    public void infixOrder(){
        if (this.root != null){
            this.root.infixOrder();
        }
    }

    //后序遍历
    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }
    }

    public void add(int no,String data){

        Node node = new Node(no,data);
        if (this.root == null){
            this.root = node;
        }else {
            this.root.setNode(node);
        }

    }

    public Node preGet(int no){
        if (this.root != null){
            return this.root.preGet(no);
        }else {
            return null;
        }
    }

    public Node infixGet(int no){
        if (this.root != null){
            return this.root.infixGet(no);
        }else {
            return null;
        }
    }

    public Node postGet(int no){
        if (this.root != null){
            return this.root.postGet(no);
        }else {
            return null;
        }
    }

    //简单删除
    public void simpleDelNode(int no){
        if (root != null){
            if (root.no == no){
                root = null;
            }else {
                root.simpleDelNode(no);
            }
        }else {
            System.out.println("空树");
        }
    }

    static class Node{

        private int no;

        private String data;

        private Node left;

        private Node right;

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

        //中续遍历
        public void infixOrder(){
            if (this.left != null){
                this.left.infixOrder();
            }
            System.out.println(this);
            if (this.right != null){
                this.right.infixOrder();
            }
        }

        //后序遍历
        public void postOrder(){
            if (this.left != null){
                this.left.postOrder();
            }
            if (this.right != null){
                this.right.postOrder();
            }
            System.out.println(this);
        }

        //前序查找
        public Node preGet(int no){
            if (this.no == no){
                return this;
            }
            Node node = null;
            if (this.left != null){
                node = this.left.preGet(no);
            }
            if (node != null){
                return node;
            }
            if (this.right != null) {
                node =  this.right.preGet(no);
            }
            return node;
        }
        //中序查找
        public Node infixGet(int no){
            Node node = null;
            if (this.left != null){
                node = this.left.infixGet(no);
            }
            if (node != null){
                return node;
            }
            if (this.no == no){
                return this;
            }
            if (this.right != null) {
                node =  this.right.infixGet(no);
            }
            return node;
        }
        //后序查找
        public Node postGet(int no){
            Node node = null;
            if (this.left != null){
                node = this.left.postGet(no);
            }
            if (node != null){
                return node;
            }
            if (this.right != null) {
                node =  this.right.postGet(no);
            }
            if (node != null){
                return node;
            }
            if (this.no == no){
                return this;
            }
            return null;
        }

        //添加节点
        public void setNode(Node node) {

            if (node.no > this.no){
                if (this.right == null){
                    this.right = node;
                }else {
                    this.right.setNode(node);
                }
            }else {
                if (this.left == null){
                    this.left= node;
                }else {
                    this.left.setNode(node);
                }
            }

        }

        //删除节点（简单删除）
        public void simpleDelNode(int no){
            if (this.left != null && this.left.no == no){
                this.left = null;
                return;
            }
            if (this.right != null && this.right.no == no){
                this.right = null;
                return;
            }
            if (this.left != null){
                this.left.simpleDelNode(no);
            }
            if (this.right != null){
                this.right.simpleDelNode(no);
            }
        }

    }
}
