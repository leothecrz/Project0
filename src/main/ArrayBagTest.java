package main;

public class ArrayBagTest {

   public static void main(String[] args) {
		
		BagInterface<Integer> EvenIntBagArray = new ResizableArrayBag<>();
		for(int i=1;i<51;i++) {
			if (i%2==0) {
				EvenIntBagArray.add(i);
			}
		}
		BagInterface<Integer> OddIntBagArray = new ResizableArrayBag<>();
		for(int i=1;i<50;i++) {
			if (!(i%2==0)) {
				OddIntBagArray.add(i);
			}
		}
		printer(OddIntBagArray, "OddIntergerBag");
		printer(EvenIntBagArray, "EvenIntegerBag");
		
		BagInterface<Integer> oneToTwenty = OddIntBagArray.union(EvenIntBagArray);
		printer(oneToTwenty, "Union - Test1");
		OddIntBagArray.clear();
		EvenIntBagArray.clear();
		
		BagInterface<Integer> IntBag2 = new ResizableArrayBag<>();
		BagInterface<Integer> IntBag3 = new ResizableArrayBag<>();

		
		for(int i=0;i<20;i++) { // Contains 0 to 20
				IntBag2.add(i);
		}
		for(int i=0;i<20;i++) { // Contains odds from 0 to 20
			if (!(i%2==0)) {
				IntBag3.add(i);
			}
		}
		printer(IntBag2, "ZeroToNineteen");
		printer(IntBag3, "OddsZeroToTwenty");
		BagInterface<Integer> oneToTwentyIntersection = IntBag2.intersection(IntBag3);
		printer(oneToTwentyIntersection, "Intersection - Test2(ODDS)");
		BagInterface<Integer> oneToTwentyDifference = IntBag2.difference(IntBag3);
		printer(oneToTwentyDifference, "Difference - Test3(EVENS)");
		
		IntBag2.clear();
		IntBag3.clear();
		oneToTwenty.clear();
		oneToTwentyIntersection.clear();
		oneToTwentyDifference.clear();
		
		Character[] charBank = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
		BagInterface<Character> CharBag2 = new ResizableArrayBag<>();
		for(int i=0; i<charBank.length;i++) {
			CharBag2.add(charBank[i]);
		}
		BagInterface<Character> CharBag3 = new ResizableArrayBag<>();
		for (int j=0;j<3;j++) {
			for(int i=0; i<charBank.length;i++) {
				CharBag3.add(charBank[i]);
			}
		}
		
		printer(CharBag2, "AtoI");
		printer(CharBag3, "3AtoI");

		BagInterface<Character> CharIntersect = CharBag2.intersection(CharBag3);
		printer(CharIntersect, "Intersection - Test4");
		BagInterface<Character> CharDifference = CharBag2.difference(CharBag3);
		printer(CharDifference, "Difference - Test5");
		BagInterface<Character> CharDifference1 = CharBag2.difference(CharBag3);
		printer(CharDifference1, "Difference - Test6");
		
		BagInterface<Object> MixedBag = new ResizableArrayBag<>();
			MixedBag.add(0);
			MixedBag.add("Hello World!");
			MixedBag.add('a');
			MixedBag.add(4.15);
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
