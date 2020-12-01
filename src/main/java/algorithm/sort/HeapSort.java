package algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序-不稳定排序、时间O(NlgN)
 */
public class HeapSort {


    /**
     * 筛法
     *
     * @param data
     * @param i
     * @param h
     */
    private static void sift(int[] data, int i, int h) {
        int x = data[i];

        //左孩子
        int j = 2 * i + 1;

        //data[i]的左孩子不为空时执行循环
        while (j <= h) {
            //取左孩子和右孩子中较大者的下标
            if (j < h && data[j] < data[j + 1]) {
                j++;
            }

            if (x >= data[j]) {
                break;
            }
            //将data[j]调整到双亲位置上
            data[i] = data[j];

            //修改i和j的值，使i指向新的调整点
            i = j;
            j = 2 * i + 1;

        }

        //将被筛结点放入最终的位置
        data[i] = x;
    }

    public static void heapSort(int[] data) {

        //对data[0...(length-1)]建大根堆
        //data.length/2-1为最后一个非叶子结点
        for (int i = data.length / 2 - 1; i >= 0; i--) {
            sift(data, i, data.length - 1);
        }

        //堆排序共n-1趟
        for (int i = data.length - 1; i > 0; i--) {
            int tmp = data[0];
            data[0] = data[i];
            data[i] = tmp;
            sift(data, 0, i - 1);

        }
    }

    public static void main(String[] args) {

        int[] data = new int[]{45,36,72,18,53,31,48,36};
        System.out.println("=====排序前=====");
        Arrays.stream(data).forEach(e-> System.out.printf("%3d",e));
        System.out.println();
        heapSort(data);
        System.out.println("=====排序后=====");
        Arrays.stream(data).forEach(e-> System.out.printf("%3d",e));

    }
}
