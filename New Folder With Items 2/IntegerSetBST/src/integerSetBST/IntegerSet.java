package integerSetBST;

public class IntegerSet {

	  private Node root;
	  private int size;
	  public IntegerSet() {
		    root = null;
		  }

		  public IntegerSet(int[] array) {
		    root = null;
		    for (int i: array) {
		      add(i);
		    }
		  }
	  public int magnitude() {
	    return size;
	  }
	  public void clear() {
	    root = null;
	    size = 0;
	  }
	  public boolean isEmpty() {
	    return size == 0;
	  }

	  public boolean add(int newItem) {
	    if (contains(newItem)) {
	      return false;
	    }
	    root = add(root, newItem);
	    return true;
	  }

	  private Node add(Node node, int newItem) {
	    boolean added = false;

	    if (isEmpty()) {
	      root = new Node(newItem);
	    }
	    if (node == null) {
	      return new Node(newItem);
	    }
	    if (newItem < node.data) {
	      node.leftChild = add(node.leftChild, newItem);
	    } else {
	      node.rightChild = add(node.rightChild, newItem);
	    }

	    fixHeight(node);

	    if (added) {
	      rebalance(node.leftChild, node.rightChild);
	    }

	    size += 1;
	    return node;
	  }

	  public boolean remove(int ItemToRemove) {
	    if (isEmpty()) {
	      throw new EmptyCollectionException("Can't Remove from an Empty Tree");
	    }
	    if (!contains(ItemToRemove)) {
	      return false;
	    }
	    root = remove(root, ItemToRemove);
	    return true;
	  }

	  private Node remove(Node node, int ItemToRemove) {
	    if (node == null) {
	      return null;
	    }
	    if (ItemToRemove < node.data) {
	      node.leftChild = remove(node.leftChild, ItemToRemove);
	    } else if (ItemToRemove > node.data) {
	      node.rightChild = remove(node.rightChild, ItemToRemove);
	    } else {
	      if (node.leftChild == null) {
	        return node.rightChild;
	      }
	      if (node.rightChild == null) {
	        return node.leftChild;
	      }
	      Node temp = node.rightChild;
	      while (temp.leftChild != null) {
	        temp = temp.leftChild;
	      }
	      node.data = temp.data;
	      node.rightChild = remove(node.rightChild, temp.data);
	    }
	    fixHeight(node);
	    if (remove(0)) {
	      rebalance(node, node);
	    }
	    size -= 1;
	    return node;
	  }

	  public boolean contains(int itemToFind) {
	    return contains(itemToFind, root);
	  }

	  private boolean contains(int itemToFind, Node node) {
	    if (node == null) {
	      return false;
	    } else if (itemToFind < node.data) {
	      return contains(itemToFind, node.leftChild);
	    } else if (itemToFind > node.data) {
	      return contains(itemToFind, node.rightChild);
	    } else {
	      return true;
	    }
	  }

	  public int getMin() {
	    if (root == null) {
	      throw new ElementDoesNotExistException("Set is empty");
	    }
	    Node node = root;
	    while (node.leftChild != null) {
	      node = node.leftChild;
	    }
	    return node.data;
	  }

	  public int getMax() {
	    if (root == null) {
	      throw new ElementDoesNotExistException("Set is empty");
	    }
	    Node node = root;
	    while (node.rightChild != null) {
	      node = node.rightChild;
	    }
	    return node.data;
	  }

	  public IntegerSet union(IntegerSet other) {
	    IntegerSet result = new IntegerSet();
	    addElementsToSet(result, this.root);
	    addElementsToSet(result, other.root);
	    return result;
	  }

	  private void addElementsToSet(IntegerSet set, Node node) {
	    if (node != null) {
	      set.add(node.data);
	      addElementsToSet(set, node.leftChild);
	      addElementsToSet(set, node.rightChild);
	    }
	  }
	  public IntegerSet intersection(IntegerSet other) {
	    IntegerSet result = new IntegerSet();
	    addCommonElementsToSet(result, this.root, other);
	    return result;
	  }

	  private void addCommonElementsToSet(IntegerSet set, Node node,
	    IntegerSet other) {
	    if (node != null) {
	      if (other.contains(node.data)) {
	        set.add(node.data);
	      }
	      addCommonElementsToSet(set, node.leftChild, other);
	      addCommonElementsToSet(set, node.rightChild, other);
	    }
	  }

	  private void inorder(Node current, StringBuffer sb) {
	    if (current != null) {
	      inorder(current.leftChild, sb);
	      if (current.leftChild != null) {
	        sb.append(" , ");
	      }
	      sb.append(current.data);
	      if (current.rightChild != null) {
	        sb.append(" , ");
	      }
	      inorder(current.rightChild, sb);

	    }
	  }

