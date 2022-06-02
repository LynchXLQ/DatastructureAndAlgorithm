package algorithm.Sort.QuickSort;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/5/3 18:13
 * @description :
 */
public class QuickSort {
    public static void sort(Comparable[] a){
        // 对a中所有元素排序
        int left = 0;
        int right = a.length - 1;  // 8
        sort(a, left, right);
    }

    private static void sort(Comparable[] a, int left, int right){
        if (left >= right) return;

        // 对left到right分组
        int partition = partition(a, left, right);   // 返回变换后的分界值索引

        // 让左子组有序
        sort(a, left, partition-1);

        // 让右子组有序
        sort(a, partition+1, right);

    }

    public static int partition(Comparable[] a, int left, int right){
        // 1. 找到基准值，用两个pin指向数组头和尾
        Comparable key = a[left];   // a[0]
        int findLager = left;   // 0 左 -> 右
        int finSmaller = right+1;   // 8+1=9 右 -> 左

        while (true) {
            // 2. 先从尾部向头部开始搜索一个比基准值小的元素，搜到就停止，记录指针位置
            while (less(key, a[--finSmaller])){
                if (finSmaller == left){
                    break;
                }
            }
            // 3. 再从头部向尾部开始搜索一个比基准值大的元素，搜到就停止，记录指针位置
            while (less(a[++findLager], key)){
                if (findLager == right){
                    break;
                }
            }
            // 4. 交换当前左右指针指向的元素, 重复2，3，4直到左指针 >= 右指针
            if (findLager >= finSmaller){
                break;
            }
            else {
                exchange(a, findLager, finSmaller);
            }
        }
        // key值与左右指针相遇的值交换，让key值位于分界处
        exchange(a, left, finSmaller);

        return finSmaller;   // 返回分界值的index
    }

    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    private static void exchange(Comparable[] a, int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
