package algorithm.graph;

import algorithm.stack.SeqStack;

/**
 * 拓扑排序
 * 1.在有向图中选一个没有前趋（入度为零）的顶点，且输出之。
 * 2.从有向图中删除该顶点及其与该顶点有关的所有边。
 * 3.重复执行上述两个步骤，直到全部顶点都已输出或者图中剩余的顶点中没有前趋（入度为零）顶点为止
 * 4.输出剩余的无前趋结点
 */
public class TopuSort {


    static void topuSort(ALGraph graph) {
        //m用来统计输出的顶点数
        int m = 0;

        //定义入队数组
        int inde[] = new int[]{0, 0, 0};

        //扫描每个顶点的出边表，统计每个顶点的入度数
        for (int i = 0; i < 3; i++) {
            EdgeNode p = graph.getvNodes()[i].getLink();
            while (p != null) {
                inde[p.getAdjvex()]++;
                p = p.getNext();
            }
        }


        //初始化栈，并将入度为零的顶点i入栈
        SeqStack<Integer> seqStack = new SeqStack<>();
        seqStack.init();
        for (int i = 0; i < 3; i++) {
            if (inde[i] == 0) {
                seqStack.push(i);
            }
        }

        while (!seqStack.isEmpty()) {
            int i = seqStack.pop();
            System.out.printf("V%d ", i);
            m++;
            EdgeNode p = graph.getvNodes()[i].getLink();
            //扫描顶点i的出边表
            while (p != null) {
                int j = p.getAdjvex();
                //vj的入度减1，相当于删除边<vi,vj>
                inde[j]--;
                //若vj的入度为0，则入栈
                if (inde[j] == 0) {
                    seqStack.push(j);
                }
                p = p.getNext();
            }
        }

        if (m < 2) {
            System.out.println("图有回路");
        }
    }

    public static void main(String[] args) {

        ALGraph graph = ALGraph.createGraph();
        TopuSort.topuSort(graph);

    }
}
