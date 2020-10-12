package com.example.demo.data_structures.linkedList;

import java.util.Stack;

/**
 * @ClassName: DubbleLinkedListDemo
 * @Description: TODO
 * @author: liuqingqing
 * @Date: 2020/10/12 19:41
 * @Version: 1.0
 */
public class DubbleLinkedListDemo {

    public static void main(String[] args) {
// 测试
        System.out.println("双向链表的测试");
        // 先创建节点
        HeroNode1 hero1 = new HeroNode1(1, "宋江", "及时雨");
        HeroNode1 hero2 = new HeroNode1(2, "卢俊义", "玉麒麟");
        HeroNode1 hero3 = new HeroNode1(3, "吴用", "智多星");
        HeroNode1 hero4 = new HeroNode1(4, "林冲", "豹子头");
        // 创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.add(hero1);
//        doubleLinkedList.add(hero2);
//        doubleLinkedList.add(hero3);
//        doubleLinkedList.add(hero4);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero2);

        doubleLinkedList.list();

        // 修改
        HeroNode1 newHeroNode = new HeroNode1(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();

        // 删除
        doubleLinkedList.delete(3);
        System.out.println("删除后的链表情况~~");
        doubleLinkedList.list();

    }


}
/**
 * 定义SingleLinkedList管理我们的英雄
 **/
class DoubleLinkedList{

    //先初始化一个头节点,头节点不要动，不存放数据
    private HeroNode1 head;

    public DoubleLinkedList() {
        head = new HeroNode1(0,"","");
    }

    public HeroNode1 getHead() {
        return head;
    }

    //添加数据
    //当不考虑编号顺序时
    //1.找到当前链表的最后节点
    //2.见最后这个节点的next指向新的节点
    public void add(HeroNode1 heroNode){
        //因为head节点不能动，因此我们需要一个辅助变量temp
        HeroNode1 temp = head;
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
        heroNode.pre = temp;
    }

    //显示链表
    public void list(){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此需要一个辅助变量来遍历
        HeroNode1 temp = head.next;
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
    public void addByOrder(HeroNode1 heroNode){
        //因为头节点不能动，因此我们仍然通过辅助指针来帮助找到添加的位置
        //因为单链表，因为我们找的temp是位于添加位置的前一个节点，否则加入不了
        HeroNode1 temp = head;
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
            HeroNode1 next = temp.next;
            temp.next = heroNode;
            heroNode.pre = temp;
            heroNode.next = next;
            if (next != null){
                next.pre = heroNode;
            }
        }else if (temp.next.no == heroNode.no){
            System.out.println("英雄编号重复");
        }
    }
    //根据no编号修改节点信息
    public void update(HeroNode1 newHeroNode){
        //判断链表为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode1 temp = head.next;
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
        HeroNode1 temp = head.next;
        if (temp == null){
            System.out.println("链表为空");
            return;
        }
        boolean flag;
        while (true){
            if (temp.no == index){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.pre.next = temp.next;
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.println("没有找到要删除的节点");
        }
    }

    /**
     * 获取链表指定位置的值
     */
    public HeroNode1 get(int index){
        HeroNode1 temp = head;
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
    public static int getLength(HeroNode1 head){
        int length = 0;
        HeroNode1 cur = head.next;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }

    /**
     * 查询链表第k个节点
     */
    public static HeroNode1 findLastIndexNode(HeroNode1 head,int index){
        int length = getLength(head);
        if (index <= 0 || length < index){
            return null;
        }
        HeroNode1 cur = head.next;
        for (int i = 0; i < length -index ; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 单链表反转
     */
    public static void reverseList(HeroNode1 head){

        if (head.next == null || head.next.next == null){
            return;
        }

        HeroNode1 next;
        HeroNode1 reverseHead = new HeroNode1(0,"","");
        HeroNode1 cur = head.next;
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
    public static void reversePrint(HeroNode1 head){

        if (head .next == null){
            System.out.println("链表为空");
            return;
        }
        Stack<HeroNode1> stack = new Stack<>();
        HeroNode1 cur = head.next;
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
class HeroNode1{

    public int no;
    public String name;
    public String nickname;
    public HeroNode1 next;//指向下一个节点
    public HeroNode1 pre;//指向上一个节点

    public HeroNode1(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode1{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname +"'}";
    }
}