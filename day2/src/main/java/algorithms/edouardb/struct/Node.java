package algorithms.edouardb.struct;

public class Node<V> {

    private int key;
    private V value;
    private Node parent, right, left;
    public Node(int key,V value) {
        this.key = key;
        this.value = value;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getRight() {
        return right;
    }

    public Node getLeft() {
        return left;
    }

    public V getValue() {
        return value;
    }

    public int getKey() {
        return key;
    }
}
