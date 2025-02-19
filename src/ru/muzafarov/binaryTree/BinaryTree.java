package ru.muzafarov.binaryTree;

/**
 *  ласс, представл€ющий бинарное дерево поиска.
 */
public class BinaryTree {
    private Node root;

    /**
     * —оздает пустое бинарное дерево.
     */
    public BinaryTree() {
        this.root = new Node();
    }

    /**
     * ƒобавл€ет значение в дерево.
     *
     * @param value «начение дл€ добавлени€.
     */
    public void add(int value) {
        root.addValue(value);
    }

    /**
     * ”дал€ет значение из дерева.
     *
     * @param value «начение дл€ удалени€.
     * @return true, если значение было удалено, иначе false.
     */
    public boolean remove(int value) {
        return root.removeValue(value);
    }

    /**
     * ѕровер€ет, содержит ли дерево указанное значение.
     *
     * @param value «начение дл€ проверки.
     * @return true, если значение найдено, иначе false.
     */
    public boolean contains(int value) {
        return root.containsValue(value);
    }

    /**
     * ¬озвращает строковое представление дерева (обход в пор€дке in-order).
     *
     * @return —троковое представление дерева.
     */
    @Override
    public String toString() {
        return root.toString().trim();
    }
}