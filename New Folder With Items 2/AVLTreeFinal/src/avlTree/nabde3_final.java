package avlTree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class nabde3_final<T extends Comparable<? super T>> {
private Node root;
private int size;
//Do Not Modify
public boolean isEmpty() {
return size == 0;
}
//Do Not Modify
public boolean add(T item) {
boolean added = false;
if(isEmpty()) {
root = new Node(item);
size += 1;
added = true;
} else {
added = add(null, root, item);
}
return added;
}
//Do Not Modify
private boolean add(Node parent, Node current, T data) {
boolean added = false;
if(current == null) {
int result = data.compareTo(parent.data);
if(result < 0) {
parent.left = new Node(data);
} else {
parent.right = new Node(data);
}
size += 1;
return true;
} else if(data.compareTo(current.data) < 0) {
added = add(current, current.left, data);
} else if(data.compareTo(current.data) > 0) {
added = add(current, current.right, data);
} else {
return false;
}
fixHeight(current);
if(added) {
rebalance(parent, current);
}
return added;
}
//Do Not Modify
private int getHeight(Node node) {
if(node == null) {
return -1;
}
return Math.max(node.leftHeight, node.rightHeight);
}
//Do Not Modify
private void fixHeight(Node node) {
if(node != null) {
node.leftHeight = getHeight(node.left) + 1;
node.rightHeight = getHeight(node.right) + 1;
}
}
//Do Not Modify
private void rebalance(Node parent, Node node) {
if(node == null) {
return;
}
//Left
if(balance(node) > 1) {
//Handle Case III
if(balance(node.left) < 0) {
//leftrotation
node.left = leftRotation(node.left);
}
//right rotation
if(parent == null) {
root = rightRotation(node);
} else if(parent.left == node) {
parent.left = rightRotation(node);
} else {
parent.right = rightRotation(node);
}
//Right
} else if(balance(node) < -1) {
//Handle Case IV
if(balance(node.right) > 0) {
node.right = rightRotation(node.right);
}
//left rotation
if(parent == null) {
root = leftRotation(node);
} else if(parent.left == node) {
parent.left = leftRotation(node);
} else {
parent.right = leftRotation(node);
}
}
}
//Do Not Modify
private int balance(Node node) {
int diff = node.leftHeight - node.rightHeight;
return diff;
}
//Do Not Modify
private Node rightRotation(Node n) {
Node c = n.left;
Node t2 = c.right;
c.right = n;
n.left = t2;
fixHeight(n);
fixHeight(c);
return c;
}
//Do Not Modify
private Node leftRotation(Node n) {
Node c = n.right;
Node t2 = c.left;
c.left = n;
n.right = t2;
fixHeight(n);
fixHeight(c);
return c;
}
/***********STUDENT CODE******************/
//Final Part 2 Question.

public Set < T > outer() {
	  Set < T > nodeSet = new HashSet < > ();
	  if (root == null) {
	    return nodeSet;
	  }
	  outerLeft(root, nodeSet);
	  outerRight(root, nodeSet);
	  outerLeaf(root, nodeSet);
	  return nodeSet;
	}

	private void outerLeft(Node node, Set < T > outerLeft) {
	  while (node != null) {
	    outerLeft.add(node.data);
	    node = node.left;
	  }
	} //for left nodes

	private void outerRight(Node node, Set < T > outerRight) {
	  while (node != null) {
	    outerRight.add(node.data);
	    node = node.right;
	  }
	} //for right nodes

	private void outerLeaf(Node node, Set < T > outerLeaf) {
	  if (node == null) {
	    return;
	  } else {
	    outerLeaf(node.left, outerLeaf);
	    boolean isLeafNode = (node.left == null || node.right == null);
	    if (isLeafNode) {
	      outerLeaf.add(node.data);
	    }
	    outerLeaf(node.right, outerLeaf);
	  }
	}  //for blocked nodes
	
/****************************************/
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append("{ ");
if(!isEmpty()) {
Queue<Node> q = new LinkedList<>();
Node temp = root;
do {
sb.append(temp.data);
if(temp.left != null) {
q.add(temp.left);
}
if(temp.right != null) {
q.add(temp.right);
}
if(!q.isEmpty()) {
sb.append(", ");
temp = q.remove();
} else {
break;
}
}while(true);
}
sb.append(" }");
return sb.toString();
}
private class Node {
private Node left;
private Node right;
private int leftHeight;
private int rightHeight;
private T data;
public Node(T data) {
this.data = data;
}
}
}