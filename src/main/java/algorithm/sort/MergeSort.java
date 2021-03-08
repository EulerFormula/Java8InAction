package algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序--稳定、时间O(NlgN)
 */
public class MergeSort {

    public static void mergeSort(int[] data, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(data, low, mid);
            mergeSort(data, mid + 1, high);
            merge(data, low, mid, high);
        }
    }

    public static void merge(int[] data, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (data[i] < data[j]) {
                temp[k++] = data[i++];
            } else {
                temp[k++] = data[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = data[i++];
        }

        while (j <= high) {
            temp[k++] = data[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            data[low + x] = temp[x];
        }
    }


    public static void main(String[] args) {
        int[] data = new int[]{72, 18, 53, 36, 48, 31, 36};
        System.out.println("=====排序前=====");
        Arrays.stream(data).forEach(e -> System.out.printf("%3d", e));
        System.out.println();
        mergeSort(data, 0, data.length - 1);
        System.out.println("=====排序后=====");
        Arrays.stream(data).forEach(e -> System.out.printf("%3d", e));

    }
}
