package DataStructure.DoubleLinkedList;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/5/17 18:38
 * @description :
 */
public class Test {
    public static void main(String[] args) {
        DoubleLinkedLIst<String> dll = new DoubleLinkedLIst<>();
        dll.insert("A");
        dll.insert("B");
        dll.insert("C");
        dll.insert("D", 1);
        for (String s : dll) {
            System.out.println(s);
        }
        System.out.println("dll.getFirst()" + dll.getFirst() + " " + "dll.getLast()" + dll.getLast());
        String s1 = dll.get(1);
        System.out.println("dll.get(1)" + s1);
        String s2 = dll.remove(1);
        System.out.println("dll.remove(1)" + s2);
        dll.clear();
        System.out.println("dll.clear()" + dll.length());

    }
}
