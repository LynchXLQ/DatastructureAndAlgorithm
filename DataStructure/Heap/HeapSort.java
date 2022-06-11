package DataStructure.Heap;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/6/4 12:03
 * @description :
 */
public class HeapSort {
    private static boolean less(Comparable[] heap, int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    private static void exchange(Comparable[] heap, int i, int j) {
        Comparable temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // 根据原数组source构造处heap
    private static void createHeap(Comparable[] source, Comparable[] heap) {
        // 把source中的元素拷贝入heap形成一个无序堆
        System.arraycopy(source, 0, heap, 1, source.length);
        // 从长度一半处扫描（后一半都是叶子节点，没有子节点），下沉
        for (int i = (heap.length) / 2; i > 0; i--) {
            sink(heap, i, heap.length - 1);
        }
    }

    // 对source数组中的数据从小到大排序
    public static void sort(Comparable[] source) {
        // 构建堆
        Comparable[] heap = new Comparable[source.length + 1];   // 0索引处不存元素，所以长度要加一
        createHeap(source, heap);
        int N = heap.length - 1;   // 记录最大索引
        // 循环交换索引1处的元素和最大索引处的元素（最后一个元素）
        while (N != 1){   // 只剩最后一个就不用交换了
            exchange(heap, 1, N);
            N--;   // 排好序的索引处的元素不再参与下沉调整
            sink(heap, 1, N);
        }   // 循环好的heap是从小到大
        // 把heap中的数据复制到原数组
        System.arraycopy(heap, 1, source, 0, source.length);
    }

    // 在heap中，对target元素做下沉，范围0~range
    private static void sink(Comparable[] heap, int target, int range) {
        // 循环对比索引处的元素和它的子节点索引2*index(左) & 2*index+1(右)中大的一个，大的往上小的往下
        while (2 * target <= range) {   // 存在左子节点
            int left = 2 * target;
            int right = 2 * target + 1;
            int max = left;
            if (right <= range){   // 存在右子节点
                if (less(heap, left, right)){
                    max = right;
                }
            }
            if (less(heap, max, target)){   // 当前节点比max还要大
                return;
            }
            exchange(heap, target, max);
            target = max;
        }
    }
}
