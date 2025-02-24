package test;


import integerSetBST.IntegerSet;



public class IntegerSetTest {

	
	public static void main(String[] args) {
        int[] array1 = {-1, 0, 1, 2, 3, 4};
        int[] array2 = {3, 4, 5, 6, 7};
        
        
        IntegerSet set1 = new IntegerSet(array1);
        IntegerSet set2 = new IntegerSet(array2);

        set1.add(-2);
        set2.remove(7);
        System.out.println("Tree 1:" + set1);
        System.out.println("Tree 2:" + set2);
        IntegerSet diffrence = set1.difference(set2);
        System.out.println("Diffrence: " + diffrence);
        IntegerSet union = set1.union(set2);
        System.out.println("Union: " + union);
        IntegerSet symmetricDiffrence = set1.symmetricDifference(set2);
        System.out.println("SymDiff: " + symmetricDiffrence);
        IntegerSet intersect = set1.intersection(set2);
        System.out.println("Intersection: " + intersect);
        System.out.println("Contains: " + union.contains(2));
        System.out.println("Getmax: " + union.getMax());
        System.out.println("Getmin: " + union.getMin());
		System.out.println("height: " + union.getHeight());
	//  i figured  to call union. instead of each set   
    }

}
