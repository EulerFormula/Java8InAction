package algorithm.stack;

/**
 * 栈结点
 */
public class StackNode {

    private char data;
    private StackNode next;

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }
}
