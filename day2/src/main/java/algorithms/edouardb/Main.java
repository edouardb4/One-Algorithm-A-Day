package algorithms.edouardb;

import algorithms.edouardb.struct.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<String> tree = new BinarySearchTree<String>();
        tree.insert(8, "ADADASD");
        tree.insert(1, "ADASD");
        tree.insert(5, "ASDASDADSAD");
        tree.insert(0, "ADASD");
        tree.inorder();
    }
}
