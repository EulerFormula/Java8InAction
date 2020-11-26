package algorithm.graph;

/**
 * 边表节点
 */
public class EdgeNode {

    /**
     * 顶点的序号
     */
    private int adjvex;

    /**
     * 指向下一条边的指针
     */
    private EdgeNode next;

    public int getAdjvex() {
        return adjvex;
    }

    public void setAdjvex(int adjvex) {
        this.adjvex = adjvex;
    }

    public EdgeNode getNext() {
        return next;
    }

    public void setNext(EdgeNode next) {
        this.next = next;
    }
}
