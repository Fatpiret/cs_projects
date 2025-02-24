package myStack;

public class TestStack {

	public static void main(String[] args) {
		LinkedStack<String> stringStack = new LinkedStack<>();
		stringStack.push("A");
		stringStack.push("B");
		stringStack.push("C");
	 while(!stringStack.isEmpty()) {
		 System.out.println(stringStack.peek());
		 stringStack.pop();
	 }
	 //stringStack.pop();
	 //stringStack.peek();
	}

}
