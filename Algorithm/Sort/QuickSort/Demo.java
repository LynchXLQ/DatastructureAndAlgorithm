package algorithm.Sort.QuickSort;

import java.util.Arrays;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/5/3 19:18
 * @description :
 */
public class Demo {
    public static void main(String[] args) {
        Integer[] a = {6, 1, 2, 7, 9, 3, 4, 5, 8};
        QuickSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
