package algorithm.linearlist;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;

public class LinkList {

    ListNode head;

    ListNode rear;


    public LinkList() {

        this.head = null;
        this.rear = null;
    }

    public void display(String msg) {

        System.out.println("=====" + msg + "=====");

        ListNode temp = head;
        while (temp != null) {
            System.out.print(String.format("%c", temp.getData()));
            temp = temp.getNext();

            if (temp != null) {
                System.out.print("->");
            }
        }

        System.out.println();

    }

    /**
     * 头插法建表
     */
    void createFront() {
        System.out.print("请输入初始化字符串：");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        for (int i = 0; i < input.length(); i++) {
            ListNode listNode = new ListNode();
            listNode.setData(input.charAt(i));
            listNode.setNext(head);
            head = listNode;
        }
    }

    /**
     * 尾插法建表
     */
    void createRear() {

        System.out.print("请输入初始化字符串：");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        for (int i = 0; i < input.length(); i++) {
            ListNode listNode = new ListNode();
            listNode.setData(input.charAt(i));
            if (head == null) {
                head = listNode;
            } else {
                rear.setNext(listNode);
            }

            rear = listNode;
        }

        if (rear != null) {
            rear.setNext(null);
        }

    }


    /**
     * 带头结点的尾插法
     */
    void createRear1(){
        head = new ListNode();
        head.setData('h');
        System.out.print("请输入初始化字符串：");

        rear = head;

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        for(int i=0;i<input.length();i++){
            ListNode listNode = new ListNode();
            listNode.setData(input.charAt(i));
            rear.setNext(listNode);
            rear = listNode;
        }
        rear.setNext(null);
    }

    /**
     * 按节点序号查找
     * 若查找成功，则返回查找节点，否则返回null
     */
    public ListNode getNodei(int i) {
        ListNode p = head;
        int j = 1;

        //顺指针向后查找，直到p指向第i个节点或p为空为止
        while (p != null && j < i) {
            p = p.getNext();
            j++;
        }

        if (j == i) {
            return p;
        } else {
            return null;
        }
    }

    /**
     * 按结点值查找
     * 若查找成功，则返回查找节点，否则返回null
     */
    public ListNode locaeNodek(char k) {
        ListNode p = head;

        while (p != null && p.getData() != k) {
            p = p.getNext();
        }

        return p;
    }


    /**
     * 插入运算
     *
     * @param i 插入位置
     * @param x 插入的值
     */
    public void insert(int i, char x) {
        ListNode p = head;
        int j = 1;

        //使p指向第i-1个结点
        while (p != null && j < i - 1) {
            p = p.getNext();
            j++;
        }

        if (p == null) {
            System.out.println("ERROR");
            return;
        } else {
            //申请新结点
            ListNode listNode = new ListNode();
            listNode.setData(x);
            listNode.setNext(p.getNext());

            p.setNext(listNode);
        }

    }

    /**
     * 删除
     */
    public Character delete(int i) {
        ListNode p = head;
        ListNode s = null;
        Character x = null;
        int j = 1;

        //使p指向第i-1个结点
        while (p != null && j < i-1) {
            p = p.getNext();
            j++;
        }

        if (p == null) {
            System.out.println("位置错误");
            return null;
        } else {

            //s指向第i个结点
            s = p.getNext();
            //使p.next 指向第i+1个结点
            p.setNext(s.getNext());
            //保存被删除结点的值
            x = s.getData();
            //删除第i个结点，返回结点值
            s = null;
            return x;
        }
    }



    public static void main(String[] args) {

        LinkList linkList = new LinkList();

        linkList.display("头插法初始化前");
        linkList.createFront();
        linkList.display("头插法初始化后");


        linkList = new LinkList();

        linkList.display("尾插法初始化前");
        linkList.createRear();
        linkList.display("尾插法初始化后");


        System.out.println("序号查找，第一个结点的值为：" + linkList.getNodei(1).getData());
        System.out.println("结点值查找，第一个结点的值为：" + linkList.locaeNodek('t').getData());

        linkList.display("插入s前");
        linkList.insert(5, 's');
        linkList.display("插入s后");


        linkList.display("删除s前");
        linkList.delete(5);
        linkList.display("删除s后");


        linkList = new LinkList();
        linkList.display("带头结点尾插法初始化前");
        linkList.createRear1();
        linkList.display("带头结点尾插法初始化后");

    }
}
