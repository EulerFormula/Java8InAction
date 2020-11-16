package algorithm.queue;

/**
 * 顺序循环队列
 * 普通的顺序队列会造成空间的浪费，一般情况下真正实用的顺序队列是循环队列
 */
public class CirQueue {

    private char[] data;

    private int front, rear;

    public CirQueue() {
        this.data = new char[100];
    }

    public void display(String msg){
        System.out.println("====="+msg+"=====");
        for(int i=front;i<=rear;i++){
            System.out.printf("%3c",data[i]);
        }
        System.out.println();
    }

    /**
     * 置空队列
     */
    public void init() {
        this.front = this.rear = 0;
    }

    /**
     * 判队空
     */
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    /**
     * 判队满
     */
    public boolean isFull() {
        return (this.rear + 1) % data.length == this.front;
    }


    /**
     * 入队
     */
    public void enQueue(char x) {
        if (isFull()) {
            System.out.println("Queue overflow");
            return;
        } else {
            data[rear] = x;

            //循环意义下的加一
            rear = (rear + 1) % data.length;
        }

    }

    /**
     * 出队
     */
    public Character deQueue() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return null;
        } else {
            char ch = data[front];
            front = (front + 1) % data.length;
            return ch;
        }
    }


    /**
     * 取对头元素
     */
    public Character getFront(){
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return null;
        } else {
            char ch = data[front];
            return ch;
        }
    }

    public static void main(String[] args) {

        CirQueue cirQueue = new CirQueue();
        cirQueue.init();

        cirQueue.enQueue('t');
        cirQueue.enQueue('e');
        cirQueue.enQueue('s');
        cirQueue.enQueue('t');


        cirQueue.display("入队后");

        System.out.println(cirQueue.deQueue());
        System.out.println(cirQueue.deQueue());
        System.out.println(cirQueue.deQueue());
        System.out.println(cirQueue.deQueue());

    }


}
