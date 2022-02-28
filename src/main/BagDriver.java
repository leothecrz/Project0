package main;

public class BagDriver {

	public static void main(String[] args) {
		
		
		// Character Linked Bag and Resizable Array
		BagInterface<Character> linkedBag = new LinkedBag<>();
		BagInterface<Character> arrayBag = new ResizableArrayBag<>();
		
		Character[] word1 = { 'B', 'A', 'N','K','S','$' };
		Character[] word0 = { 'V', 'A', 'U','L','T','S' };
		for (int i=0;i<word0.length;i++) {
			linkedBag.add(word0[i]);
			arrayBag.add(word1[i]);
		}
		
		BagInterface<Character> linkedUnionTest= linkedBag.union(arrayBag);
		printer(linkedUnionTest, "LinkedBag-UnionTest");
		BagInterface<Character> arrayUnionTest = arrayBag.union(linkedBag);
		printer(arrayUnionTest, "ResizableArray-UnionTest");
		 
		BagInterface<Character> linkedIntersectTest= linkedBag.intersection(arrayBag);
		printer(linkedIntersectTest, "LinkedBag-IntersectTest");
		BagInterface<Character> ArrayIntersectTest= arrayBag.intersection(linkedBag);
		printer(ArrayIntersectTest, "ResizableArray-IntersectTest");

		BagInterface<Character> linkedDifferenceTest= linkedBag.difference(arrayBag);
		printer(linkedDifferenceTest, "LinkedBag-DifferenceTest");
		BagInterface<Character> ArrayDifferenceTest= arrayBag.difference(linkedBag);
		printer(ArrayDifferenceTest, "ResizableArray-DifferenceTest");
		
		BagInterface<Integer> linkedBag1 = new LinkedBag<>();
		BagInterface<Integer> arrayBag1 = new ResizableArrayBag<>();
		
		Integer[] count0 = { 1,2,3,4,5,6,7,8,9,10 };
		Integer[] count1 = { 5,6,7,8,9,10,11,12,13,14,15 };
		for (int i=0;i<count0.length;i++) {
			linkedBag1.add(count0[i]);
			arrayBag1.add(count1[i]);
		}
		
		BagInterface<Integer> linkedUnionTest1= linkedBag1.union(arrayBag1);
		printer(linkedUnionTest1, "LinkedBag-UnionTest");
		BagInterface<Integer> arrayUnionTest1 = arrayBag1.union(linkedBag1);
		printer(arrayUnionTest1, "ResizableArray-UnionTest");
		 
		BagInterface<Integer> linkedIntersectTest1= linkedBag1.intersection(arrayBag1);
		printer(linkedIntersectTest1, "LinkedBag-IntersectTest");
		BagInterface<Integer> ArrayIntersectTest1 = arrayBag1.intersection(linkedBag1);
		printer(ArrayIntersectTest1, "ResizableArray-IntersectTest");

		BagInterface<Integer> linkedDifferenceTest1= linkedBag1.difference(arrayBag1);
		printer(linkedDifferenceTest1, "LinkedBag-DifferenceTest");
		BagInterface<Integer> ArrayDifferenceTest1= arrayBag1.difference(linkedBag1);
		printer(ArrayDifferenceTest1, "ResizableArray-DifferenceTest");
		
		
		
		
	}

	public static <T> void printer(BagInterface<T> aBag, String name) {
		Object[] print = aBag.toArray();
		System.out.print("\n "+name+ "["+(aBag.getCurrentSize())+"]: ");
		for(int i=0;i<print.length;i++) {
			if (i%10==0) System.out.print("\n");
			System.out.print(print[i] +", ");
		}
		System.out.println("\n==============================");
	}
	
}
