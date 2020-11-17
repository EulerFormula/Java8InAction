package algorithm.matrix;

/**
 * A[i][j]是第i行中最小值，又是第j列中最大值，则称此元素为该矩阵的一个马鞍点
 */
public class MinMaxPoint {

    static void minMax(int[][] a) {
        int min[] = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            min[i] = a[i][0];
            for (int j = 1; j < a[i].length; j++) {
                if (a[i][j] < min[i]) {
                    min[i] = a[i][j];
                }
            }
        }

        int max[] = new int[a[0].length];
        for (int i = 0; i < a[0].length; i++) {
            max[i] = a[0][i];
            for (int j = 1; j < a.length; j++) {
                if (a[i][j] > max[i]) {
                    max[i] = a[i][j];
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (min[i] == max[j]) {
                    System.out.printf("(%d,%d)", i, j);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{5, 4, 6}, {5, 1, 2}, {4, 0, 3}};

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.printf("%3d", a[i][j]);
            }
            System.out.println();
        }
        System.out.println("=====鞍点为=====");
        minMax(a);
    }
}
