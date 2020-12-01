package algorithm.sort;

import algorithm.linearlist.SeqList;

/**
 * 直接插入排序-稳定排序、就地排序、O(n^2)
 */
public class InsertSort {


    public static void insertSort(SeqList seqList) {
        int[] data = seqList.getData();
        for (int i = 1; i < seqList.getSize(); i++) {
            int temp = data[i];
            //若temp大于有序区中的值，则不动
            if (temp < data[i - 1]) {
                int j;
                for (j = i - 1; j >= 0 && temp < data[j]; j--) {
                    //记录后移
                    data[j + 1] = data[j];
                }

                //data[i]插入到正确的位置上
                data[j + 1] = temp;
            }

        }

    }

    public static void main(String[] args) {

        SeqList seqList = new SeqList();
        seqList.fillData(new int[]{46, 39, 17, 23, 28, 55, 18, 46}, 8);

        seqList.display("=====直接插入排序前=====");
        InsertSort.insertSort(seqList);
        seqList.display("=====直接插入排序后=====");
    }
}
