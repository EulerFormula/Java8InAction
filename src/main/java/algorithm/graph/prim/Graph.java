package algorithm.graph.prim;

public class Graph<T> {

    //顶点数
    private int vertexNum;

    //存放顶点信息的数组
    private T[] vertex;

    //存放边数
    private int arcNum;

    //存放边关系和边的权值
    private int[][] arc;


    public int getVertexNum() {
        return vertexNum;
    }

    public void setVertexNum(int vertexNum) {
        this.vertexNum = vertexNum;
    }

    public T[] getVertex() {
        return vertex;
    }

    public void setVertex(T[] vertex) {
        this.vertex = vertex;
    }

    public int getArcNum() {
        return arcNum;
    }

    public void setArcNum(int arcNum) {
        this.arcNum = arcNum;
    }

    public int[][] getArc() {
        return arc;
    }

    public void setArc(int[][] arc) {
        this.arc = arc;
    }
}
