package integerSet;

public class IntegerSet {  // The array that represents the set
	private final int set[];
	public IntegerSet() {
	set = null;
	}

	 /**
     * The constructor for IntegerSet. When an IntegerSet is created it must be
     * initialized with an integer array. The set will then pull out the duplicated
     * items and keep the unique integers.
     * 
     * @param arr
     *            The array to create the set from.
     */

	public IntegerSet(int arr[]) {		
	  if (arr == null) {
	throw new IllegalArgumentException("The array must not be null");
	}
	set = uniqueElements(arr);
	}

	 /**
     * This is the size of the set which, in this case, is just the length of the
     * array.
     * 
     * @return The length of the set.
     */

	public int magnitude() {
		return set.length;
	}

	/**
     * This method is private and is used to help set up the set array. An integer
     * set is one in which the elements are unique (no duplicates) and are sorted.
     * 
     * @param arr
     *            The array that will be used to retrieve the unique elements from.
     * @return The new integer array that contains the unique elements from arr.
     */

	private int[] uniqueElements(int arr[]) {
		  int uniqueList[] = new int[arr.length];
		  int uniqueCount = 0;
		  boolean found = false;
		  for (int i = 0; i < arr.length; i++) {
		    found = false;
		    for (int j = 0; j < uniqueCount; j++) {
		      if (arr[i] == uniqueList[j]) {
		        found = true;
		        break;
		      }
		    }
		    if (found) {
		      continue;
		    } else {
		      uniqueList[uniqueCount] = arr[i];
		      uniqueCount++;
		    }
		  }
		  int[] uniqueSet = new int[uniqueCount];
		  for (int i = 0; i < uniqueCount; i++) {
		    uniqueSet[i] = uniqueList[i];
		  }
		  for (int i = 0; i < uniqueCount; i++) {
		    for (int j = i + 1; j < uniqueCount; j++) {
		      if (uniqueSet[i] > uniqueSet[j]) {
		        int temp = uniqueSet[i];
		        uniqueSet[i] = uniqueSet[j];
		        uniqueSet[j] = temp;
		      }
		    }
		  }
		  return uniqueSet;
		}
	/**
     * This method returns whether or not value is located in the set. If the value
     * is in the set then return true otherwise return false. <br />
     * Example:
     * <pre>
     * 		IntegerSet iS1 = new IntegerSet([1,2,3,4]); 
     * 		iS1.contains(3); //returns true
     * 		iS2.contains(6); //returns false
     * </pre>
     * 
     * @param value
     *            The integer to look for.
     * @return True if value is located in the set otherwise false.
     */

	public boolean contains(int value) {
		  for (int i = 0; i < set.length; i++) {
		    if (set[i] == value) {
		      return true;
		    }
		  }
		  return false;
		}

	 /**
     * A union of two sets is a new set that contains all elements from both sets.
     * This method takes another set and unions it with the set that calls this
     * method. A new IntegerSet is returned that contains the union of both sets.<br />
     * Example:
     * <pre>
     * 		IntegerSet is1 = new IntegerSet([1, 2, 3, 4]); 
     * 		IntegerSet is2 = new IntegerSet([3, 4, 5, 6, 7, 8]);
     * 		is1.union(is2) //returns new IntegerSet([1, 2, 3, 4, 5, 6, 7, 8]);
     * </pre>
     * 
     * @param otherSet
     *            The set to be unioned with.
     * @return A new IntegerSet that is the union of the calling set with the
     *         otherSet.
     */

	public IntegerSet union(IntegerSet otherSet) {
		  int t[] = new int[set.length + otherSet.set.length];
		  int k = 0;
		  for (int count = 0; count < set.length; count++, k++)
		    t[k] = set[count];
		  for (int count = 0; count < otherSet.set.length; count++, k++)
		    t[k] = otherSet.set[count];
		  IntegerSet temp = new IntegerSet(t);
		  return temp;
		}
	 /**
     * The intersection of two sets is a new set that contains elements that occur
     * in both sets. This method takes another set and intersects it with the set
     * that calls this method. A new IntegerSet is returned that contains the
     * intersection of the two sets. <br />
     * Example:
     * <pre>
     * 		IntegerSet is1 = new IntegerSet([1,2,3,4]);
     * 		IntegerSet is2 = new IntegerSet([3,4,5]);
     * 		is1.intersection(is2) //returns new IntegerSet([3, 4]);
     * </pre>
     * 
     * @param otherSet
     *            The set to be intersected with.
     * @return A new IntegerSet that is the intersection of the calling set with the
     *         otherSet.
     */

	public IntegerSet intersection(IntegerSet otherSet) {
		  int t[] = new int[set.length];
		  int count = 0;
		  for (int i = 0; i < set.length; i++) {
		    for (int j = 0; j < otherSet.set.length; j++) {
		      if (set[i] == otherSet.set[j]) {
		        t[count] = set[i];
		        count++;
		        break;
		      }
		    }
		  }
		  int t1[] = new int[count];
		  for (int i = 0; i < count; i++)
		    t1[i] = t[i];
		  IntegerSet temp = new IntegerSet(t1);
		  return temp;
		}
	 /**
     * Returns a string representation of an IntegerSet type. The returned string
     * will have the following structure.
     * 
     * set{ elements in the set separated by a comma }.
     */
	public String toString() {
		  StringBuilder sb = new StringBuilder();
		  sb.append("set{ ");
		  for (int i = 0; i < set.length; i++) {
		    sb.append(set[i]);
		    if (i < set.length - 1) {
		      sb.append(", ");
		    }
		  }
		  sb.append(" }");
		  return sb.toString();
		}

//		public static void main(String[] args) {
//			IntegerSet iS1 = new IntegerSet(new int[]{2,4,1,3});
//			IntegerSet iS2 = new IntegerSet(new int[]{3,7,4,6,5});
//			System.out.println("Set1 : "+iS1.toString());
//			System.out.println("Set2 : "+iS2.toString());
////			System.out.println("iS1.contains(1) : "+iS1.contains(3));//just to see if returns true
//			System.out.println("iS1.contains(6) : "+iS1.contains(6));
//			System.out.println("Union : "+iS1.union(iS2));
//			System.out.println("Intersection : "+iS1.intersection(iS2));

			 // }

			}

