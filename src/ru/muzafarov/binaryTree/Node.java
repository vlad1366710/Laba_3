package ru.muzafarov.binaryTree;

class Node {
    private Integer value;
    private Node parent;
    private Node leftChild;
    private Node rightChild;

    // Конструктор без аргументов
    public Node() {
        this.value = null;
        this.parent = null;
        this.leftChild = null;
        this.rightChild = null;
    }

    // Метод для добавления значения
    public void addValue(int newValue) {
        if (this.value == null) {
            this.value = newValue; // Устанавливаем значение, если оно не задано
        } else {
            if (newValue > this.value) {
                if (this.rightChild == null) {
                    this.rightChild = new Node();
                    this.rightChild.parent = this;
                }
                this.rightChild.addValue(newValue); // Рекурсивно добавляем в правое поддерево
            } else {
                if (this.leftChild == null) {
                    this.leftChild = new Node();
                    this.leftChild.parent = this;
                }
                this.leftChild.addValue(newValue); // Рекурсивно добавляем в левое поддерево
            }
        }
    }

    public boolean removeValue(int valueToRemove) {
        if (this.value == null) {
            return false; // Значение не найдено
        }

        if (valueToRemove < this.value) {
            // Рекурсивно ищем в левом поддереве
            return this.leftChild != null && this.leftChild.removeValue(valueToRemove);
        } else if (valueToRemove > this.value) {
            // Рекурсивно ищем в правом поддереве
            return this.rightChild != null && this.rightChild.removeValue(valueToRemove);
        } else {
            // Удаляем текущий узел
            if (this.leftChild != null && this.rightChild != null) {
                // Узел с двумя детьми
                // Находим минимальный узел в правом поддереве
                Node minNode = this.rightChild;
                while (minNode.leftChild != null) {
                    minNode = minNode.leftChild;
                }
                // Заменяем значение текущего узла на значение минимального узла
                this.value = minNode.value;
                // Удаляем минимальный узел
                this.rightChild.removeValue(minNode.value);
            } else if (this.leftChild != null) {
                // Узел с одним левым ребенком
                replaceNodeInParent(this.leftChild);
            } else if (this.rightChild != null) {
                // Узел с одним правым ребенком
                replaceNodeInParent(this.rightChild);
            } else {
                // Узел без детей
                replaceNodeInParent(null);
            }
            return true; // Успешно удалено
        }
    }

    // Метод для замены узла в родителе
    private void replaceNodeInParent(Node newValue) {
        if (this.parent != null) {
            if (this.parent.leftChild == this) {
                this.parent.leftChild = newValue;
            } else {
                this.parent.rightChild = newValue;
            }
        }
        if (newValue != null) {
            newValue.parent = this.parent;
        }
    }


    // Метод для проверки существования значения
    public boolean containsValue(int valueToCheck) {
        if (this.value == null) {
            return false; // Узел пустой
        }
        if (this.value.equals(valueToCheck)) {
            return true; // Значение найдено
        } else if (valueToCheck > this.value) {
            return this.rightChild != null && this.rightChild.containsValue(valueToCheck); // Проверяем в правом поддереве
        } else {
            return this.leftChild != null && this.leftChild.containsValue(valueToCheck); // Проверяем в левом поддереве
        }
    }

    // Метод для строкового представления узла
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.leftChild != null) {
            sb.append(this.leftChild.toString());
        }
        if (this.value != null) {
            sb.append(this.value).append(" ");
        }
        if (this.rightChild != null) {
            sb.append(this.rightChild.toString());
        }
        return sb.toString();
    }
}
