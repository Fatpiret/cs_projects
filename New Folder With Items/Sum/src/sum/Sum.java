package sum;


	import java.io.*;

	import java.util.Scanner;



	public class Sum {

	public static void main(String[] args) throws IOException {

	  Scanner textfile = new Scanner(new File("in.txt"));



	  LinkedList linkedList = new LinkedList();

	  while (textfile.hasNext()) {

	    linkedList.insert(textfile.nextInt());

	  }

	  textfile.close();



	  linkedList.searchingSum();

	}

	}



	 

	class Node {

	    int data;

	    Node next;



	    Node(int data) {

	        this.data = data;

	        this.next = null;

	    }

	}



	class LinkedList {

	    Node head;



	    void insert(int data) {

	        Node newNode = new Node(data);

	        newNode.next = head;

	        head = newNode;

	    }



	    boolean searchingSum(Node first, Node second, Node third) {

	        if (first == null || second == null || third == null) {

	            return false;

	        }



	        if (first != second && first.data + second.data == third.data) {

	            System.out.println("Yes. " + first.data + " + " + second.data + " = " + third.data);

	            return true;

	        }



	        return searchingSum(first, second, third.next) ||searchingSum(first, second.next, third) ||searchingSum(first.next, second, third);

	 

	    }

	  public boolean searchingSum() {

	    if (!searchingSum( head.next.next, head.next, head)) {

	      System.out.println("No");

	    }

	    return false;

	  }

	}
