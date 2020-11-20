package algorithm.tree.binarytree;

/**
 * 线索二叉树结点
 */
public class BinThrNode<T> {

    private T data;

    /**
     * ltag为0，lchild指向结点的左孩子
     * ltag为1，lchild指向结点的前趋
     */
    private int ltag;
    /**
     * rtag为0，rchild指向结点的右孩子
     * rtag为1，rchild指向结点的后继
     */
    private int rtag;
    private BinThrNode lchild;
    private BinThrNode rchild;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getLtag() {
        return ltag;
    }

    public void setLtag(int ltag) {
        this.ltag = ltag;
    }

    public int getRtag() {
        return rtag;
    }

    public void setRtag(int rtag) {
        this.rtag = rtag;
    }

    public BinThrNode getLchild() {
        return lchild;
    }

    public void setLchild(BinThrNode lchild) {
        this.lchild = lchild;
    }

    public BinThrNode getRchild() {
        return rchild;
    }

    public void setRchild(BinThrNode rchild) {
        this.rchild = rchild;
    }
}
