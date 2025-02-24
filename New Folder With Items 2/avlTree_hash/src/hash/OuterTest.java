package hash;

import java.util.*;

public class OuterTest {
    public static void main(String[] args) {
        // Test case 1: Finding common elements in integer lists
        System.out.println("=== Testing HashAssignment ===");
        List<List<Integer>> intLists = new LinkedList<>();
        intLists.add(Arrays.asList(3, 4, 9, 8, 12, 15, 7, 13));
        intLists.add(Arrays.asList(15, 24, 50, 12, 3, 9));
        intLists.add(Arrays.asList(78, 65, 24, 13, 9, 3, 12));
        intLists.add(Arrays.asList(15, 78, 14, 3, 2, 9, 44, 12));

        List<Integer> commonIntegers = HashAssignment.findCommonElements(intLists);
        System.out.println("Common elements in integer lists: " + commonIntegers);

        // Test case 2: Finding common elements in string lists
        List<List<String>> stringLists = new LinkedList<>();
        stringLists.add(Arrays.asList("a", "b", "d", "c", "h", "e"));
        stringLists.add(Arrays.asList("g", "b", "e", "j", "u", "z", "h", "d"));
        stringLists.add(Arrays.asList("y", "p", "b", "d"));

        List<String> commonStrings = HashAssignment.findCommonElements(stringLists);
        System.out.println("Common elements in string lists: " + commonStrings);

        // Test case 3: Testing AVLTree insertion and traversal
        System.out.println("\n=== Testing AVLTree ===");
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(5);
        avlTree.insert(15);
        
        System.out.print("In-order traversal of AVL tree: ");
        avlTree.inOrderTraversal(); // Output should be sorted: 5 10 15 20
    }
}
