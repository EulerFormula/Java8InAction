package algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序--稳定、时间O(NlgN)
 */
public class MergeSort {


    public static int[] mergeSort(int[] data, int[] copy) {

        int len = 1;
        while (len < data.length) {
            mergePass(data, copy, len);
            len *= 2;
            mergePass(copy, data, len);
            len *= 2;
        }
        return copy;
    }

    /**
     * 一趟归并排序
     *
     * @param data
     * @param copy
     * @param len
     */
    private static void mergePass(int[] data, int[] copy, int len) {
        int i;
        for (i = 0; i + 2 * len - 1 < data.length; i += 2 * len) {
            merge(data, copy, i, i + len - 1, i + 2 * len - 1);
        }
        //尚有两个文件，其中最后一个长度小于n
        if (i + len - 1 < data.length - 1) {
            merge(data, copy, i, i + len - 1, data.length - 1);
        } else {
            //文件个数为奇数，最后一个子文件复制到copy中
            for (int j = i; j < data.length; j++) {
                copy[j] = data[j];
            }
        }
    }

    /**
     * 一次归并
     * 对有序的data[low..m]和data[m+1...high]归并为有序的copy[low...high]
     *
     * @param data
     * @param copy
     * @param low
     * @param m
     * @param high
     */
    private static void merge(int[] data, int[] copy, int low, int m, int high) {
        int i = low;
        int j = m + 1;
        int k = low;
        while (i <= m && j <= high) {
            if (data[i] <= data[j]) {
                copy[k++] = data[i++];
            } else {
                copy[k++] = data[j++];
            }

        }
        //将data[low..m]中剩余的元素复制到copy中
        while (i <= m) {
            copy[k++] = data[i++];
        }
        //将data[m+1..high]中剩余的元素复制到copy中
        while (j <= high) {
            copy[k++] = data[j++];
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{72, 18, 53, 36, 48, 31, 36};
        int[] copy = new int[7];
        System.out.println("=====排序前=====");
        Arrays.stream(data).forEach(e -> System.out.printf("%3d", e));
        System.out.println();
        mergeSort(data, copy);
        System.out.println("=====排序后=====");
        Arrays.stream(copy).forEach(e -> System.out.printf("%3d", e));

    }
}
