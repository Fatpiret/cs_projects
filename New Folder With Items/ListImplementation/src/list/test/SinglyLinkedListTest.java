package list.test;

import listi.SinglyLinkedList;

public class SinglyLinkedListTest {
	public static void main(String[]args) {
		SinglyLinkedList<Character> sll = new SinglyLinkedList<Character>();
		

		sll.append('4');
		sll.append('3');
		sll.prepend('1');
		System.out.println(sll);



	}

}
