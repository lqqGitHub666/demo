package com.example.demo.data_structures.stack;

/**
 * @ClassName: ArrayStackDemo
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/10/16 10:22
 * @Version: 1.0
 */
public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>(4);
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

class ArrayStack<T>{
    private int maxSize;

    private Object [] stack;

    private int top;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new Object[maxSize];
        this.top = -1;
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
    public void push(Object data){
        if (isFull()){
            System.out.println("ջ�����޷��������");
            return;
        }
        top++;
        stack[top] = data;
    }

    //��ջ
    public T pop(){
        if (isEmpty()){
            System.out.println("ջ�գ������ݵ���");
            return null;
        }
        Object data = stack[top];
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
            System.out.println(stack[i]);
        }
    }
}