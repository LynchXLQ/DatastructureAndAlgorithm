package algorithm.Sort.SellectionSort;

import java.util.Arrays;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/4/24 12:11
 * @description :
 */
public class SelectionSort {
    public static void main(String[] args) {
        Integer[] a = {4, 6, 8, 7, 9, 2, 10, 1};
        sort(a);
    }

    private static void sort(Comparable[] a) {
        for (int idx = 0; idx < a.length - 1; idx++) {
            int minIdx = idx;
            for (int j = idx + 1; j < a.length; j++) {
                if (greater(a[minIdx], a[j])) {
                    minIdx = j;
                }
            }
            exchange(a, idx, minIdx);
        }
        System.out.println(Arrays.toString(a));
    }

    private static boolean greater(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) > 0;
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
