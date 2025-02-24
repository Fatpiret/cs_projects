package test;

import datastructures.bst.BinarySearchTree;

public class BSTTest {
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		
		
		
		bst.add(50);
		bst.add(25);
		bst.add(75);
		bst.add(15);
		bst.add(35);
		bst.add(65);
		
		bst.remove(51);
		System.out.println(bst.levelOrderToString());
	}

}
