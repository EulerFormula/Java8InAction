package algorithm.queue;

/**
 * 循环链队列
 */
public class CirLinkQueue {

    QueueNode rear;

    public void display(String msg) {
        System.out.println("=====" + msg + "=====");
        QueueNode p = rear.getNext().getNext();
        while (p != rear.getNext()) {
            System.out.printf("%3c", p.getData());
            p = p.getNext();
            if (p != rear) {
                System.out.print("->");
            }
        }

        System.out.println();
    }

    public void init() {
        QueueNode queueNode = new QueueNode();
        rear = queueNode;
        rear.setNext(queueNode);
    }

    public void enQueue(Character x) {
        QueueNode queueNode = new QueueNode();
        queueNode.setData(x);
        queueNode.setNext(this.rear.getNext());
        rear.setNext(queueNode);
        rear = queueNode;
    }

    public Character deQueue() {
        if (rear.getNext() == null) {
            System.out.println("Queue Empty");
            return null;
        } else {
            QueueNode h = rear.getNext();
            rear.setNext(h.getNext());
            QueueNode r = h.getNext();
            h = null;
            return r.getData();
        }
    }

    public static void main(String[] args) {
        CirLinkQueue cirLinkQueue = new CirLinkQueue();
        cirLinkQueue.init();

        cirLinkQueue.enQueue('t');
        cirLinkQueue.enQueue('e');
        cirLinkQueue.enQueue('s');
        cirLinkQueue.enQueue('t');

        cirLinkQueue.display("入队后");

        System.out.println("开始出队");

        System.out.println(cirLinkQueue.deQueue());
        System.out.println(cirLinkQueue.deQueue());
        System.out.println(cirLinkQueue.deQueue());
        System.out.println(cirLinkQueue.deQueue());
    }
}
