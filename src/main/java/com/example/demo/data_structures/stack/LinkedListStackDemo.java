package com.example.demo.data_structures.stack;


/**
 * @ClassName: LinkedListStackDemo
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/10/16 13:42
 * @Version: 1.0
 */
public class LinkedListStackDemo {

    public static void main(String[] args) {
        LinkedListStack<Integer> arrayStack = new LinkedListStack<>(4);
        arrayStack.push(10);
        arrayStack.push(20);
        arrayStack.push(30);
        arrayStack.push(40);
        arrayStack.push(40);
        System.out.println("添加完后的stack数据");
        arrayStack.list();
        System.out.println("弹出的数"+arrayStack.pop());
        System.out.println("弹出一条数据后，stack的数据");
        arrayStack.list();
        System.out.println("弹出的数"+arrayStack.pop());
        System.out.println("弹出两条数据后，stack的数据");
        arrayStack.list();
        System.out.println("弹出的数"+arrayStack.pop());
        System.out.println("弹出三条数据后，stack的数据");
        arrayStack.list();
    }
}

class LinkedListStack<T>{
    private int maxSize;
    private SingleLinkedList singleLinkedList;
    private int top;

    public LinkedListStack(int maxSize) {
        singleLinkedList = new SingleLinkedList();
        this.maxSize = maxSize;
        top = -1;
    }

    //栈满
    public boolean isFull(){
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(T data){
        if (isFull()){
            System.out.println("栈满，无法添加数据");
            return;
        }
        top++;
        singleLinkedList.addByOrder(data,top);
    }

    //出栈
    public T pop(){
        if (isEmpty()){
            System.out.println("栈空，无数据弹出");
            return null;
        }
        Object data = singleLinkedList.get(top);
        top --;
        return data == null ? null : (T)data;
    }

    //显示栈内数据
    public void list(){
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >=0; i --){
            System.out.println(singleLinkedList.get(i));
        }
    }
}

/**
 * 定义SingleLinkedList管理我们的英雄
 **/
class SingleLinkedList<T>{

    //先初始化一个头节点,头节点不要动，不存放数据
    private Node<T> head;

    private int tailIndex;

    public SingleLinkedList() {
        head = new Node<>(0,null);
        tailIndex = 0;
    }

    //添加数据
    //当不考虑编号顺序时
    //1.找到当前链表的最后节点
    //2.见最后这个节点的next指向新的节点
    public void add(T data){
        //因为head节点不能动，因此我们需要一个辅助变量temp
        Node temp = head;
        //遍历链表，找到最后
        while (true){
            //找到链表最后
            if (temp.next == null){
                break;
            }
            //如果没有找到最后,就让temp等于temp的下一个节点，即让temp后移一位
            temp = temp.next;
        }
        //当退出的while时，temp就指向了链表的最后
        //将最后这个节点的next指向新节点
        Node<T> node = new Node<>(tailIndex++,data);
        temp.next = node;
    }

    //显示链表
    public void list(){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此需要一个辅助变量来遍历
        Node<T> temp = head.next;
        while (true){
            //判断是否为链表最后
            if (temp == null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将next后移
            temp = temp.next;
        }
    }

    //第二种添加节点的方式，根据排名插入到指定位置
    //（如果有这个排名，则添加失败，并给出提示）
    public void addByOrder(T data,int index){
        //因为头节点不能动，因此我们仍然通过辅助指针来帮助找到添加的位置
        //因为单链表，因为我们找的temp是位于添加位置的前一个节点，否则加入不了
        Node<T> node = new Node<>(index,data);
        Node<T> temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                flag = true;
                break;
            }
            if (temp.next.index == node.index){
                break;
            }
            if (temp.next.index > node.index){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            Node next = temp.next;
            temp.next = node;
            node.next = next;
        }else if (temp.next.index == node.index){
            System.out.println("英雄编号重复");
        }
    }
    //根据no编号修改节点信息
    public void update(T newData,int index){
        //判断链表为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        Node<T> newNode = new Node<>(index,newData);
        Node<T> temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                System.out.println("链表为空");
                break;
            }
            if (temp.index == newNode.index){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.data = newNode.data;
        }else {
            System.out.println("修改的节点不存在");
        }
    }

    //从一个链表中删除一个节点的思路
    //1.head节点不能动，因此我们需要一个temp辅助接点找到待删除的前一个节点
    //2.说明我们比较时，是temp.next.no和需要删除的节点的no比较
    public void delete(int index){
        Node<T> temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                System.out.println("链表为空");
                break;
            }
            if (temp.next.index == index){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("没有找到要删除的节点");
        }
    }

    /**
     * 获取链表指定位置的值
     */
    public T get(int index){
        Node<T> temp = head;
        while (true){
            if (temp.next == null){
                System.out.println("链表为空");
                return null;
            }
            if (temp.next.index == index){
                return temp.next.data == null ? null : (T) temp.next.data;
            }
            temp = temp.next;
        }
    }

    /**
     * 求单链表有效节点的个数
     */
    public int getLength(){
        int length = 0;
        Node<T> cur = head.next;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }

    /**
     * 查询链表第k个节点
     */
    public Node findLastIndexNode(int index){
        int length = getLength();
        if (index <= 0 || length < index){
            return null;
        }
        Node cur = head.next;
        for (int i = 0; i < length -index ; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 单链表反转
     */
    public void reverseList(){

        if (head.next == null || head.next.next == null){
            return;
        }

        Node next;
        Node reverseHead = new Node(0,null);
        Node cur = head.next;
        while (cur != null){
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    /**
     * 定义node，每个node对象就是一个节点
     */
    static class Node<T>{

        public int index;
        public T data;
        public Node next;//指向下一个节点

        public Node(int index, T data) {
            this.index = index;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

}