	  public IntegerSet difference(IntegerSet other) {
	    IntegerSet result = new IntegerSet();
	    difference(root, other.root, result);
	    return result;
	  }

	  private void difference(Node node, Node other, IntegerSet result) {
	    if (node != null && other != null) {
	      if (node.data < other.data) {
	        result.add(node.data);
	        difference(node.rightChild, other, result);
	        difference(node.leftChild, other, result);
	      } else if (node.data > other.data) {
	        difference(node, other.rightChild, result);
	      } else {
	        difference(node.leftChild, other.leftChild, result);
	        difference(node.rightChild, other.rightChild, result);
	      }
	    } else if (node != null) {
	      result.add(node.data);
	      difference(node.leftChild, null, result);
	      difference(node.rightChild, null, result);
	    }
	  }

	  public IntegerSet symmetricDifference(IntegerSet other) {
	    IntegerSet result = new IntegerSet();
	    if (root == null && other.root == null) {
	      return result;
	    } else if (root == null) {
	      return new IntegerSet(other.toArray());
	    } else if (other.root == null) {
	      return new IntegerSet(toArray());
	    }
	    Node node = root;
	    while (node != null) {
	      if (!other.contains(node.data)) {
	        result.add(node.data);
	      }
	      node = node.rightChild;
	    }
	    Node otherNode = other.root;
	    while (otherNode != null) {
	      if (!contains(otherNode.data)) {
	        result.add(otherNode.data);
	      }
	      otherNode = otherNode.rightChild;
	    }
	    return result;
	  }
	  private Node rightRotation(Node n) {
	    Node c = n.leftChild;
	    Node t2 = c.rightChild;

	    c.rightChild = n;
	    n.leftChild = t2;

	    fixHeight(n);
	    fixHeight(c);

	    return c;

	  }
	  private Node leftRotation(Node n) {
	    Node c = n.rightChild;
	    Node t2 = c.leftChild;

	    c.leftChild = n;
	    n.rightChild = t2;

	    fixHeight(n);
	    fixHeight(c);

	    return c;
	  }
	  private void rebalance(Node parent, Node node) {
	    if (node == null) {
	      return;
	    }
	    if (balance(node) > 1) {
	      if (balance(node.leftChild) < 0) {
	        node.leftChild = leftRotation(node.leftChild);

	      }
	      if (parent == null) {
	        root = rightRotation(node);
	      } else if (parent.leftChild == node) {
	        parent.leftChild = rightRotation(node);
	      } else {
	        parent.rightChild = rightRotation(node);
	      }
	    } else if (balance(node) < -1) {
	      if (balance(node.rightChild) > 0) {
	        node.rightChild = rightRotation(node.rightChild);
	      }
	      if (parent == null) {
	        root = leftRotation(node);
	      } else if (parent.leftChild == node) {
	        parent.leftChild = leftRotation(node);
	      } else {
	        parent.rightChild = leftRotation(node);
	      }
	    }
	  }
	  private int balance(Node node) {
	    return node.leftHeight - node.rightHeight;
	  }
	  public int getHeight() {
	    return getHeight(root) - 1;

	  }
	  public int getHeight(int Subtree) {
	    Node sub = getNode(Subtree);
	    if (sub == null) {
	      String errMsg = String.format("The items to remove %s does not exist.", Subtree);
	      throw new ElementDoesNotExistException(errMsg);

	    }
	    return getHeight(sub) - 1;
	  }
	  private Node getNode(int subtree) {
	    return null;
	  }
	  public int getHeight(Node current) {
	    if (current == null) {
	      return 0;
	    } else {
	      int leftSubtree = 1 + getHeight(current.leftChild);
	      int rightSubtree = 1 + getHeight(current.rightChild);
	      return leftSubtree > rightSubtree ? leftSubtree : rightSubtree;

	    }
	  }
	  private void fixHeight(Node node) {
	    if (node != null) {
	      node.leftHeight = getHeight(node.leftChild) + 1;
	      node.rightHeight = getHeight(node.rightChild) + 1;

	    }
	  }

	  public String toString() {
	    StringBuffer sb = new StringBuffer();
	    sb.append("[ ");
	    inorder(root, sb);
	    sb.append(" ]");
	    return sb.toString();
	  }

	  private int[] toArray() {
	    return null;
	  }
	  private class Node {
	    public int leftHeight;
	    public int rightHeight;
	    int data;
	    Node leftChild;
	    Node rightChild;

	    public Node(int data) {
	      this.data = data;
	    }
	  }

	}