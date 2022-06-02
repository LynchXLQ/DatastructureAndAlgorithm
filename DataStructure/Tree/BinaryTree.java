package DataStructure.Tree;


import DataStructure.Queue.Queue;

/**
 * @author : Linqi Xiao
 * @version : JDK-17.0.2
 * @date : 2022/5/29 11:45
 * @description :
 */
public class BinaryTree<Key extends Comparable<Key>, Value> {
    private Node root;
    private int N;

    private class Node {
        public Key key;
        public Value value;
        public Node left;
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public int size() {
        return this.N;
    }

    public void put(Key key, Value value) {
        this.root = put(this.root, key, value);   // 调用重载方法
    }

    // 向指定树node中添加key-value，并返回添加元素后的树
    private Node put(Node node, Key key, Value value) {
        // 如果子树node为空
        if (node == null) {
            N++;
            return new Node(key, value, null, null);
        }
        int compare = key.compareTo(node.key);
        // 如果子树node不为空，比较node节点的键和key的大小
        // 键 < key，找右子树
        if (compare > 0) {
            node.right = put(node.right, key, value);
        }
        // 键 > key，找左子树
        else if (compare < 0) {
            node.left = put(node.left, key, value);
        }
        // 键 = key，替换node的值为value
        else {
            node.value = value;
        }
        return node;
    }

    public Value get(Key key) {
        return get(root, key);   // 调用重载方法
    }

    private Value get(Node node, Key key) {
        // 如果子树node为空
        if (node == null) {
            return null;
        }
        // 如果子树node不为空, 比较node节点的键和key的大小
        int compare = key.compareTo(node.key);
        // 键 < key，找右子树
        if (compare > 0) {
            return get(node.right, key);
        }
        // 键 > key，找左子树
        else if (compare < 0) {
            return get(node.left, key);
        }
        // 键 = key，找到了
        else {
            return node.value;
        }
    }

    public void delete(Key key) {
        delete(this.root, key);
    }

    // 删除指定树node中的key对应的value，返回删除后的树
    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        // 如果子树node不为空, 比较node节点的键和key的大小
        int compare = key.compareTo(node.key);
        if (compare > 0) {
            node.right = delete(node.right, key);
        } else if (compare < 0) {
            node.left = delete(node.left, key);
        } else {
            N--;
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            // 因为右子树都大于node的value，找右子树的最小值来替换删除的点，等价于走左路走到底
            Node minNode = node.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            // 删除找到的右子树中的最小值点
            Node tempMinNode = node.right;
            while (tempMinNode.left != null) {
                if (tempMinNode.left.left == null) tempMinNode.left = null;   // 找到左边最后一个点然后删除
                else tempMinNode = tempMinNode.left;   // 没找到就继续找
            }
            minNode.left = node.left;
            minNode.right = node.right;
            node = minNode;
        }
        return node;
    }

    // 查找整个树中最小的键
    public Key min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left != null) {
            return min(node.left);
        } else {
            return node;
        }
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right != null) {
            return max(node.right);
        } else {
            return node;
        }
    }

    // ============== 遍历 =================
    public Queue<Key> preErgodic() {
        Queue<Key> keys = new Queue<Key>();
        preErgodic(root, keys);
        return keys;
    }

    private void preErgodic(Node node, Queue<Key> keys) {
        if (node == null) {
            return;
        }
        // 将node的key放入keys
        keys.enqueue(node.key);
        // 遍历左子树
        if (node.left != null) {
            preErgodic(node.left, keys);
        }
        // 遍历右子树
        if (node.right != null) {
            preErgodic(node.right, keys);
        }
    }

    public Queue<Key> midErgodic() {
        Queue<Key> keys = new Queue<Key>();
        midErgodic(root, keys);
        return keys;
    }

    private void midErgodic(Node node, Queue<Key> keys) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            midErgodic(node.left, keys);
        }
        keys.enqueue(node.key);
        if (node.right != null) {
            midErgodic(node.right, keys);
        }
    }

    public Queue<Key> postErgodic() {
        Queue<Key> keys = new Queue<Key>();
        postErgodic(root, keys);
        return keys;
    }

    private void postErgodic(Node node, Queue<Key> keys) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            postErgodic(node.left, keys);
        }
        if (node.right != null) {
            postErgodic(node.right, keys);
        }
        keys.enqueue(node.key);
    }

    public Queue<Key> layerErgodic() {
        Queue<Key> keys = new Queue<>();
        Queue<Node> tempQueue = new Queue<>();
        tempQueue.enqueue(root);

        while (!tempQueue.isEmpty()) {
            Node node = tempQueue.dequeue();
            keys.enqueue(node.key);
            if (node.left != null) {
                tempQueue.enqueue(node.left);
            }
            if (node.right != null) {
                tempQueue.enqueue(node.right);
            }
        }
        return keys;
    }

    public int maxDepth() {
        return maxDepth(root);
    }

    private int maxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        int max = 0;
        int maxL = 0;
        int maxR = 0;
        // 计算左子树最大深度
        if (node.left != null) {
            maxL = maxDepth(node.left);
        }
        // 计算右子树最大深度
        if (node.right != null) {
            maxR = maxDepth(node.right);
        }
        // 比较左右子树深度，较大值加一(最上面的node)
        max = maxL > maxR ? maxL + 1 : maxR + 1;
        return max;
    }
}
