package hash;

public class AVLTree<T extends Comparable<T>> {

    // Nested Node class
    public static class Node<T> {
        public T data;
        public Node<T> left, right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node<T> root;

    public AVLTree() {
        root = null;
    }

    // Insert a value into the AVL tree
    public void insert(T value) {
        root = insertNode(root, value);
    }

    private Node<T> insertNode(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        }

        if (value.compareTo(node.data) < 0) {
            node.left = insertNode(node.left, value);
        } else if (value.compareTo(node.data) > 0) {
            node.right = insertNode(node.right, value);
        }

        // For simplicity, we're skipping balancing logic
        return node;
    }

    // In-order traversal of the AVL tree
    public void inOrderTraversal() {
        inOrder(root);
    }

    private void inOrder(Node<T> node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }
}
