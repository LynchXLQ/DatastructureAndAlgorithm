package DataStructure.Queue;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/5/27 14:43
 * @description :
 */
public class Test {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        for (String s: queue){
            System.out.println(s);
        }
        System.out.println("dequeue(): "+queue.dequeue());
        System.out.println("size(): "+queue.size());
    }
}
