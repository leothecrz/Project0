package main;

public class LinkedBagTest {
		
	public static void main(String[] args) {
	
		LinkedBag<Integer> NumBag = new LinkedBag<>();
		LinkedBag<String> StrBag = new LinkedBag<>();
		
		System.out.println(StrBag.add("Leo"));
		System.out.println(StrBag.add("Leo"));
		System.out.println(StrBag.add("Leo"));
		System.out.println(StrBag.add("Leo"));
		System.out.println(StrBag.add("Lo"));
		System.out.println(StrBag.add("eo"));
		System.out.println(StrBag.add("Le"));
		System.out.println(StrBag.add("Le2o"));

		
		System.out.println(StrBag.contains("Leo"));
		System.out.println(StrBag.getFrequencyOf("Leo"));
		StrBag.clear();
		System.out.println(StrBag.contains("Leo"));
		StrBag.add("Leo");
		System.out.println(StrBag.getCurrentSize());
		StrBag.remove();
		StrBag.add("Leonardo Davalos");
		
		Object[] strBag = StrBag.toArray();
		
		for (int i = 0; i < strBag.length; i++) {
			System.out.println(strBag[i]);
		}
		
		
	}
	
}
