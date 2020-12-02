package algorithm.search;

public class BinarySearch {

    /**
     * 二分查找-递归方式
     *
     * @param data
     * @param low
     * @param high
     * @param k    要查找的值
     * @return 要查找的值在data中的索引
     */
    public static Integer binarySerach(int[] data, int low, int high, int k) {
        int mid;
        if (low <= high) {
            mid = (low + high) / 2;
            if (k == data[mid]) {
                return mid;
            }
            if (k > data[mid]) {
                return binarySerach(data, low + 1, high, k);
            } else {
                return binarySerach(data, low, mid - 1, k);
            }
        }

        return null;
    }

    /**
     * 二分查找-非递归方式
     * @param data
     * @param low
     * @param high
     * @param k
     * @return
     */
    public static Integer binarySearch2(int[] data, int low, int high, int k) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (k == data[mid]) {
                return mid;
            }
            if (k > data[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] data = new int[]{13, 25, 36, 42, 48, 56, 64, 69, 78, 85, 92};

        System.out.println("递归查找结果：" + binarySerach(data, 0, 10, 42));
        System.out.println("递归查找结果：" + binarySerach(data, 0, 10, 80));

        System.out.println("非递归查找结果：" + binarySearch2(data, 0, 10, 42));
        System.out.println("非递归查找结果：" + binarySearch2(data, 0, 10, 80));


    }
}
