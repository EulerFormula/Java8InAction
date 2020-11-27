package algorithm.graph.prim;

public class ShortEdge {

    //到连通树的最小权值
    private int lowCost;

    //使它到连通树的最小权值的那个节点编号
    private int adjvex;


    public int getLowCost() {
        return lowCost;
    }

    public void setLowCost(int lowCost) {
        this.lowCost = lowCost;
    }

    public int getAdjvex() {
        return adjvex;
    }

    public void setAdjvex(int adjvex) {
        this.adjvex = adjvex;
    }
}
