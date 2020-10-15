package com.example.demo.data_structures.linkedList;

/**
 * @ClassName: Josepfu
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/10/14 11:05
 * @Version: 1.0
 */
public class Josepfu {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(5);
        circleSingleLinkedList.showList();
        circleSingleLinkedList.countBoy(1,2,5);
    }

}

class CircleSingleLinkedList{

    private Boy first;

    public void add(int nums){
        if (nums < 1){
            System.out.println("参数太小，无法形成环形链表");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1){
                first = boy;
            }else {
                curBoy.setNext(boy);
            }
            boy.setNext(first);
            curBoy = boy;
        }
    }

    public void showList(){
        if (first == null){
            System.out.println("链表为空");
        }
        int i = 1;
        Boy curBoy = first;
        while (true){
            System.out.println("第"+(i++)+"个小孩的编号是："+curBoy.getNo());
            if (curBoy.getNext().getNo() == first.getNo()){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    public void countBoy(int startNo,int countNum,int nums){
        if (nums < startNo || startNo < 1 || countNum < 1 || first == null){
            System.out.println("参数有误，请重新输入");
            return;
        }
        Boy startPreBoy = first;
        while (true){
            if (startPreBoy.getNext().getNo() == startNo){
                break;
            }
            startPreBoy = startPreBoy.getNext();
        }
        int count =1;
        Boy startBoy = startPreBoy.getNext();
        while (true){
            if (count == countNum){
                System.out.println(startBoy.getNo());
                startBoy = startBoy.getNext();
                startPreBoy.setNext(startBoy);
                if (startBoy.getNo() == startPreBoy.getNo()){
                    System.out.println("最后一个了");
                    System.out.println(startBoy.getNo());
                    break;
                }
                count = 1;
                continue;
            }
            count ++;
            startBoy = startBoy.getNext();
            startPreBoy = startPreBoy.getNext();
        }
    }

}

class Boy{

    private int no;

    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
