package main;

public class LinkedBagTest {
	
	public static void main(String[] args) {
		
		BagInterface<Integer> OddIntBag = new LinkedBag<>();
		for(int i=1;i<51;i++) {
			if (i%2==0) {
				OddIntBag.add(i);
			}
		}
		BagInterface<Integer> EvenIntBag = new LinkedBag<>();
		for(int i=1;i<50;i++) {
			if (!(i%2==0)) {
				EvenIntBag.add(i);
			}
		}
		printer(OddIntBag, "OddIntergerBag");
		printer(EvenIntBag, "EvenIntegerBag");
		
		BagInterface<Integer> oneToTwenty = OddIntBag.union(EvenIntBag);
		printer(oneToTwenty, "Union - Test1");
		OddIntBag.clear();
		EvenIntBag.clear();
		
		BagInterface<Integer> IntBag0 = new LinkedBag<>();
		BagInterface<Integer> IntBag1 = new LinkedBag<>();

		
		for(int i=0;i<20;i++) { // Contains 0 to 20
				IntBag0.add(i);
		}
		for(int i=0;i<20;i++) { // Contains odds from 0 to 20
			if (!(i%2==0)) {
				IntBag1.add(i);
			}
		}
		printer(IntBag0, "ZeroToNineteen");
		printer(IntBag1, "OddsZeroToTwenty");
		BagInterface<Integer> oneToTwentyIntersection = IntBag0.intersection(IntBag1);
		printer(oneToTwentyIntersection, "Intersection - Test2(ODDS)");
		BagInterface<Integer> oneToTwentyDifference = IntBag0.difference(IntBag1);
		printer(oneToTwentyDifference, "Difference - Test3(EVENS)");
		
		IntBag0.clear();
		IntBag1.clear();
		oneToTwenty.clear();
		oneToTwentyIntersection.clear();
		oneToTwentyDifference.clear();
		
		Character[] charBank = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
		BagInterface<Character> CharBag0 = new LinkedBag<>();
		for(int i=0; i<charBank.length;i++) {
			CharBag0.add(charBank[i]);
		}
		BagInterface<Character> CharBag1 = new LinkedBag<>();
		for (int j=0;j<3;j++) {
			for(int i=0; i<charBank.length;i++) {
				CharBag1.add(charBank[i]);
			}
		}
		
		printer(CharBag0, "AtoI");
		printer(CharBag1, "3AtoI");

		BagInterface<Character> CharIntersect = CharBag0.intersection(CharBag1);
		printer(CharIntersect, "Intersection - Test4");
		BagInterface<Character> CharDifference = CharBag0.difference(CharBag1);
		printer(CharDifference, "Difference - Test5");
		BagInterface<Character> CharDifference1 = CharBag1.difference(CharBag0);
		printer(CharDifference1, "Difference - Test6");
		
		BagInterface<Object> MixedBag = new LinkedBag<>();
			MixedBag.add(0);
			MixedBag.add("Hello World!");
			MixedBag.add('a');
			MixedBag.add(4.15);
			Node<Object> nameNode = new Node<>("Leo");
			Node<Object> nameNode1 = new Node<>("D", nameNode);
			MixedBag.add(nameNode);
			MixedBag.add(nameNode1);
			MixedBag.add(.09221234);
			MixedBag.add("CS2400");
			MixedBag.add('L');
			MixedBag.add(55);
		
		printer(MixedBag, "MixedBagTest");
		
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
