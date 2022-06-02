package DataStructure.Stack;

import java.util.Iterator;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/5/24 16:38
 * @description :
 */
public class Stack<T> implements Iterable<T>{
    private int N;
    private Node head;

    private class Node{
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Stack(){
        this.head = new Node(null, null);
        this.N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void push(T item){
        Node curNode = new Node(item, null);
        Node firstNode = head.next;
        head.next = curNode;
        curNode.next = firstNode;
        N++;
    }

    public T pop(){
        Node curNode = head.next;
        if (curNode == null){
            return null;
        }
        head.next = curNode.next;
        N--;
        return curNode.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator<T>{
        private Node node;
        public SIterator(){
            this.node = head;
        }
        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public T next() {
            node = node.next;
            return node.item;
        }
    }
}
