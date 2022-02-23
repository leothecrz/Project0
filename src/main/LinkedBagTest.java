package main;

public class LinkedBagTest {
	
	public static void main(String[] args) {
		
	 
		BagInterface<Object> test1 = new LinkedBag<>();
		BagInterface<Object> test2 = new LinkedBag<>();
		LinkedBag<Object> test3 = new LinkedBag<>();
		BagInterface<Object> test4 = new ResizableArrayBag<>();
		
		for (int i=0; i<10;i++) {
			test1.add(i);
		}
		for (int i=0; i<5;i++) {
			test2.add(i);
		}
		for (int i=5; i<10;i++) {
			test3.add(i);
		}
		
		BagInterface<Object> diff1 = test1.difference(test4);
		LinkedBag<Object> diff2 = (LinkedBag<Object>) test1.difference(test3);

		
		Object[] arrayprint = diff1.toArray();
		arrayprint.toString();
		Object[] arrayprint1 = diff2.toArray();
		arrayprint1.toString();
	}
	
	
}
