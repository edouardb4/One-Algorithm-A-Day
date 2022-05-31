package algorithms.edouardb.struct;

public class BinarySearchTree<V> {

    private Node root;

    public void insert(int key, V value) {
        Node node = new Node(key, value);
        Node helper = root, other = null;
        while(helper != null) {
            other = helper;
            if(key < helper.getKey()) {
                helper = helper.getLeft();
            }
            else {
                helper = helper.getRight();
            }
        }
        node.setParent(other);
        if(other == null) {
            root = node;
        }
        else if(key < other.getKey()) {
            other.setLeft(node);
        }
        else {
            other.setRight(node);
        }
    }

    public void inorder() {
        inorder(root);
    }

    public void inorder(Node node) {
        if(node == null) {
            return;
        }
        inorder(node.getLeft());
        System.out.print(node.getKey() + " ");
        inorder(node.getRight());
    }

    public void transplant(Node target, Node replacer) {
        if(target.getParent() == null) {
            this.root = replacer;
        }
        else if(target.getParent().getLeft() == target) {
            target.getParent().setLeft(replacer);
        }
        else {
            target.getParent().setRight(replacer);
        }
        if(replacer != null) {
            replacer.setParent(target.getParent());
        }
    }

    public void delete(Node node) {
        if(node.getLeft() == null) {
            transplant(node, node.getRight());
        }
        else if(node.getRight() == null) {
            transplant(node, node.getLeft());
        }
        else {
            Node min = minimum(node);
            if(min.getParent() != node) {
                transplant(min, min.getRight());
                min.setRight(node.getRight());
                min.getRight().setParent(min);
            }
            transplant(node, min);
            min.setLeft(node.getLeft());
            min.getLeft().setParent(min);
        }
    }

    public Node minimum(Node node) {
        Node ret = null;
        while(node != null) {
            ret = node;
            node = node.getLeft();
        }
        return ret;
    }
}
