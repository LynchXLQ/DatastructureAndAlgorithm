package algorithm.Sort.ShellsSort;

import algorithm.Sort.InsertionSort.InsertionSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/4/27 23:15
 * @description :
 */
public class TestTimeComplex {
    public static void main(String[] args) throws IOException {
        // 创建一个ArrayList集合，保存读取的整数
        ArrayList<Integer> arrayList = new ArrayList<>();
        // 创建缓存读取流BufferedReader，读取数据，存储到ArrayList
        BufferedReader reader = new BufferedReader(new InputStreamReader(TestTimeComplex.class.getClassLoader().getResourceAsStream("reverse_arr.txt")));
        String line = null;
        while ((line = reader.readLine()) != null){
            int i = Integer.parseInt(line);
            arrayList.add(i);
        }
        reader.close();
        // 把ArrayList集合转换成数组
        Integer[] a = new Integer[arrayList.size()];
        System.out.println(arrayList.size());
        arrayList.toArray(a);
        // 调用测试代码
        testInsertion(a);
        testShell(a);
    }
    public static void testShell(Integer[] a){
        long start = System.currentTimeMillis();
        ShellsSort.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("Shell Sort: "+(end-start));
    }

    public static void testInsertion(Integer[] a){
        long start = System.currentTimeMillis();
        InsertionSort.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("Insertion Sort: "+(end-start));
    }
}
