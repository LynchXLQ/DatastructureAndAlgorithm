package DataStructure.Heap;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/6/2 20:44
 * @description :
 */
public class Heap<T extends Comparable<T>> {
    private T[] items;
    private int N;

    public Heap(int capacity){
        this.items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }
    private boolean less(int i, int j){
        return items[i].compareTo(items[j]) < 0;
    }

    private void exchange(int i, int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public void insert(T item){
        items[++N] = item;   // 第一个N=0不放数据，从1开始放
        swim(N);
    }

    // 上浮算法，使索引index处的元素处在堆中正确位置
    private void swim(int index){
        while (index > 1){   // 到顶时index=1，就不用换了
            if (less(index/2, index)){   // 父节点的值比当前节点的值小就往上换
                exchange(index/2, index);
            }
            index = index / 2;   // 网上浮
        }
    }

    // 删除堆中最大元素
    public T delMax(){
        // 最大元素是树顶索引为1的元素
        T max = items[1];
        // 交换索引为1的元素和最后一个元素
        exchange(1, N);
        // 删除索引为1的元素，并让N-1
        items[N] = null;
        N--;
        // 下沉算法
        sink(1);
        return max;
    }

    // 下沉算法，使索引index处的元素处在堆中正确位置
    private void sink(int index){
        // 循环对比索引处的元素和它的子节点索引2*index(左) & 2*index+1(右)中大的一个，大的往上小的往下
        while (2*index <= N){   // 存在左子节点
            int left = 2 * index;
            int right = 2*index + 1;
            int max = left;
            if (right <= N){   // 存在右子节点
                if (less(left, right)){
                    max = right;
                }
            }
            if (less(max, index)){   // 当前节点比max还要大
                return;
            }
            exchange(max, index);
            index = max;
        }
    }
}
