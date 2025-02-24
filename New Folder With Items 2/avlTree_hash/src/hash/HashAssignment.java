package hash;

import java.util.*;

public class HashAssignment {
    public static void main(String[] args) {
        // Integer Lists
        List<List<Integer>> intLists = new LinkedList<>();
        intLists.add(new ArrayList<>(Arrays.asList(3, 4, 9, 8, 12, 15, 7, 13)));
        intLists.add(new ArrayList<>(Arrays.asList(15, 24, 50, 12, 3, 9)));
        intLists.add(new ArrayList<>(Arrays.asList(78, 65, 24, 13, 9, 3, 12)));
        intLists.add(new ArrayList<>(Arrays.asList(15, 78, 14, 3, 2, 9, 44, 12)));

        List<Integer> intResult = findCommonElements(intLists);
        System.out.println("Common elements of the integer list:");
        System.out.println(intResult + "\n");

        // String Lists
        List<List<String>> stringLists = new LinkedList<>();
        stringLists.add(new ArrayList<>(Arrays.asList("a", "b", "d", "c", "h", "e")));
        stringLists.add(new ArrayList<>(Arrays.asList("g", "b", "e", "j", "u", "z", "h", "d")));
        stringLists.add(new ArrayList<>(Arrays.asList("y", "p", "b", "d")));

        List<String> stringResult = findCommonElements(stringLists);
        System.out.println("Common elements of the string list:");
        System.out.println(stringResult);

        // Example usage of AVLTree
        System.out.println("\nIn-order traversal of the AVL tree:");
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(5);
        avlTree.inOrderTraversal(); // Output: 5 10 20
    }

    // Method to find common elements in a list of lists
    public static <T> List<T> findCommonElements(List<List<T>> collections) {
        if (collections == null || collections.isEmpty()) {
            return new ArrayList<>();
        }

        // Initialize the HashSet with the first list's elements
        HashSet<T> commonElements = new HashSet<>(collections.get(0));

        // Retain only common elements in all subsequent lists
        for (int i = 1; i < collections.size(); i++) {
            commonElements.retainAll(collections.get(i));
        }

        return new ArrayList<>(commonElements);
    }
}
