package algorithm.linearlist;

public class SeqList {

    private int[] data;

    /**
     * 实际存储长度
     */
    private int size;

    public SeqList() {
        data = new int[100];
        size = 0;
    }

    public void fillData(int[] data, int length) {
        this.size = length;

        for (int i = 0; i < size; i++) {

            this.data[i] = data[i];
        }
    }


    void display(String msg) {
        System.out.println("=====" + msg + "=====");
        for (int i = 0; i < size; i++) {
            System.out.print(String.format("%3d", data[i]));
        }
        System.out.println();
    }

    /**
     * @param i 要插入的位置 1~length
     * @param x 要插入的数据
     */
    void insert(int i, int x) {
        if (i < 1 || i > size + 1) {
            System.out.println("position error");
            return;
        }

        if (size == data.length) {
            System.out.println("overflow");
            return;
        }

        for (int j = data[size - 1]; j >= i - 1; j--) {
            //从最后一个元素开始逐一后移
            data[j + 1] = data[j];
        }

        //插入新元素x
        data[i - 1] = x;

        //实际表长加1
        size++;


    }

    /**
     * 删除第i个元素，并返回被删除的元素
     */
    int delete(int i) {

        if (i < 1 || i > size) {
            System.out.println("position error");
            System.exit(0);
        }

        //保存被删除元素
        int x = data[i - 1];

        for (int j = i; j <= size; j++) {
            //元素迁移
            data[j - 1] = data[j];
        }

        //实际长度减1
        size--;

        return x;
    }

    /**
     * 逆置
     * 先以表长的一半为循环控制次数，将表中最后一个元素同顺数第一元素交换，
     * 将倒数第二个元素同顺数第二个元素交换，...,依次类推，直到交换完为止
     */
    void convert() {
        int x;

        int k = size / 2;

        for (int i = 0; i < k; i++) {
            x = data[i];
            data[i] = data[size - i - 1];
            data[size - i - 1] = x;
        }
    }


    public static void main(String[] args) {


        SeqList seqList = new SeqList();

        seqList.fillData(new int[]{23, 31, 46, 54, 58, 67, 72, 88}, 8);

        seqList.display("插入前");
        seqList.insert(5, 56);
        seqList.display("插入后");


        seqList.display("删除前");
        seqList.delete(5);
        seqList.display("删除后");

        seqList.display("逆置前");
        seqList.convert();
        seqList.display("逆置后");


    }
}
