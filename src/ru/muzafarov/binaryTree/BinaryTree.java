package ru.muzafarov.binaryTree;

/**
 * �����, �������������� �������� ������ ������.
 */
public class BinaryTree {
    private Node root;

    /**
     * ������� ������ �������� ������.
     */
    public BinaryTree() {
        this.root = new Node();
    }

    /**
     * ��������� �������� � ������.
     *
     * @param value �������� ��� ����������.
     */
    public void add(int value) {
        root.addValue(value);
    }

    /**
     * ������� �������� �� ������.
     *
     * @param value �������� ��� ��������.
     * @return true, ���� �������� ���� �������, ����� false.
     */
    public boolean remove(int value) {
        return root.removeValue(value);
    }

    /**
     * ���������, �������� �� ������ ��������� ��������.
     *
     * @param value �������� ��� ��������.
     * @return true, ���� �������� �������, ����� false.
     */
    public boolean contains(int value) {
        return root.containsValue(value);
    }

    /**
     * ���������� ��������� ������������� ������ (����� � ������� in-order).
     *
     * @return ��������� ������������� ������.
     */
    @Override
    public String toString() {
        return root.toString().trim();
    }
}