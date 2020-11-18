package algorithm.matrix;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 稀疏矩阵
 */
public class TSMatrix {

    /**
     * 存储三元组的数组
     */
    private TriTupleNode[] data;

    /**
     * 矩阵的行数、列数和非零元素个数
     */
    private int m;
    private int n;
    private int t;


    public TSMatrix() {
        this.data = new TriTupleNode[100];
    }

    public TriTupleNode[] getData() {
        return data;
    }

    public void setData(TriTupleNode[] data) {
        this.data = data;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }


    /**
     * 将稀疏矩阵a的存储方式由二维数组改为三元组表
     */
    public static TSMatrix createTriTable(int[][] a) {
        TSMatrix tsMatrix = new TSMatrix();
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {

                //找出非零元素
                if (a[i][j] != 0) {
                    TriTupleNode node = new TriTupleNode();
                    //记录非零元素行下标
                    node.setJ(i);
                    //记录非零元素列下标
                    node.setJ(j);
                    //保存非零值
                    node.setV(a[i][j]);
                    tsMatrix.getData()[k] = node;
                    //统计非零元素个数
                    k++;
                }
            }
        }

        //记录矩阵行列数
        tsMatrix.setM(a.length);
        tsMatrix.setN(a[0].length);
        //保存非零个数
        tsMatrix.setT(k);

        return tsMatrix;
    }

    /**
     * 稀疏矩阵的转置
     * 对矩阵a中的每一列col(0<=col<=a.n-1)从头至尾依次扫描三元组表，找出
     * 所有列号等于col的那些三元组，并将它们的行号和列号互换后再依次存入b.data中
     * 这样就可以得到b的按行优先的三元组表
     */
    public static TSMatrix transMatrix(TSMatrix a) {
        TSMatrix b = new TSMatrix();

        //M和T行列数互换
        b.setM(a.getN());
        b.setN(a.getM());
        b.setT(a.getT());

        if (b.getT() <= 0) {
            System.out.println("a中无非零元素");
            return null;
        } else {
            int q = 0;
            for (int col = 0; col < a.getN(); col++) {
                for (int p = 0; p < a.getT(); p++) {
                    if (a.getData()[p].getJ() == col) {
                        TriTupleNode node = new TriTupleNode();
                        node.setI(a.getData()[p].getJ());
                        node.setJ(a.getData()[p].getI());
                        node.setV(a.getData()[p].getV());
                        b.getData()[q] = node;
                        q++;
                    }
                }
            }
            return b;
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 0, 0, 2}, {0, 4, 0, 0}};

        System.out.println("=====矩阵a=====");
        Arrays.stream(a).forEach(one -> {
            Arrays.stream(one).forEach(i -> System.out.printf("%3d", i));
            System.out.println();
        });

        TSMatrix tsMatrix = TSMatrix.createTriTable(a);

        System.out.println("====稀疏矩阵=====");
        Arrays.stream(tsMatrix.getData()).filter(node -> node != null).
                forEach(node -> System.out.printf("%3d", node.getV()));


        TSMatrix b = TSMatrix.transMatrix(tsMatrix);

        System.out.println();
        System.out.println("=====稀疏矩阵转置矩阵====");
        Arrays.stream(b.getData()).filter(node -> node != null).forEach(
                node -> System.out.printf("%3d", node.getV())
        );


    }
}
