package algorithm.graph.prim;

import java.util.Map;

public class PrimTest {

    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        graph.setVertexNum(4);
        graph.setArcNum(5);

        int arc[][] = new int[5][5];

        arc[0][1] = 19;
        arc[1][0] = 19;
        arc[1][2] = 25;
        arc[2][1] = 25;
        arc[1][3] = 25;
        arc[3][1] = 25;
        arc[2][3] = 17;
        arc[3][2] = 17;
        arc[2][0] = 46;
        arc[0][2] = 46;
        graph.setArc(arc);

        String vertex[] = new String[4];

        for (int i = 0; i < 4; i++) {
            vertex[i] = "顶点" + i;
        }
        graph.setVertex(vertex);

        Prim<String> prim = new Prim<>();
        prim.setGraph(graph);
        Map<Integer, ShortEdge> resultMap = prim.prim();


        resultMap.forEach((k,v)->{
            System.out.printf("边为%d-%d,权值为:%d%n", k, resultMap.get(k).getAdjvex(), resultMap.get(k).getLowCost());
        });
    }

}
