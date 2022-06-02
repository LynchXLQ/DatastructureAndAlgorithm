package algorithm.Sort.ShellsSort;

import java.util.Arrays;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/4/24 17:08
 * @description :
 */
public class ShellsSort {
    public static void main(String[] args) {
        Comparable[] a = {9, 1, 2, 5, 7,4,8,6,3,5};
        sort(a);
    }

    public static void sort(Comparable[] a) {
        // 根据数组长度确定增长量h的初始值
        int h = 0;
        while (a.length / 2 > h) {
            h = 2 * h + 1;
        }
        System.out.println("h = "+h);
        // 希尔排序
        while (h>=1){
            // 找到待插入元素，第一个待插入元素index=h
            for (int idx=h; idx<a.length; idx++){
                // 把待插入元素插入有序数列
                for (int j=idx; j>=h; j-=h){
                    // 比较大小
                    if (greater(a[j-h], a[j])){
                        exchange(a, j-h, j);
                    }
                    else{
                        break;
                    }
                }
            }
            // 减小h
            h /= 2;
        }
        System.out.println(Arrays.toString(a));
    }

    public static boolean greater(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) > 0;
    }

    public static void exchange(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
