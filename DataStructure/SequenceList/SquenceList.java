package DataStructure.SequenceList;

import java.util.Iterator;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/5/5 17:22
 * @description :
 */
public class SquenceList<T> implements Iterable<T> {
    // 储存元素的数组
    private T[] eles;
    // 记录当前顺序表中元素个数
    private int N;

    // 构造方法
    public SquenceList(int capacity) {
        // 初始化数组
        this.eles = (T[]) new Object[capacity];
        this.N = 0;
    }

    // 将一个线性表置为空表
    public void clear() {
        this.N = 0;
    }

    // 判断当前线性表是否为空表
    public boolean isEmpty() {
        return N == 0;
    }

    // 获取线性表长度
    public int length() {
        return N;
    }

    // 获取指定位置的元素
    public T get(int i) {
        return eles[i];
    }

    // 向线性表添加元素
    public void insert(T t) {
        // 判断是否需要扩容
        if (N==eles.length){
            resize(2*eles.length);
        }
        eles[N++] = t;
    }

    // 在i处插入元素t
    public void insert(int i, T t) {
        // 判断是否需要扩容
        if (N==eles.length){
            resize(2*eles.length);
        }
        // 将i及之后的元素后移
        for (int idx = N; idx > i; idx--) {
            eles[idx] = eles[idx - 1];
        }
        N++;
        // t元素放到i
        eles[i] = t;
    }

    // 删除指定i处元素，返回该元素
    public T remove(int i) {
        // 记录删除元素
        T curr = eles[i];
        // 将i及之后的元素前移
        for (int idx = i + 1; idx < N; idx++) {
            eles[idx - 1] = eles[idx];
        }
        // 元素个数减一
        N--;
        // 判断是否需要毁容
        if (N < eles.length/4){
            resize(eles.length/2);
        }
        return curr;
    }

    // 查找t元素第一次出现位置
    public int indexOf(T t) {
        for (int i = 0; i < N; i++) {
            if (eles[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    // 扩容/毁容
    public void resize(int newSize){
        // 定义临时数组
        T[] temp = eles;
        // 创建新数组
        eles = (T[]) new Object[newSize];
        // 拷贝到新数组
        for (int i=0; i<N; i++){
            eles[i] = temp[i];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {
            private int cursor;

        public SIterator() {
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return cursor < N;
        }

        @Override
        public Object next() {
            return eles[cursor++];
        }
    }
}
