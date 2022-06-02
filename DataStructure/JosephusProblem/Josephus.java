package DataStructure.JosephusProblem;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/5/22 18:59
 * @description :
 */
public class Josephus {
    public static void main(String[] args) {
        // 41个节点的循环链表
        Node<Integer> preNode = null;
        Node<Integer> firstNode = null;
        for(int i=1; i<=41; i++){
            if (i == 1){
                firstNode = new Node<>(i, null);
                preNode = firstNode;
                continue;
            }
            Node<Integer> newNode = new Node<>(i, null);
            preNode.next = newNode;
            preNode = newNode;
            if (i == 41){
                preNode.next = firstNode;
            }
        }

        // count计数模拟报数
        int count = 0;
        Node<Integer> curNode = firstNode;
        Node<Integer> beforeCurNode = null;
        while (curNode.next != curNode){
            count ++;

            if (count == 3){
                beforeCurNode.next = curNode.next;
                System.out.println(curNode.item);
                count = 0;
                curNode = curNode.next;
            }else {
                beforeCurNode = curNode;
                curNode = curNode.next;
            }
        }
        System.out.println("最后幸存 "+curNode.item);
    }

    // 内部节点类
    private static class Node<T>{
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
