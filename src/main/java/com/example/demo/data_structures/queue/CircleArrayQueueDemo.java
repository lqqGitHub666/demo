package com.example.demo.data_structures.queue;

/**
 * @author 作者 lqq
 * @ClassName 类名 CircleArrayQueueDemo
 * @date 2020/9/24 20:37
 * @注释：
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        CircleArrayQueue<Integer> arrayQueue = new CircleArrayQueue<>(4);
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(2);
        arrayQueue.addQueue(3);
        arrayQueue.addQueue(4);
        arrayQueue.showQueue();
        System.out.println(arrayQueue.getQueue());
        arrayQueue.showQueue();
        arrayQueue.addQueue(8);
        arrayQueue.showQueue();
    }
}
//使用数组模拟队列
/**
 * 1.  front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
 * front 的初始值 = 0
 * 2.  rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
 * rear 的初始值 = 0
 * 3. 当队列满时，条件是  (rear  + 1) % maxSize == front 【满】
 * 4. 对队列为空的条件， rear == front 空
 * 5. 当我们这样分析， 队列中有效的数据的个数   (rear + maxSize - front) % maxSize   // rear = 1 front = 0
 * 6. 我们就可以在原来的队列上修改得到，一个环形队列
 */
class CircleArrayQueue<T>{

    /**表示数组最大容量*/
    private int maxSize;
    /**队列头*/
    private int front;
    /**队列尾*/
    private int rear;
    /**该数组用于存放数据，模拟队列*/
    private Object[] arr;

    public CircleArrayQueue() {
        this(8);
    }

    //创建队列的构造器
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize+1;
        this.arr = new Object [maxSize+1];
    }

    //判断队列是否已满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }

    //向队列中添加数据
    public void addQueue(Object o){
        if (isFull()){
            //或者考虑扩容
            throw new RuntimeException("队列已满");
        }
        arr[rear] = o;
        //rear后移,这里必须考虑取模
        rear=(rear+1)%maxSize;
    }

    //从队列里面取数据
    public T getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        //这里需要分析出front是指向队列的第一个元素
        //1.先把front对应的值保留到一个临时变量
        //2.将front后移,考虑取模
        Object o = arr[front];
        //front后移
        front = (front+1)%maxSize;
        return (T)o;
    }

    //显示队列的所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列是空的");
            return;
        }
        //从front开始遍历，遍历有效元素
        //
        for (int i = front; i < front+size(); i++) {
            System.out.println(arr[i%maxSize]);
        }
    }

    //求出当前队列中有效数据的个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    //显示队列的头数据，注意不是取数据
    public T headQueue(){
        if (isEmpty()){
            throw  new RuntimeException("队列为空");
        }
        return (T) arr[front];
    }
}

class CircleArrayQueue1<T>{

    /**表示数组最大容量*/
    private int maxSize;
    /**队列头*/
    private int front;
    /**队列尾*/
    private int rear;
    /**该数组用于存放数据，模拟队列*/
    private Object[] arr;

    public CircleArrayQueue1() {
        this(8);
    }

    //创建队列的构造器
    public CircleArrayQueue1(int maxSize) {
        this.maxSize = maxSize+1;
        this.arr = new Object [maxSize+1];
    }

    //判断队列是否已满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }

    //向队列中添加数据
    public void addQueue(Object o){
        if (isFull()){
            //或者考虑扩容
            throw new RuntimeException("队列已满");
        }
        arr[rear] = o;
        //rear后移,这里必须考虑取模
        rear=(rear+1)%maxSize;
    }

    //从队列里面取数据
    public T getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        //这里需要分析出front是指向队列的第一个元素
        //1.先把front对应的值保留到一个临时变量
        //2.将front后移,考虑取模
        Object o = arr[front];
        //front后移
        front = (front+1)%maxSize;
        return (T)o;
    }

    //显示队列的所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列是空的");
            return;
        }
        //从front开始遍历，遍历有效元素
        //
        for (int i = front; i < front+size(); i++) {
            System.out.println(arr[i%maxSize]);
        }
    }

    //求出当前队列中有效数据的个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    //显示队列的头数据，注意不是取数据
    public T headQueue(){
        if (isEmpty()){
            throw  new RuntimeException("队列为空");
        }
        return (T) arr[front];
    }
}