package DataStructure.LinkedList;

import java.util.Iterator;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/5/6 12:08
 * @description :
 */
public class LinkedList<T> implements Iterable<T>{
    // 记录头节点
    private Node head;
    // 记录链表长度
    private int N;

    // 结点类
    private class Node {
        // 数据
        T item;
        // 下一个
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public LinkedList() {
        // 初始化头节点
        this.head = new Node(null, null);
        // 初始化元素个数
        this.N = 0;
    }

    // 清空链表
    public void clear() {
        head.next = null;
        N = 0;
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    // 获取线性表元素个数
    public int length() {
        return N;
    }

    // 返回第i个元素的值
    public T get(int i) {
        Node node = head;
        for (int idx = 0; idx <i; idx++){
            node = node.next;
        }
        return node.item;
    }

    // 添加元素
    public void insert(T t) {
        Node node = head;
        // 找到最后一个节点
        while (node.next!=null){
            node = node.next;
        }
        // 创建新节点
        Node newNode = new Node(t, null);
        // 最后一个节点指向新节点
        node.next = newNode;
        // 个数加一
        N++;
    }

    // 在第i个元素前插入一个值为t的元素
    public void insert(int i, T t) {
        Node pre = head;
        // 找到i-1节点
        for (int idx=0; idx<i-1; idx++){
            pre= pre.next;
        }

        // 找到i节点
        Node cur = pre.next;

        // 创建新节点
        Node newNode = new Node(t, null);

        // i-1 -> 新 -> i
        newNode.next = cur;
        pre.next = newNode;

        // 个数加一
        N++;

    }

    // 删除并返回第i个元素
    public T remove(int i) {
        Node pre = head;
        // 找到i-1节点
        for (int idx=0; idx<i-1; idx++){
            pre= pre.next;
        }
        // 找到i节点
        Node cur = pre.next;

        // 找到i+1节点
        Node next = cur.next;

        // i-1 -> i+1
        pre.next = next;

        // 个数减一
        N--;
        return cur.item;
    }

    // 返回首次出现的元素t的索引，不存在则返回-1
    public int indexOf(T t) {
        Node node = head;
        // 遍历
        for (int i=0; node.next!=null; i++){
            node = node.next;
            if (node.item == t){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator(){
        return new LIterator();
    }

    private class LIterator implements Iterator{
        private Node node;

        public LIterator() {
            this.node = head;
        }

        @Override
        public boolean hasNext() {
            return node.next!=null;
        }

        @Override
        public Object next() {
            node = node.next;
            return node.item;
        }
    }

    public void reverse(){
        if (isEmpty()){
            return;
        }
        reverse(head.next);
    }

    public Node reverse(Node curNode){
        if (curNode.next == null){
            head.next = curNode;
            return curNode;
        }
        Node newPreNode = reverse(curNode.next);
        newPreNode.next = curNode;
        curNode.next = null;
        return curNode;
    }
}
