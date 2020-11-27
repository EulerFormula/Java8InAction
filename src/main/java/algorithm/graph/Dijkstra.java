package algorithm.graph;

import algorithm.graph.prim.Graph;

import javax.print.DocFlavor;
import java.util.Arrays;

/**
 * 单源最短路径之迪杰斯特拉算法
 */
public class Dijkstra {

    private int distance[];
    private int path[];
    private boolean s[];

    public int[] getDistance() {
        return distance;
    }

    public void setDistance(int[] distance) {
        this.distance = distance;
    }

    public int[] getPath() {
        return path;
    }

    public void setPath(int[] path) {
        this.path = path;
    }

    public boolean[] getS() {
        return s;
    }

    public void setS(boolean[] s) {
        this.s = s;
    }


    public void dijkstra(Graph<String> graph, int v) {
        int[][] arcs = graph.getArc();

        //初始化s distance path
        for (int i = 1; i < 5; i++) {
            s[i] = false;
            distance[i] = arcs[v][i];
            if (distance[i] < Integer.MAX_VALUE) {
                path[i] = v;
            } else {
                path[i] = -1;
            }
        }

        distance[v] = Integer.MAX_VALUE;
        s[v] = true;
        int min = 0;
        for (int i = 1; i < 5; i++) {

            min = Integer.MAX_VALUE;

            for (int j = 0; j < 5; j++) {
                if (!s[j] && distance[j] < min) {
                    //j顶点离v更近
                    v = j;
                    min = distance[j];
                }
            }

            s[v] = true;

            for (int j = 0; j < 5; j++) {
                //更改当前最短路径及距离
                if (!s[j] && (distance[v] + arcs[v][j] < distance[j])) {
                    distance[j] = distance[v] + arcs[v][j];
                    path[j] = v;
                }
            }
        }

    }

    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        graph.setVertexNum(5);
        graph.setArcNum(5);

        int arc[][] = new int[5][5];

        arc[0][0] = Integer.MAX_VALUE-100;
        arc[0][1] = 10;
        arc[1][0] = Integer.MAX_VALUE-100;
        arc[0][2] = 3;
        arc[2][0] = Integer.MAX_VALUE-100;
        arc[0][3] = 20;
        arc[3][0] = Integer.MAX_VALUE-100;
        arc[0][4] = Integer.MAX_VALUE-100;
        arc[4][0] = Integer.MAX_VALUE-100;

        arc[1][1] = Integer.MAX_VALUE-100;
        arc[1][2] = Integer.MAX_VALUE-100;
        arc[2][1] = 2;
        arc[1][3] = 5;
        arc[3][1] = Integer.MAX_VALUE-100;
        arc[1][4] = Integer.MAX_VALUE-100;
        arc[4][1] = Integer.MAX_VALUE-100;

        arc[2][2] = Integer.MAX_VALUE-100;
        arc[2][3] = Integer.MAX_VALUE-100;
        arc[3][2] = Integer.MAX_VALUE-100;
        arc[2][4] = 15;
        arc[4][2] = Integer.MAX_VALUE-100;

        arc[3][3] = Integer.MAX_VALUE-100;
        arc[3][4] = 9;
        arc[4][3] = Integer.MAX_VALUE-100;

        arc[4][4] = Integer.MAX_VALUE-100;

        graph.setArc(arc);

        String vertex[] = new String[5];

        for (int i = 0; i < 5; i++) {
            vertex[i] = "顶点" + i;
        }
        graph.setVertex(vertex);

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.setDistance(new int[5]);
        dijkstra.setPath(new int[5]);
        dijkstra.setS(new boolean[5]);

        dijkstra.dijkstra(graph, 0);

        int[] d = dijkstra.getDistance();

        Arrays.stream(d).forEach(e -> System.out.printf("%20d", e));
    }
}
