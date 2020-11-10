package algorithm.linearlist;

import java.util.Scanner;

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

    public static void main(String[] args) {

        LinkList linkList = new LinkList();

        linkList.display("头插法初始化前");
        linkList.createFront();
        linkList.display("头插法初始化后");


        linkList = new LinkList();

        linkList.display("尾插法初始化前");
        linkList.createRear();
        linkList.display("尾插法初始化后");


    }
}
