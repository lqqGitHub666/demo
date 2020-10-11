package com.example.demo.data_structures.linkedList;

import java.util.Stack;

/**
 * @ClassName: SingleLinkedList
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/9/29 10:20
 * @Version: 1.0
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "lqq", "玉面小白龙");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode4);
        int length = SingleLinkedList.getLength(singleLinkedList.getHead());
        System.out.println("链表有效长度length="+length);
        int k = 3;
        System.out.println("链表倒数第 "+k+" 个元素="+SingleLinkedList.findLastIndexNode(singleLinkedList.getHead(),k));
        SingleLinkedList.reverseList(singleLinkedList.getHead());
        System.out.println("反转的单链表如下");
        singleLinkedList.list();
        System.out.println("反向打印的单链表如下");
        SingleLinkedList.reversePrint(singleLinkedList.getHead());
//        System.out.println("查询出的英雄");
//        System.out.println(singleLinkedList.get(1));
//        System.out.println("新增后的list");
//        singleLinkedList.list();
//        HeroNode heroNode5 = new HeroNode(2, "小卢", "玉麒麟--小卢");
//        singleLinkedList.update(heroNode5);
//        System.out.println("修改后的list");
//        singleLinkedList.list();
//        singleLinkedList.delete(1);
//        System.out.println("删除后的list");
//        singleLinkedList.list();

    }
}


/**
 * 定义SingleLinkedList管理我们的英雄
 **/
class SingleLinkedList{

    //先初始化一个头节点,头节点不要动，不存放数据
    private HeroNode head;

    public SingleLinkedList() {
        head = new HeroNode(0,"","");
    }

    public HeroNode getHead() {
        return head;
    }

    //添加数据
    //当不考虑编号顺序时
    //1.找到当前链表的最后节点
    //2.见最后这个节点的next指向新的节点
    public void add(HeroNode heroNode){
       //因为head节点不能动，因此我们需要一个辅助变量temp
        HeroNode temp = head;
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
        temp.next = heroNode;
    }

    //显示链表
    public void list(){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此需要一个辅助变量来遍历
        HeroNode temp = head.next;
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
    public void addByOrder(HeroNode heroNode){
        //因为头节点不能动，因此我们仍然通过辅助指针来帮助找到添加的位置
        //因为单链表，因为我们找的temp是位于添加位置的前一个节点，否则加入不了
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                flag = true;
                break;
            }
            if (temp.next.no == heroNode.no){
                break;
            }
            if (temp.next.no > heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            HeroNode next = temp.next;
            temp.next = heroNode;
            heroNode.next = next;
        }else if (temp.next.no == heroNode.no){
            System.out.println("英雄编号重复");
        }
    }
    //根据no编号修改节点信息
    public void update(HeroNode newHeroNode){
        //判断链表为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                System.out.println("链表为空");
                break;
            }
            if (temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else {
            System.out.println("修改的节点不存在");
        }
    }

    //从一个链表中删除一个节点的思路
    //1.head节点不能动，因此我们需要一个temp辅助接点找到待删除的前一个节点
    //2.说明我们比较时，是temp.next.no和需要删除的节点的no比较
    public void delete(int index){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                System.out.println("链表为空");
                break;
            }
            if (temp.next.no == index){
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
    public HeroNode get(int index){
        HeroNode temp = head;
        while (true){
            if (temp.next == null){
                System.out.println("链表为空");
                return null;
            }
            if (temp.next.no == index){
                return temp.next;
            }
            temp = temp.next;
        }
    }

    /**
     * 求单链表有效节点的个数
     */
    public static int getLength(HeroNode head){
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }

    /**
     * 查询链表第k个节点
     */
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        int length = getLength(head);
        if (index <= 0 || length < index){
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < length -index ; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 单链表反转
     */
    public static void reverseList(HeroNode head){

        if (head.next == null || head.next.next == null){
            return;
        }

        HeroNode next;
        HeroNode reverseHead = new HeroNode(0,"","");
        HeroNode cur = head.next;
        while (cur != null){
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    /**
     * 从未到头打印单链表
     */
    public static void reversePrint(HeroNode head){

        if (head .next == null){
            System.out.println("链表为空");
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0 ){
            System.out.println(stack.pop());
        }
    }
}
/**
 * 定义HeroNode，每个node对象就是一个节点
 */
class HeroNode{

    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname +"'}";
    }
}


