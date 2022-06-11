package DataStructure.Heap;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/6/2 22:34
 * @description :
 */
public class Test {
    public static void main(String[] args) {
        Heap<String> heap = new Heap<String>(10);
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");
        heap.insert("F");
        heap.insert("G");

        String result = null;
        while ((result = heap.delMax()) != null){
            System.out.print(result+" ");
        }
    }
}
