package algorithm.graph;

import algorithm.queue.CirQueue;
import algorithm.stack.SeqStack;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 无向图邻接表存储
 */
public class ALGraph {

    private VNode[] vNodes;

    private int[] visited = new int[3];

    public ALGraph() {
        vNodes = new VNode[]{new VNode(), new VNode(), new VNode()};
    }

    public VNode[] getvNodes() {
        return vNodes;
    }

    public void setvNodes(VNode[] vNodes) {
        this.vNodes = vNodes;
    }

    public void clearVisited() {
        visited = new int[3];
    }

    public static ALGraph createGraph() {
        ALGraph graph = new ALGraph();

        Scanner scanner = new Scanner(System.in);
        VNode[] vNodes = graph.getvNodes();
        for (int i = 0; i < 3; i++) {
            System.out.print("请输入顶点信息，以空格隔开：");
            vNodes[i].setVertex(scanner.next().charAt(0));
            vNodes[i].setLink(null);
        }

        for (int k = 0; k < 3; k++) {
            System.out.print("请输入边的顶点序号，以空格隔开：");
            //读入边(vi,vj)的顶点序号
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            EdgeNode edgeNode = new EdgeNode();

            //将邻接点序号j赋给新结点的邻接点域
            edgeNode.setAdjvex(j);
            //将新结点插入到顶点vi的边表头部
            edgeNode.setNext(vNodes[i].getLink());
            vNodes[i].setLink(edgeNode);

            //有向图注释掉下面的代码
            edgeNode = new EdgeNode();
            edgeNode.setAdjvex(i);
            edgeNode.setNext(vNodes[j].getLink());
            vNodes[j].setLink(edgeNode);

        }
        return graph;
    }

    /**
     * 深度优先搜索遍历算法
     * 从顶点vi出发，深度优先搜索遍历图G（邻接表结构）
     *
     * @param i
     */
    public void DFS(int i) {
        System.out.printf("v%d ", i);
        visited[i] = 1;
        //取vi邻接表的表头指针
        EdgeNode edgeNode = vNodes[i].getLink();
        while (edgeNode != null) {
            //依次搜索vi的每个邻接点
            int j = edgeNode.getAdjvex();
            if (visited[j] == 0) {
                DFS(j);
            }
            //edgeNode指向vi的下一个邻接点
            edgeNode = edgeNode.getNext();
        }
    }

    /**
     * 深度优先遍历（非递归）
     *
     * @param i
     */
    public void DFS2(int i) {
        SeqStack<EdgeNode> seqStack = new SeqStack<>();
        seqStack.init();
        System.out.printf("v%d ", i);
        visited[i] = 1;
        EdgeNode edgeNode = vNodes[i].getLink();
        while (!seqStack.isEmpty() || edgeNode != null) {
            while (edgeNode != null) {
                if (visited[edgeNode.getAdjvex()] == 1) {
                    edgeNode = edgeNode.getNext();
                } else {
                    System.out.printf("v%d ", edgeNode.getAdjvex());
                    visited[edgeNode.getAdjvex()] = 1;
                    seqStack.push(edgeNode);
                    edgeNode = vNodes[edgeNode.getAdjvex()].getLink();
                }
            }

            if (!seqStack.isEmpty()) {
                edgeNode = seqStack.pop();
                edgeNode = edgeNode.getNext();
            }
        }
    }

    /**
     * 广度优先搜索遍历算法
     *
     * @param i
     */
    public void BFS(int i) {
        CirQueue<Integer> queue = new CirQueue<>();
        queue.init();

        System.out.printf("v%d ", i);
        visited[i] = 1;

        queue.enQueue(i);

        int k = 0;
        int j = 0;
        EdgeNode edgeNode = null;
        while (!queue.isEmpty()) {
            k = queue.deQueue();
            edgeNode = vNodes[k].getLink();

            while (edgeNode != null) {
                j = edgeNode.getAdjvex();
                if (visited[j] == 0) {
                    System.out.printf("v%d ", j);
                    visited[j] = 1;
                    queue.enQueue(j);
                }

                edgeNode = edgeNode.getNext();
            }


        }
    }

    public static void main(String[] args) {
        ALGraph alGraph = ALGraph.createGraph();

        VNode[] vNodes = alGraph.getvNodes();
        Arrays.stream(vNodes).forEach(ALGraph::printGraph);

        System.out.println("=====邻接表的深度优先遍历=====");

        alGraph.DFS(0);
        System.out.println();
        System.out.println("=====邻接表的广度优先遍历=====");
        alGraph.clearVisited();
        alGraph.BFS(0);
        System.out.println();
        System.out.println("=====邻接表的深度优先遍历（非递归）=====");
        alGraph.clearVisited();
        alGraph.DFS2(0);


    }


    private static void printGraph(VNode e) {
        char vertex = e.getVertex();
        EdgeNode edgeNode = e.getLink();
        System.out.print("顶点" + vertex + "的邻接点序号为：");
        System.out.printf("%3d", edgeNode.getAdjvex());
        while (edgeNode.getNext() != null) {
            edgeNode = edgeNode.getNext();
            System.out.printf("%3d", edgeNode.getAdjvex());
        }
        System.out.println();

    }
}
