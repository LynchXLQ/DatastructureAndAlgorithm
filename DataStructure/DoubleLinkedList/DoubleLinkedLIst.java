package DataStructure.DoubleLinkedList;

import java.util.Iterator;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/5/14 18:48
 * @description :
 */
public class DoubleLinkedLIst<T> implements Iterable<T> {
    private Node head;   // 首节点
    private Node tail;   // 尾节点
    private int N;   // 长度

    // 节点类
    private class Node {
        public T item;
        public Node pre;
        public Node next;

        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    public DoubleLinkedLIst() {
        this.head = new Node(null, null, null);
        this.tail = null;
        this.N = 0;
    }

    public void clear() {
        this.head.next = null;
        this.tail = null;
        this.N = 0;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int length() {
        return this.N;
    }

    public T get(int i) {
        Node node = head.next;
        for (int idx = 0; idx < i; idx++) {
            node = node.next;
        }
        return node.item;
    }

    public void insert(T item) {
        /*
        if 链表为空
        创建新节点，让新节点做tail，让head指向tail
        if 链表不为空
        创建新节点，让当前tail指向新节点，让新节点成为新tail
         */
        if (isEmpty()) {
            tail = new Node(item, head, null);
            head.next = tail;
        } else {
            Node currTail = tail;
            tail = new Node(item, currTail, null);
            currTail.next = tail;
        }
        N++;
    }

    public void insert(T item, int i) {
        Node preNode = head;
        for (int idx = 0; idx < i; idx++) {
            preNode = preNode.next;
        }

        Node curNode = preNode.next;
        Node newNode = new Node(item, preNode, curNode);
        preNode.next = newNode;
        curNode.pre = newNode;
        N++;
    }

    public T remove(int i) {
        Node preNode = head;
        for (int idx = 0; idx < i; idx++) {
            preNode = preNode.next;
        }

        Node curNode = preNode.next;
        Node nextNode = curNode.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
        N--;
        return curNode.item;
    }

    public int indexOf(T item) {
        Node node = head;
        for (int i = 0; node.next != null; i++) {
            if (node.item == item) {
                return i;
            }
        }
        return -1;
    }

    public T getFirst() {
        if (isEmpty()) return null;
        return head.next.item;
    }

    public T getLast() {
        return (isEmpty() ? null : tail.item);
    }


    private class TIterator implements Iterator<T>{
        private Node node;
        public TIterator(){
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

    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }
}
