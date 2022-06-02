package DataStructure.Tree;

import DataStructure.Queue.Queue;

import java.lang.annotation.Retention;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/6/1 22:24
 * @description :
 */
public class ErgodicTest {
    public static void main(String[] args) {
        BinaryTree<String, String> tree = new BinaryTree<>();
        tree.put("E", "5");
        tree.put("B", "2");
        tree.put("G", "7");
        tree.put("A", "1");
        tree.put("D", "4");
        tree.put("F", "6");
        tree.put("H", "8");
        tree.put("C", "3");

/*        Queue<String> preErgodic = tree.preErgodic();
        for (String key: preErgodic){
            String value = tree.get(key);
            System.out.println(key+"---"+value);
        }*/

/*        Queue<String> midErgodic = tree.midErgodic();
        for (String key: midErgodic){
            String value = tree.get(key);
            System.out.println(key+"---"+value);
        }*/

/*        Queue<String> postErgodic = tree.postErgodic();
        for (String key: postErgodic){
            String value = tree.get(key);
            System.out.println(key+"---"+value);
        }*/

        Queue<String> layerErgodic = tree.layerErgodic();
        for (String key: layerErgodic){
            String value = tree.get(key);
            System.out.println(key+"---"+value);
        }
    }
}
