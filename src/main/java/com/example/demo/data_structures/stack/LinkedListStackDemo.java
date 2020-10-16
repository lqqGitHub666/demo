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
        System.out.println("�������stack����");
        arrayStack.list();
        System.out.println("��������"+arrayStack.pop());
        System.out.println("����һ�����ݺ�stack������");
        arrayStack.list();
        System.out.println("��������"+arrayStack.pop());
        System.out.println("�����������ݺ�stack������");
        arrayStack.list();
        System.out.println("��������"+arrayStack.pop());
        System.out.println("�����������ݺ�stack������");
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

    //ջ��
    public boolean isFull(){
        return top == maxSize - 1;
    }

    //ջ��
    public boolean isEmpty(){
        return top == -1;
    }

    //��ջ
    public void push(T data){
        if (isFull()){
            System.out.println("ջ�����޷��������");
            return;
        }
        top++;
        singleLinkedList.addByOrder(data,top);
    }

    //��ջ
    public T pop(){
        if (isEmpty()){
            System.out.println("ջ�գ������ݵ���");
            return null;
        }
        Object data = singleLinkedList.get(top);
        top --;
        return data == null ? null : (T)data;
    }

    //��ʾջ������
    public void list(){
        if (isEmpty()){
            System.out.println("ջ��");
            return;
        }
        for (int i = top; i >=0; i --){
            System.out.println(singleLinkedList.get(i));
        }
    }
}

/**
 * ����SingleLinkedList�������ǵ�Ӣ��
 **/
class SingleLinkedList<T>{

    //�ȳ�ʼ��һ��ͷ�ڵ�,ͷ�ڵ㲻Ҫ�������������
    private Node<T> head;

    private int tailIndex;

    public SingleLinkedList() {
        head = new Node<>(0,null);
        tailIndex = 0;
    }

    //�������
    //�������Ǳ��˳��ʱ
    //1.�ҵ���ǰ��������ڵ�
    //2.���������ڵ��nextָ���µĽڵ�
    public void add(T data){
        //��Ϊhead�ڵ㲻�ܶ������������Ҫһ����������temp
        Node temp = head;
        //���������ҵ����
        while (true){
            //�ҵ��������
            if (temp.next == null){
                break;
            }
            //���û���ҵ����,����temp����temp����һ���ڵ㣬����temp����һλ
            temp = temp.next;
        }
        //���˳���whileʱ��temp��ָ������������
        //���������ڵ��nextָ���½ڵ�
        Node<T> node = new Node<>(tailIndex++,data);
        temp.next = node;
    }

    //��ʾ����
    public void list(){
        //�ж������Ƿ�Ϊ��
        if (head.next == null){
            System.out.println("����Ϊ��");
            return;
        }
        //��Ϊͷ�ڵ㲻�ܶ��������Ҫһ����������������
        Node<T> temp = head.next;
        while (true){
            //�ж��Ƿ�Ϊ�������
            if (temp == null){
                break;
            }
            //����ڵ���Ϣ
            System.out.println(temp);
            //��next����
            temp = temp.next;
        }
    }

    //�ڶ�����ӽڵ�ķ�ʽ�������������뵽ָ��λ��
    //���������������������ʧ�ܣ���������ʾ��
    public void addByOrder(T data,int index){
        //��Ϊͷ�ڵ㲻�ܶ������������Ȼͨ������ָ���������ҵ���ӵ�λ��
        //��Ϊ��������Ϊ�����ҵ�temp��λ�����λ�õ�ǰһ���ڵ㣬������벻��
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
            System.out.println("Ӣ�۱���ظ�");
        }
    }
    //����no����޸Ľڵ���Ϣ
    public void update(T newData,int index){
        //�ж�����Ϊ��
        if (head.next == null){
            System.out.println("����Ϊ��");
            return;
        }
        Node<T> newNode = new Node<>(index,newData);
        Node<T> temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                System.out.println("����Ϊ��");
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
            System.out.println("�޸ĵĽڵ㲻����");
        }
    }

    //��һ��������ɾ��һ���ڵ��˼·
    //1.head�ڵ㲻�ܶ������������Ҫһ��temp�����ӵ��ҵ���ɾ����ǰһ���ڵ�
    //2.˵�����ǱȽ�ʱ����temp.next.no����Ҫɾ���Ľڵ��no�Ƚ�
    public void delete(int index){
        Node<T> temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                System.out.println("����Ϊ��");
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
            System.out.println("û���ҵ�Ҫɾ���Ľڵ�");
        }
    }

    /**
     * ��ȡ����ָ��λ�õ�ֵ
     */
    public T get(int index){
        Node<T> temp = head;
        while (true){
            if (temp.next == null){
                System.out.println("����Ϊ��");
                return null;
            }
            if (temp.next.index == index){
                return temp.next.data == null ? null : (T) temp.next.data;
            }
            temp = temp.next;
        }
    }

    /**
     * ��������Ч�ڵ�ĸ���
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
     * ��ѯ�����k���ڵ�
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
     * ������ת
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
     * ����node��ÿ��node�������һ���ڵ�
     */
    static class Node<T>{

        public int index;
        public T data;
        public Node next;//ָ����һ���ڵ�

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


