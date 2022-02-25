package main;

public class BagDriver {

	public static void main(String[] args) {
		
		// Resizable Array Methods have been commented out.
		
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
		//BagInterface<Character> arrayUnionTest = arrayBag.union(linkedBag);
		//printer(arrayUnionTest, "LinkedBag-UnionTest");
		 
		BagInterface<Character> linkedIntersectTest= linkedBag.intersection(arrayBag);
		printer(linkedIntersectTest, "LinkedBag-IntersectTest");
		//BagInterface<Character> ArrayIntersectTest= arrayBag.intersection(linkedBag);
		//printer(ArrayIntersectTest, "Array-IntersectTest");

		BagInterface<Character> linkedDifferenceTest= linkedBag.difference(arrayBag);
		printer(linkedDifferenceTest, "LinkedBag-DifferenceTest");
		//BagInterface<Character> ArrayDifferenceTest= arrayBag.difference(linkedBag);
		//printer(ArrayDifferenceTest, "Array-DifferenceTest");
		
		BagInterface<Character> linkedBag1 = new LinkedBag<>();
		BagInterface<Character> arrayBag1 = new ResizableArrayBag<>();
		
		
		
		
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
