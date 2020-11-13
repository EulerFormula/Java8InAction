package algorithm.queue;

/**
 * 链队列（带头结点）
 */
public class LinkQueue {

    private QueueNode front;
    private QueueNode rear;

    public void display(String msg) {
        System.out.println("=====" + msg + "=====");
        QueueNode p = this.front.getNext();

        while (p != null) {
            System.out.printf("%3c", p.getData());
            p = p.getNext();
            if (p != null) {
                System.out.print("->");
            }

        }

        System.out.println();
    }

    /**
     * 构造空队列
     */
    public void init() {
        QueueNode queueNode = new QueueNode();
        this.front = queueNode;
        this.rear = this.front;
        this.rear.setNext(null);
    }

    /**
     * 判队空
     */
    public boolean isEmpty() {
        return this.rear == this.front;
    }

    /**
     * 入队列
     */
    public void enQueue(Character x) {
        QueueNode queueNode = new QueueNode();
        queueNode.setData(x);
        queueNode.setNext(null);

        this.rear.setNext(queueNode);
        this.rear = queueNode;
    }

    /**
     * 出队列
     * 为了使得长度在长度等于1和长度大于1的情况下处理操作一致
     * 为了使得出队时只修改头指针，删除队列头结点（不是对头结点），使
     * 链队列的队头结点成为新的链队列的头结点
     * 头结点->队头结点->....->队尾结点
     */
    public Character deQueue() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return null;
        } else {
            //p指向头结点
            QueueNode p = this.front;
            //头指针指向原队头结点
            this.front = this.front.getNext();
            p = null;
            return this.front.getData();
        }
    }

    /**
     * 取对头元素
     */
    public Character getFront() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return null;
        } else {
            return this.front.getNext().getData();
        }
    }

    public static void main(String[] args) {
        LinkQueue linkQueue = new LinkQueue();
        linkQueue.init();

        linkQueue.enQueue('t');
        linkQueue.enQueue('e');
        linkQueue.enQueue('s');
        linkQueue.enQueue('t');

        linkQueue.display("入队后");


        System.out.println("====="+"开始出队"+"=====");

        System.out.println(linkQueue.deQueue());
        System.out.println(linkQueue.deQueue());
        System.out.println(linkQueue.deQueue());
        System.out.println(linkQueue.deQueue());

    }

}
