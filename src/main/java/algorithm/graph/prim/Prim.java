package algorithm.graph.prim;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * prim算法（加点法）
 * @param <T>
 */
public class Prim<T> {


    private Map<Integer, ShortEdge> map = new HashMap<>();

    private Graph<T> graph;

    public Map<Integer, ShortEdge> getMap() {
        return map;
    }

    public void setMap(Map<Integer, ShortEdge> map) {
        this.map = map;
    }

    public Graph<T> getGraph() {
        return graph;
    }

    public void setGraph(Graph<T> graph) {
        this.graph = graph;
    }

    private void initial() {
        int arc[][] = graph.getArc();
        for (int i = 1; i < graph.getVertexNum(); i++) {
            ShortEdge shortEdge = new ShortEdge();
            //开始的时候集合中只有一个顶点0
            shortEdge.setAdjvex(0);
            if (arc[0][i] != 0) {
                shortEdge.setLowCost(arc[0][i]);
            } else {
                shortEdge.setLowCost(Integer.MAX_VALUE);
            }
            map.put(i, shortEdge);
        }
    }


    private int minEdge(Map<Integer, ShortEdge> map) {
        int min = Integer.MAX_VALUE;
        int found = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key).getLowCost() < min) {
                min = map.get(key).getLowCost();
                found = key;
            }
        }
        return found;
    }


    public Map<Integer, ShortEdge> prim() {
        initial();
        int[][] arc = graph.getArc();
        Map<Integer, ShortEdge> resultMap = new LinkedHashMap<>();
        while (map.size() > 0) {
            int k = minEdge(map);
            resultMap.put(k, map.get(k));
            map.remove(k);
            if (map.size() == 0) {
                break;
            }

            for (int key : map.keySet()) {
                if (arc[k][key] < map.get(key).getLowCost()) {
                     map.get(key).setLowCost(arc[k][key]);
                     map.get(key).setAdjvex(k);
                }
            }
        }

        return resultMap;
    }
}
