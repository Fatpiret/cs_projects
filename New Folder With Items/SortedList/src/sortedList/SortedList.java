package sortedList;


public class SortedList<T extends Comparable<? super T>> {
    private Node<T> head;

    private int size;
    
//  //Fields
//	
    
//  	//Constructor
    public SortedList() {
        clear();
        
    }
    public boolean isEmpty() {
		return size == 0;
	}

    public void clear() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    
  

    public void add(T data) {
    	
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            size += 1;
            return;
        }
        Node<T> temp = head;
        Node<T> previous = null;
        while (temp != null && data.compareTo(temp.data) > 0) {
            previous = temp;
            temp = temp.next;
        }

        if (previous == null) {
            newNode.next = head;
            head = newNode;
        } else {
            newNode.next = temp;
            previous.next = newNode;
        }
        size += 1;
    }
    void reverseArray(int[] array){
    	int len = array.length;
    	for(int i = 0; i< len/2; i++){
    	int tmp = array[i];
    	array[i] = array[len - i - 1];
    	array[len - i - 1] = tmp;
    	}
    	}
    public T removeAt(int index) {
        if (head == null) {
            throw new EmptyCollectionException("Can't remove from an empty collection");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        Node<T> temp = head;
        Node<T> previous = null;
        for (int i = 0; i < index; i++) {
            previous = temp;
            temp = temp.next;
        }

        if (previous == null) {
            head = temp.next;
        } else {
            previous.next = temp.next;
        }
        size -= 1;
        return temp.data;
    }
    public T get(int index) {
        if (head == null) {
            throw new EmptyCollectionException("Can't remove from an empty collection");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }
    public boolean contains(T data) {
        return find(data) >= 0;
    }
    public int find(T data) {
        int index = 0;
        Node<T> temp = head;
        while (temp != null && data.compareTo(temp.data) > 0) {
            index++;
            temp = temp.next;
        }
        if (temp != null && data.equals(temp.data)) {
            return index;
        }
        return -1;
    }
    public int count(T data) {
        int count = 0;
        Node<T> temp = head;
        while (temp != null && data.compareTo(temp.data) >= 0) {
            if (data.equals(temp.data)) {
                count++;
            }
            temp = temp.next;
        }
        return count;
    }
    public void removeAll(SortedList<T> otherList) {
    	if(isEmpty()) {
			throw new EmptyCollectionException("Can't remove from an empty collection");
		}
        if (otherList == this) {
            clear();
        }
        Node<T> temp = head;
        Node<T> otherListtemp = otherList.head;
        Node<T> previous = null;
        
        while (temp != null && otherListtemp != null) {
            int cmp = temp.data.compareTo(otherListtemp.data);
            if (cmp < 0) {
                previous = temp;
                temp = temp.next;
            } else if (cmp == 0) {
                if (previous == null) {
                    head = temp.next;
                } else {
                    previous.next = temp.next;
                }
                temp = temp.next;
                size -= 1;
            } else {
                otherListtemp = otherListtemp.next;
            }
        }
    }
    public void reverse() {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    
   
  

    public String toString() {

 		StringBuffer sb = new StringBuffer();
 		sb.append("[");  
 		if(!isEmpty()) {
 			Node<T> temp = head;
 			for(int i = 0; i < size - 1; i++) {
 				sb.append(temp.data.toString());
 				sb.append(", ");
 				temp = temp.next;
 			}
 			sb.append(temp.data.toString());
 		}
 		sb.append("]");
 		return sb.toString();
 	}
 

    public static class Node<T> {
    	public T data;
    	public Node<T> next;
    	
    	public Node(T data) {
    		this.data = data;
    }
}
    }


