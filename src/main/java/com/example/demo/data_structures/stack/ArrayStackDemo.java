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

class ArrayStack<T>{
    private int maxSize;

    private Object [] stack;

    private int top;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new Object[maxSize];
        this.top = -1;
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
    public void push(Object data){
        if (isFull()){
            System.out.println("栈满，无法添加数据");
            return;
        }
        top++;
        stack[top] = data;
    }

    //出栈
    public T pop(){
        if (isEmpty()){
            System.out.println("栈空，无数据弹出");
            return null;
        }
        Object data = stack[top];
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
            System.out.println(stack[i]);
        }
    }
}