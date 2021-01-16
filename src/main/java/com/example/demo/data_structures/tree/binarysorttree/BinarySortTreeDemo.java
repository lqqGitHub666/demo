package com.example.demo.data_structures.tree.binarysorttree;

/**
 * @ClassName: BinarySortTreeDemo
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/12/8 19:42
 * @Version: 1.0
 */
public class BinarySortTreeDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{7,3,10,12,5,1,9,2};
        //创建二叉树
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new BinarySortTree.Node(arr[i]));
        }
        //遍历
        binarySortTree.infixOrder();
        binarySortTree.delNode(7);
        System.out.println("-----------------");
        binarySortTree.infixOrder();
    }



}

class BinarySortTree{

    private Node root;

    //删除节点
    public void delNode(int value){
        if (root == null){
            return;
        }else {
            Node targetNode = search(value);
            if (targetNode == null){
                return;
            }
            if (root.left == null && root.right == null){
                root = null;
                return;
            }
            Node parent = searchParent(value);
            if (targetNode.left == null && targetNode.right == null){
                if (parent.left != null && parent.left.value == value){
                    parent.left = null;
                }else if (parent.right!= null && parent.right.value == value){
                    parent.right = null;
                }
            }else if (targetNode.left != null && targetNode.right != null){
                int rightMinNode = delRightMinNode(targetNode.right);
                targetNode.value = rightMinNode;
            }else {
                if (targetNode.left != null){
                    if (parent == null){
                        root = targetNode.left;
                    }else {
                        if (parent.left.value == value){
                            parent.left = targetNode.left;
                        }else if (parent.right.value == value){
                            parent.right = targetNode.left;
                        }
                    }
                }else if (targetNode.right != null){
                    if (parent == null){
                        root = targetNode.right;
                    }else {
                        if (parent.left.value == value){
                            parent.left = targetNode.right;
                        }else if (parent.right.value == value){
                            parent.right = targetNode.right;
                        }
                    }
                }
            }
        }
    }

    private int delRightMinNode(Node node){
        Node target = node;
        while (target.left != null){
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    public Node search(int value){
        if (root == null){
            return null;
        }else {
            return root.search(value);
        }
    }

    public Node searchParent(int value){
        if (root == null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }



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

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node search(int value){
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
        public Node searchParent(int value){
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

        public void add(Node node){
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
        }

        public void infixOrder(){
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
