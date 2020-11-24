package algorithm.tree;

/**
 * 哈夫曼编码结点
 */
public class CodeNode<T> {

    /**
     * 存放编码的字符
     */
    private T data;


    /**
     * 存放编码位串
     */
    private char[] bits = new char[HuffmanTree.N];

    /**
     * 编码长度
     */
    private int len;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public char[] getBits() {
        return bits;
    }

    public void setBits(char[] bits) {
        this.bits = bits;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }
}
