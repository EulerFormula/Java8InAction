package algorithm.sort;

import java.awt.dnd.DropTarget;
import java.util.Arrays;

/**
 * 快速排序-不稳定排序、时间O(NlgN)、空间O(lgN)
 */
public class QuickSort {


    public static void quickSort(int[] data, int low, int high) {
        if (low < high) {
            //做一次划分排序
            int p = partition(data, low, high);
            //对左区间递归排序
            quickSort(data, low, p - 1);
            //对右区间递归排序
            quickSort(data, p + 1, high);
        }
    }

    public static int partition(int[] data, int low, int high) {
        //用第一个记录为基准
        int x = data[low];
        while (low < high) {
            //从high位置起向前搜索
            while (low < high && data[high] > x) {
                high--;
            }
            if (low < high) {
                data[low] = data[high];
                low++;
            }

            //从low起向后搜索
            while (low < high && data[low] < x) {
                low++;
            }
            if (low < high) {
                data[high] = data[low];
                high--;
            }
        }

        data[low] = x;
        return low;
    }

    public static void main(String[] args) {

        int[] data = new int[]{45, 53, 18, 36, 76, 32, 49, 97, 12, 36};
        System.out.println("=====排序前=====");
        Arrays.stream(data).forEach(e -> System.out.printf("%3d", e));
        System.out.println();
        quickSort(data, 0, 9);
        System.out.println("=====排序后=====");
        Arrays.stream(data).forEach(e -> System.out.printf("%3d", e));

    }
}
