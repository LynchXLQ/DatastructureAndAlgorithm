package algorithm.Sort.BuubleSort;

import java.util.Arrays;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/4/23 14:44
 * @description :
 */
public class BubbleSort {
    public static void main(String[] args) {
        Integer[] arr = {9,8,7,6,5,4,3,2,1,0};
        Comparable[] res1 = sort01(arr);
        Comparable[] res2 = sort02(arr);
        System.out.println("Sort 1: "+Arrays.toString(res1));
        System.out.println("Sort 2: "+Arrays.toString(res2));
    }

    public static Comparable[] sort01(Comparable[] a) {
        for (int idx = 0; idx < a.length - 1; idx++) {
            for (int j = 0; j < a.length - idx; j++) {
                if (greater(a[idx], a[j])) {
                    exchange(a, idx, j);
                }
            }
        }
        return a;
    }

    public static Comparable[] sort02(Comparable[] a) {
        for (int round = a.length-1; round > 0; round--) {
            for (int idx = 0; idx < round; idx++) {
                if (greater(a[idx], a[idx+1])){
                    exchange(a, idx, 1+idx);
                }
            }
        }
        return a;
    }

    public static void exchange(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean greater(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) > 0;
    }
}
