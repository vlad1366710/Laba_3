package ru.muzafarov.binaryTree;

public class BinaryTree {
    private Node root;


    public BinaryTree() {
        this.root = new Node();
    }


    public void add(int value) {
        root.addValue(value);
    }


    public boolean remove(int value) {
        return root.removeValue(value);
    }


    public boolean contains(int value) {
        return root.containsValue(value);
    }


    @Override
    public String toString() {
        return root.toString().trim();
    }
}
