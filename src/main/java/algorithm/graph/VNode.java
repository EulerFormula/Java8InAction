package algorithm.graph;

/**
 * 顶点表结点
 */
public class VNode {
    private char vertex;

    /**
     * 边表头指针
     */
    private EdgeNode link;


    public char getVertex() {
        return vertex;
    }

    public void setVertex(char vertex) {
        this.vertex = vertex;
    }

    public EdgeNode getLink() {
        return link;
    }

    public void setLink(EdgeNode link) {
        this.link = link;
    }
}
