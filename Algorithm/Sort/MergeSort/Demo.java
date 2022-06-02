package algorithm.Sort.MergeSort;

import java.util.Arrays;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/5/2 19:01
 * @description :
 */
public class Demo {
    public static void main(String[] args) {
        Integer[] a = {8, 4, 5, 7, 1, 3, 6, 2};
        MergeSort.sort(a);
        System.out.println(Arrays.toString(a));

    }
}
