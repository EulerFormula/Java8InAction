package algorithm.matrix;

/**
 * 稀疏矩阵结点
 */
public class TriTupleNode {


    /**
     * 非零元素的行号、列号（下标）
     */
    private int i,j;
    /**
     * 非零元素值
     */
    private int v;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }
}
