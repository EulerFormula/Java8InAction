package algorithm.matrix;

/**
 * 广义表结点
 */
public class GLNode {
    private NodeTag tag;

    /**
     * 原子结点的值
     */
    private char data;

    /**
     * 指向子表
     */
    private GLNode slink;

    private GLNode next;


    public NodeTag getTag() {
        return tag;
    }

    public void setTag(NodeTag tag) {
        this.tag = tag;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public GLNode getSlink() {
        return slink;
    }

    public void setSlink(GLNode slink) {
        this.slink = slink;
    }

    public GLNode getNext() {
        return next;
    }

    public void setNext(GLNode next) {
        this.next = next;
    }
}
