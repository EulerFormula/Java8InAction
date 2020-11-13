package algorithm.queue;

/**
 * 链队列结点
 */
public class QueueNode {
    private Character data;
    private QueueNode next;

    public Character getData() {
        return data;
    }

    public void setData(Character data) {
        this.data = data;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }
}
