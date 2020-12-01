package algorithm.sort;

import algorithm.linearlist.SeqList;

/**
 * 希尔排序-不稳定排序、O（n^1.25~1.6n^1.25)
 */
public class ShellSort {

    public static void shellSort(SeqList seqList) {
        int[] data = seqList.getData();
        int d = seqList.getSize() / 2;
        while (d >= 1) {
            shellInsert(seqList, data, d);
            d /= 2;
        }
    }

    private static void shellInsert(SeqList seqList, int[] data, int d) {
        for (int i = d; i < seqList.getSize(); i++) {
            int temp = data[i];
            if (temp < data[i - d]) {
                int j;
                for (j = i - d; j >= 0 && temp < data[j]; j -= d) {
                    data[j + d] = data[j];
                }

                data[j + d] = temp;
            }

        }
    }

    public static void main(String[] args) {
        SeqList seqList = new SeqList();
        seqList.fillData(new int[]{36, 25, 48, 27, 65, 25, 43, 58, 76, 32}, 10);

        seqList.display("=====希尔排序前=====");
        shellSort(seqList);
        seqList.display("=====希尔排序后=====");
    }
}
