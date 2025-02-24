package list.test;

import listi.DoublyLinkedList;

public class DoublyLinkedListTest {
	public static void main(String[]args) {
		DoublyLinkedList<Character> dll = new DoublyLinkedList<Character>();
		
		System.out.println(dll);
		dll.add(0, 'a');
		dll.add(0, 'b');
		dll.add(1, 'c');
		dll.append('d');
		dll.prepend('e');
		dll.add(2, 'h');
		System.out.println(dll);
		//dll.remove(new Character('a'));
       // dll.remove(0);
		//dll.add(2, 'f');
		System.out.println(dll);
		//dll.remove(dll.getSize() -1);
		System.out.println(dll);
		System.out.println(dll.indexOf('d'));
		//System.out.println(dll.get(2));
		System.out.println(dll);
		//dll.add(3, 'a');
		//dll.append('z');
		//dll.add(0, 'z');
		//System.out.println(dll);
		//dll.remove(1);
		//System.out.println(dll);

		


	}
}