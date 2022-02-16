package main;

public class LinkedBagTest {
		
	
	public static void main(String[] args) {
	
		LinkedBag<String> str1 = new LinkedBag<>();
		LinkedBag<String> str2 = new LinkedBag<>();
		
		str2.add("a"); str2.add("a"); str2.add("a"); str2.add("b"); str2.add("c");
		str2.add("d"); str2.add("0"); str2.add("r"); str2.add("r"); str2.add("r");
		
		str1.add("a"); str1.add("a"); str1.add("b"); str1.add("b"); str1.add("c");
		str1.add("c"); str1.add("e"); str1.add("0"); str1.add("0"); str1.add("0");
		
		LinkedBag<String> union = (LinkedBag<String>) str1.union(str2);		
		
		Object[] printer = union.toArray();
		
		for (int i=0;i<printer.length;i++) {
			if ((i%15)==0) System.out.println("\n");
		System.out.print(printer[i] + ",");
		}
		
		System.out.println("\n----------------------------------");
		
		LinkedBag<String> intersect = (LinkedBag<String>) str1.intersection(str2);		
		
		Object[] printer1 = intersect.toArray();
		
		for (int i=0;i<printer1.length;i++) {
			if ((i%10)==0) System.out.println("\n");
			System.out.print(printer1[i] + ",");
		}
		
		System.out.println("\n----------------------------------");
		
		LinkedBag<String> difference = (LinkedBag<String>) str1.difference(str2);		
		
		Object[] printer2 = difference.toArray();
		
		for (int i=0;i<printer2.length;i++) {
			if ((i%10)==0) System.out.println("\n");
			System.out.print(printer2[i] + ",");
		}
		System.out.println("\n----------------------------------");

		
	}
	
}
