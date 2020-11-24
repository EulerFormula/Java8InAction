package algorithm.tree;

/**
 * 霍夫曼树的结点
 */
public class HTNode {

    private float weight;
    private int lchild;
    private int rchild;
    private int parent;

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getLchild() {
        return lchild;
    }

    public void setLchild(int lchild) {
        this.lchild = lchild;
    }

    public int getRchild() {
        return rchild;
    }

    public void setRchild(int rchild) {
        this.rchild = rchild;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }
}
