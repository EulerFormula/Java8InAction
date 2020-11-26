package algorithm.graph;

import algorithm.queue.CirQueue;

import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.Scanner;

/**
 * 无向图邻接矩阵存储
 */
public class MGraph {

    /**
     * 顶点数组，类型假定为char型
     */
    private char[] vexs;

    /**
     * 邻接矩阵，假定w为int型
     */
    private int[][] arcs;

    /**
     * 用以标记某个顶点是否被访问过
     */
    private int[] visited;


    public void clearVisited() {
        visited = new int[3];
    }

    public MGraph() {
        vexs = new char[3];
        arcs = new int[3][3];
        visited = new int[3];
    }

    public char[] getVexs() {
        return vexs;
    }

    public void setVexs(char[] vexs) {
        this.vexs = vexs;
    }

    public int[][] getArcs() {
        return arcs;
    }

    public void setArcs(int[][] arcs) {
        this.arcs = arcs;
    }

    /**
     * 建立无向图
     *
     * @return
     */
    public static MGraph createMGraph() {
        MGraph mGraph = new MGraph();
        System.out.print("请输入顶点数和边数，以空格隔开：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt();
        System.out.print("请输入顶点的信息，以空格隔开：");
        char[] vexs = mGraph.getVexs();
        for (int i = 0; i < n; i++) {
            vexs[i] = scanner.next().charAt(0);
        }

        int[][] arcs = mGraph.getArcs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //初始化邻接矩阵元素为无穷大
                arcs[i][j] = 0;
            }
        }

        //读入e条边，建立邻接矩阵
        for (int k = 0; k < e; k++) {
            System.out.print("请输入端点下标和权重，以空格隔开：");
            //读入一条边的两端顶点序号i、j及边上的权w
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            int w = scanner.nextInt();
            arcs[i][j] = w;
            arcs[j][i] = w;
        }
        return mGraph;
    }

    /**
     * 以邻接矩阵为存储结构的深度优先搜索遍历算法
     * 从顶点vi出发，深度优先搜索遍历图G（邻接矩阵结构）
     *
     * @param i
     * @param n
     */
    public void DFS(int i, int n) {
        //假定访问顶点vi以输出该顶点的序号代之
        System.out.printf("v%d ", i);
        //标记vi已被访问过
        visited[i] = 1;
        //依次搜索vi的每个邻接点
        for (int j = 0; j < n; j++) {
            //若(vi,vj)∈E(G)，且vj未被访问过，则从vj开始递归调用
            if (arcs[i][j] != 0 && visited[j] == 0) {
                DFS(j, n);
            }
        }
    }

    /**
     * 广度优先搜索遍历算法
     *
     * @param i
     * @param n
     */
    public void BFS(int i, int n) {
        //定义一个队列
        CirQueue<Integer> queue = new CirQueue<>();
        queue.init();

        System.out.printf("v%d ", i);
        visited[i] = 1;

        //将已访问的顶点序号i入队
        queue.enQueue(i);
        int k = 0;
        while (!queue.isEmpty()) {
            k = queue.deQueue();
            for (int j = 0; j < n; j++) {
                if (arcs[k][j] != 0 && visited[j] == 0) {
                    System.out.printf("v%d ", j);
                    visited[j] = 1;
                    queue.enQueue(j);
                }
            }
        }

    }

    public static void main(String[] args) {

        MGraph mGraph = MGraph.createMGraph();

        System.out.println("图的邻接矩阵如下：");
        int[][] arcs = mGraph.getArcs();
        Arrays.stream(arcs).forEach(r -> {
            Arrays.stream(r).forEach(c -> {
                System.out.printf("%3d", c);
            });
            System.out.println();
        });

        System.out.println("开始深度优先搜索遍历");
        mGraph.DFS(0, 3);

        System.out.println();
        System.out.println("开始广度优先搜索遍历");
        mGraph.clearVisited();
        mGraph.BFS(0, 3);


    }
}
