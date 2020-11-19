package algorithm.tree.binarytree;

/**
 * 二叉树结点
 */
public class BinTNode {
        private Character data;
        private BinTNode lchild;
        private BinTNode rchild;

    public Character getData() {
        return data;
    }

    public void setData(Character data) {
        this.data = data;
    }

    public BinTNode getLchild() {
        return lchild;
    }

    public void setLchild(BinTNode lchild) {
        this.lchild = lchild;
    }

    public BinTNode getRchild() {
        return rchild;
    }

    public void setRchild(BinTNode rchild) {
        this.rchild = rchild;
    }
}
