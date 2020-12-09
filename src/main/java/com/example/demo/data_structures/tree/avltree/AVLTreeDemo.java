package com.example.demo.data_structures.tree.avltree;

/**
 * @ClassName: AVLTreeDemo
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/12/9 19:36
 * @Version: 1.0
 */
public class AVLTreeDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,6,5,7,8};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new AVLTree.Node(arr[i]));
        }
        avlTree.infixOrder();
        System.out.println(avlTree.height());
        System.out.println(avlTree.leftHeight());
        System.out.println(avlTree.rightHeight());
    }

}
class AVLTree{

    private Node root;

    public void add(Node node){
        if (root == null){
            root = node;
        }else {
            root.add(node);
        }
    }

    public void infixOrder(){
        if (root == null){
            return;
        }else {
            root.infixOrder();
        }
    }

    public int height(){
        if (root ==null){
            return 0;
        }
        return root.height();
    }

    public int leftHeight(){
        if (root ==null){
            return 0;
        }
        return root.leftHeight();
    }

    public int rightHeight(){
        if (root ==null){
            return 0;
        }
        return root.rightHeight();
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }
    static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int leftHeight(){
            if (left == null){
                return 0;
            }
            return left.height();
        }

        public int rightHeight(){
            if (right == null){
                return 0;
            }
            return right.height();
        }

        public int height(){
            return Math.max(left == null ? 0 : left.height(),right == null ? 0 : right.height()) + 1;
        }

        //左旋转
        private void leftRotate(){
            //创建新的结点，以当前根结点的值
            Node newNode = new Node(value);
            //把新的节点的左子树设置成当前节点的左子树
            newNode.left = left;
            //把新结点的右子树设置成当前结点的右子树的左子树
            newNode.right = right.left;
            //把当前节点的值替换成右子节点的值
            value = right.value;
            //把当前结点的右子树设置成当前节点右子树的右子树
            right = right.right;
            //把当前节点的左子树（左子节点）设置成新的节点
            left = newNode;
        }

        //右旋转
        private void rightRotate(){
            Node newNode = new Node(value);
            newNode.right = right;
            newNode.left = left.right;
            value = left.value;

            left = left.left;
            right = newNode;
        }

        private void add(Node node){
            if (node == null){
                return;
            }
            if (node.value < this.value){
                if (this.left != null){
                    this.left.add(node);
                }else {
                    this.left = node;
                }
            }else {
                if (this.right != null){
                    this.right.add(node);
                }else {
                    this.right = node;
                }
            }
            if (rightHeight() - leftHeight() > 1){
                //如果它的右子树的左子树的高度大于它的右子树的右子树的高度
                if (right != null && right.leftHeight() > right.rightHeight()){
                    //当前节点的右子树进行右旋转
                    right.rightRotate();
                }
                leftRotate();
                //这里的return必须要，避免多余的判断
                return;
            }
            if (leftHeight() - rightHeight() > 1){
                //如果它的左子树的右子树的高度大于它的左子树的左子树的高度
                if(left != null && left.rightHeight() > left.leftHeight()) {
                    //先对当前节点的左节点（左子树）->左旋转
                    left.leftRotate();
                }
                //对当前节点进行右旋转
                rightRotate();
            }
        }

        private Node search(int value){
            if (value == this.value){
                return this;
            }else if (value < this.value){
                if (this.left == null){
                    return null;
                }
                return this.left.search(value);
            }else {
                if (this.right == null){
                    return null;
                }
                return this.right.search(value);
            }
        }
        private Node searchParent(int value){
            if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)){
                return this;
            }else {
                if (value < this.value && this.left != null){
                    return this.left.searchParent(value);
                }else if (value >= this.value && this.right != null){
                    return this.right.searchParent(value);
                }else {
                    return null;
                }
            }
        }

        private void infixOrder(){
            if (this.left != null){
                this.left.infixOrder();
            }
            System.out.println(this);
            if (this.right != null){
                this.right.infixOrder();
            }
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
    }
}