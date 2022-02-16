package main;

public class LinkedBagTest {
	
	public static void main(String[] args) {
		
		LinkedBag<BagItems> bag1 = new LinkedBag<>();
		LinkedBag<BagItems> bag2 = new LinkedBag<>();
		
		BagItems iA = new BagItems("Shoes", 75.00);
		BagItems iB = new BagItems("TextBook", 135.00);
		BagItems iC = new BagItems("Notebooks", 1.20);
		BagItems iD = new BagItems("Backpack", 35.00);
		BagItems iE = new BagItems("Laptop", 185.00);
		BagItems iF = new BagItems("Calculators", 65.00);
		BagItems iG = new BagItems("Markers", 12.00);
		
		bag1.add(iA);
		bag1.add(iB);
		bag1.add(iC);
		bag1.add(iD);
		bag1.add(iD);
		bag1.add(iE);
		bag1.add(iE);
		
		bag2.add(iD);
		bag2.add(iD);
		bag2.add(iD);
		bag2.add(iE);
		bag2.add(iF);
		bag2.add(iG);
		
		LinkedBag<BagItems> uBag = (LinkedBag<BagItems>) bag1.union(bag2);
		LinkedBag<BagItems> iBag = (LinkedBag<BagItems>) bag1.intersection(bag2);
		LinkedBag<BagItems> dBag = (LinkedBag<BagItems>) bag1.difference(bag2);
		LinkedBag<BagItems> dBag1 = (LinkedBag<BagItems>) bag2.difference(bag1);

		
		printBag("Cart 1", bag1);
		printBag("Cart 2", bag2);
		
		printBag("1 Union 2", uBag);
		printBag("1 Intersect 2", iBag);
		printBag("1 Difference 2", dBag);
		printBag("2 Difference 1", dBag1);
		
	}
	
	@SuppressWarnings("rawtypes")
	public static void printBag(String name, LinkedBag bag) {
		Object[] bagA = bag.toArray();
		System.out.println(name +": ==============================");
		for (int i=0;i<bagA.length;i++) {
			System.out.println("[" + bagA[i].toString() + "], ");
		}
		System.out.println("======================================");
	}
}
