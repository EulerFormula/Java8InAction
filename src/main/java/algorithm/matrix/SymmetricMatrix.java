package algorithm.matrix;

/**
 * 对称阵的压缩存储
 * 对称阵为n*n方阵
 * 将二维矩阵变为一维数组存储，一维数组长度为n*(n+1)/2
 * k为一维数组的下标，i为行的下标，j为列的下标
 * 如果i>=j,k=i*(i+1)/2+j，如果i<j，k=j*(j+1)/2+i;
 */
public class SymmetricMatrix {

    public static void matrixmult(int[] a, int[] b) {

        int[][] c = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                int sum = 0;

                int aIndex = 0;
                int bIndex = 0;

                //c[i][j]a第i行和b第j列对应积之和
                for (int k = 0; k < 3; k++) {

                    if (i >= k) {
                        aIndex = i * (i + 1) / 2 + k;
                    } else {
                        aIndex = k * (k + 1) / 2 + i;
                    }

                    if (k >= j) {
                        bIndex = k * (k + 1) / 2 + j;
                    } else {
                        bIndex = j * (j + 1) / 2 + k;
                    }

                    sum += a[aIndex] * b[bIndex];
                }

                c[i][j] = sum;
            }
        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%3d", c[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3}, {2, 4, 6}, {3, 6, 5}};


        System.out.println("=====a矩阵=====");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.printf("%3d", a[i][j]);
            }
            System.out.println();
        }

        //a的压缩存储
        int[] a1 = new int[6];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <= i; j++) {
                int index = i * (i + 1) / 2 + j;
                a1[index] = a[i][j];
            }
        }

        System.out.println("=====a矩阵的压缩存储为=====");
        for (int i = 0; i < a1.length; i++) {
            System.out.printf("%3d", a1[i]);
        }
        System.out.println();

        int[][] b = new int[][]{{7, 8, 9}, {8, 4, 5}, {9, 5, 3}};


        System.out.println("=====b矩阵=====");
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.printf("%3d", b[i][j]);
            }
            System.out.println();
        }

        System.out.println();
        //b的压缩存储
        int[] b1 = new int[6];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j <= i; j++) {
                int index = i * (i + 1) / 2 + j;
                b1[index] = b[i][j];
            }
        }

        System.out.println("=====b矩阵的压缩存储为=====");
        for (int i = 0; i < b1.length; i++) {
            System.out.printf("%3d", b1[i]);
        }

        System.out.println();
        System.out.println("=====a*b=====");

        matrixmult(a1,b1);
    }
}
