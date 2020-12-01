package algorithm.sort;


import java.util.Arrays;

/**
 * 简单选择排序-不稳定、时间O(n^2)
 */
public class SelectSort {


    public static void selectSort(int[] data) {
        //做n-1趟排序
        for (int i = 0; i < data.length - 1; i++) {
            //设k为第i趟排序中关键字最小的记录位置
            int k = i;

            //在【i...(length-1)]中选择最小值
            for (int j = i; j < data.length; j++) {
                if (data[j] < data[k]) {
                    k = j;
                }
            }

            if (k != i) {
                int tmp = data[i];
                data[i] = data[k];
                data[k] = tmp;
            }
        }
    }

    public static void main(String[] args) {

        int[] data = new int[]{38, 33, 65, 82, 76, 38, 24, 11};
        System.out.println("=====排序前=====");
        Arrays.stream(data).forEach(e-> System.out.printf("%3d",e));
        System.out.println();
        selectSort(data);
        System.out.println("=====排序后=====");
        Arrays.stream(data).forEach(e-> System.out.printf("%3d",e));

    }
}
