package algorithm.Sort.InsertionSort;

import java.util.Arrays;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/4/24 12:56
 * @description :
 */
public class InsertionSort {
    public static void main(String[] args) {
        Integer[] a = {4, 3, 2, 10, 12, 1, 5, 6};
        sort(a);
    }

    public static void sort(Comparable[] a){
        for (int idx=1; idx< a.length; idx++){
            for (int j = idx; j>0; j--){
                if (greater(a[j-1], a[j])){
                    exchange(a, j, j-1);
                }
                else {
                    break;
                }
            }
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
