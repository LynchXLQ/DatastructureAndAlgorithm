package DataStructure.Tree;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/5/31 17:51
 * @description :
 */
public class Test {
    public static void main(String[] args) {
        BinaryTree<Integer, String> tree = new BinaryTree<>();
        tree.put(1, "A");
        tree.put(2, "B");
        tree.put(3, "C");
        tree.put(4, "D");
        tree.put(5, "E");
        System.out.println("key=2, value="+tree.get(2));
        tree.delete(3);
        System.out.println(tree.get(3));
        System.out.println("tree.size(): "+tree.size());
    }
}
