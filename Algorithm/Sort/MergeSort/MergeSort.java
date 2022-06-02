package algorithm.Sort.MergeSort;


/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/5/2 17:48
 * @description :归并排序
 */
public class MergeSort {
    private static Comparable[] assist;

    public static void sort(Comparable[] a) {
        // 1. 初始化辅助数组assist
        assist = new Comparable[a.length];
        // 2. 定义left, right，分别记录数组中最小的索引和最大是索引
        int left = 0;
        int right = a.length - 1;
        // 3. 调用sort重载方法完成数组a中，从索引small到big的元素排序
        sort(a, left, right);
    }

    private static void sort(Comparable[] a, int left, int right) {
        // 安全性校验
        if (left >= right) return;

        // 对small和big之间的数据分成2组
        int mid = left + (right - left)/2;

        // 分别对每一组排序
        sort(a, left, mid);
        sort(a, mid+1, right);

        // 把两个组的数据归并
        merge(a, left, mid, right);

    }

    private static void merge(Comparable[] a, int left, int mid, int right){
        // 定义三个指针
        int leftPin = left;
        int rightPin = mid + 1;
        int assistPin = left;

        // 遍历
        while (leftPin <= mid && rightPin <= right){
            if (less(a[leftPin], a[rightPin])){
                assist[assistPin++] = a[leftPin++];
            }
            else {
                assist[assistPin++] = a[rightPin++];
            }
        }
        // left子组还有剩
        while (leftPin <= mid){
            assist[assistPin++] = a[leftPin++];
        }
        // right子组还有剩
        while (rightPin <= right){
            assist[assistPin++] = a[rightPin++];
        }

        // 把辅助数组的元素拷贝到原数组
        if (right + 1 - left >= 0) System.arraycopy(assist, left, a, left, right + 1 - left);
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
