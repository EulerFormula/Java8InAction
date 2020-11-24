package algorithm.tree;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 哈夫曼树
 */
public class HuffmanTree {

    /**
     * 叶子结点总数
     */
    public static final int N = 5;

    /**
     * 哈夫曼树中结点总数
     */
    public static final int M = 2 * N - 1;

    private HTNode[] htNodes;


    public HuffmanTree() {
        this.htNodes = new HTNode[M + 1];
    }


    public HTNode[] getHtNodes() {
        return htNodes;
    }

    public void setHtNodes(HTNode[] htNodes) {
        this.htNodes = htNodes;
    }

    /**
     * 在tree.htNodes[1...k]中选择parent为0且权值最小的两个根节点
     *
     * @param tree
     * @param k
     * @return
     */
    public static int[] select(HuffmanTree tree, int k) {

        int j = 0;
        float min = Float.MAX_VALUE;

        for (int i = 1; i <= k; i++) {
            float weight = tree.htNodes[i].getWeight();
            if (Float.compare(weight, min) < 0 && tree.htNodes[i].getParent() == 0) {
                j = i;
                min = tree.htNodes[i].getWeight();
            }
        }

        int[] result = new int[2];
        result[0] = j;

        min = Float.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            float weight = tree.htNodes[i].getWeight();
            if (Float.compare(weight, min) < 0 && tree.htNodes[i].getParent() == 0 && i != result[0]) {
                j = i;
                min = tree.htNodes[i].getWeight();
            }
        }
        result[1] = j;

        return result;
    }


    /**
     * 创建哈夫曼树
     *
     * @param tree
     */
    public static void ChuffmanTree(HuffmanTree tree) {
        int s1, s2;
        HTNode[] htNodes = tree.htNodes;
        //初始化
        for (int i = 1; i <= M; i++) {
            HTNode htNode = new HTNode();
            htNode.setLchild(0);
            htNode.setRchild(0);
            htNode.setParent(0);
            htNode.setWeight(0);
            htNodes[i] = htNode;
        }

        Scanner scanner = new Scanner(System.in);
        //输入前n个叶结点的权值
        for (int i = 1; i <= N; i++) {
            htNodes[i].setWeight(scanner.nextInt());
        }

        //在HT[1...i-1]中选择parent为0且权值最小的两个根节点
        for (int j = N + 1; j <= M; j++) {
            int[] result = select(tree, j - 1);
            s1 = result[0];
            s2 = result[1];
            htNodes[s1].setParent(j);
            htNodes[s2].setParent(j);
            htNodes[j].setLchild(s1);
            htNodes[j].setRchild(s2);
            //权值之和
            htNodes[j].setWeight(htNodes[s1].getWeight() + htNodes[s2].getWeight());
        }
    }

    public static void main(String[] args) {
        HuffmanTree tree = new HuffmanTree();

        HuffmanTree.ChuffmanTree(tree);

        System.out.println("=====哈夫曼树为=====");
        Arrays.stream(tree.htNodes).filter(e -> e != null).forEach(e -> System.out.printf("%10f", e.getWeight()));

        HuffmanCode code = new HuffmanCode();

        HuffmanCode.huffmanEncoding(tree,code);

        System.out.println("=====哈夫曼编码为=====");
        Arrays.stream(code.getCodeNodes()).forEach(e-> System.out.println(new String(e.getBits())));
    }


}
