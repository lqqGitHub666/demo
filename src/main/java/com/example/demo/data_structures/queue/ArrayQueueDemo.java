package com.example.demo.data_structures.queue;

/**
 * @author 作者 lqq
 * @ClassName 类名 ArrayQueue
 * @date 2020/9/24 19:04
 * @注释：
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(4);
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(2);
        arrayQueue.addQueue(3);
        arrayQueue.addQueue(4);
        arrayQueue.showQueue();
        System.out.println(arrayQueue.getQueue());
        arrayQueue.showQueue();
        arrayQueue.addQueue(8);
    }

}
//使用数组模拟队列
class ArrayQueue<T>{

    /**表示数组最大容量*/
    private int maxSize;
    /**队列头*/
    private int front;
    /**队列尾*/
    private int rear;
    /**该数组用于存放数据，模拟队列*/
    private Object[] arr;

    public ArrayQueue() {
        this(8);
    }

    //创建队列的构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new Object [maxSize];
        this.front = -1;
        this.rear = -1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        if (front == rear){
            return true;
        }else {
            return false;
        }
    }

    //判断队列是否已满
    public boolean isFull(){
        if (rear == (maxSize-1)){
            return true;
        }else {
            return false;
        }
    }

    //向队列中添加数据
    public void addQueue(Object o){
        if (isFull()){
            //或者考虑扩容
            throw new RuntimeException("队列已满");
        }
        rear++;//rear后移
        arr[rear] = o;
    }

    //从队列里面取数据
    public T getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        front++;//front后移
        return (T) arr[front];
    }

    //显示队列的所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列是空的");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    //显示队列的头数据，注意不是取数据
    public T headQueue(){
        if (isEmpty()){
            throw  new RuntimeException("队列为空");
        }
        return (T) arr[front+1];
    }
}