package DataStructure.LinkedList;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/5/7 14:39
 * @description :
 */
public class Test {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.insert("A");
        linkedList.insert("B");
        linkedList.insert("C");
        linkedList.insert("D");
        linkedList.insert(1, "E");
        for (String s:linkedList){
            System.out.println(s);
        }
        System.out.println("------------");
        linkedList.reverse();
        for (String s:linkedList){
            System.out.println(s);
        }
        String s1 = linkedList.get(1);
        System.out.println("linkedList.get(1): "+s1);
        String s2 = linkedList.remove(1);
        System.out.println("linkedList.remove(1): "+s2);
        for (String s:linkedList){
            System.out.println(s);
        }
        System.out.println(linkedList.length());
        linkedList.clear();
        System.out.println("inkedList.clear(): "+linkedList.length());
    }
}
