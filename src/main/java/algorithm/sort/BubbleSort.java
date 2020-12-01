package algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序-稳定排序、O(n^2)
 */
public class BubbleSort {

    public static void bubbleSort(int[] data) {

        boolean flag = false;

        //n-1趟
        for (int i = 0; i < data.length - 1; i++) {

            for (int j = data.length - 1; j >= i + 1; j--) {
                if (data[j] < data[j - 1]) {
                    int tmp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = tmp;
                    flag = true;

                }
            }

            //无交换则退出
            if (!flag) {
                return;
            }

        }
    }

    public static void main(String[] args) {

        int[] data = new int[]{36, 28, 45, 13, 67, 36, 18, 56};
        System.out.println("=====排序前=====");
        Arrays.stream(data).forEach(e-> System.out.printf("%3d",e));
        System.out.println();
        bubbleSort(data);
        System.out.println("=====排序后=====");
        Arrays.stream(data).forEach(e-> System.out.printf("%3d",e));

    }
}
