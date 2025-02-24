package datastructure.tree.test;

import datastructure.tree.BinaryTree;

public class TreeTest {

	public static void main(String[] args) {
		BinaryTree<Character> bt = new BinaryTree<>();
		char[] letters = {'G', 'A', 'T','L','Z','I','X','P','H','U','E'};
		for(char c : letters) {
			bt.add(c);
		}
		//System.out.println(bt.getHeight('G'));
		System.out.println("Level Order");
		System.out.println(bt);
		System.out.println("postorder");
		System.out.println(bt.postorderToString());
		System.out.println("preorder");
		System.out.println(bt.preorderToString());
		System.out.println("inorder");
		System.out.println(bt.inorderToString());
//

		

		
		//System.out.println(bt.getSize());

		
		System.out.println(bt);
	
		
	}

}
