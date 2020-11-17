package algorithm.matrix;

/**
 * 矩阵转置
 */
public class Transposition {

    static int[][] trsmat(int[][] a) {

        int[][] b = new int[a[0].length][a.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                b[j][i] = a[i][j];
            }
        }
        return b;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{4,5,6},{7,8,9}};

        System.out.println("=====转置前=====");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.printf("%3d", a[i][j]);
            }
            System.out.println();
        }

        int[][] b = trsmat(a);

        System.out.println("=====转置后=====");
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.printf("%3d", b[i][j]);
            }
            System.out.println();
        }

    }
}
