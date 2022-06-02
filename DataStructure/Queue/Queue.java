package DataStructure.Queue;


import java.util.Iterator;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/5/27 14:23
 * @description :
 */
public class Queue<T> implements Iterable<T>{
    private Node head;
    private  Node tail;
    private int N;

    private class Node{
        public T item;
        public Node next;
        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Queue(){
        this.head = new Node(null, null);
        this.tail = null;
        this.N = 0;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void enqueue(T item){
        Node curNode = new Node(item, null);
        if (tail == null){
            tail = curNode;
            head.next = tail;
        }else {
            Node oldTail = tail;
            tail = curNode;
            oldTail.next = curNode;
        }
        N++;
    }

    public T dequeue(){
        if (isEmpty()){
            return null;
        }
        Node curNode = head.next;
        head.next = curNode.next;
        N--;
        if (isEmpty()){
            tail = null;
        }
        return curNode.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }

    private class QIterator implements Iterator{
        private Node node;
        public QIterator(){
            this.node = head;
        }
        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public Object next() {
            node = node.next;
            return node.item;
        }
    }
}
