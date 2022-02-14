package main;

public class LinkedBagTest {
		
	public static void main(String[] args) {
	
		LinkedBag<Integer> NumBag = new LinkedBag<>();
		LinkedBag<String> StrBag = new LinkedBag<>();
		
		
		NumBag.add(19);
		NumBag.add(19);
		NumBag.add(19);
		NumBag.add(19);
		NumBag.add(18);
		StrBag.add("Davalos1");
		StrBag.add("Davalos2");
		StrBag.add("Davalos3");
		StrBag.add("Davalos4");
		StrBag.add("Davalos5");
		StrBag.add("Davalos6");
		StrBag.add("Davalos7");
		StrBag.add("Davalos8");
		StrBag.add("Davalos9");

		StrBag.remove("Davalos7");
		
		Object[] nameList = StrBag.toArray();	
		Object[] ageList = NumBag.toArray();
		
		
		for ( int i = 0; i < nameList.length; i++) {
			System.out.println(i + ":" + nameList[i]);
		}
		
		
		System.out.println("Frequency:"+ StrBag.getFrequencyOf("Davalos1"));
		System.out.println(StrBag.contains("Davalos"));
		
		
		for ( int i = 0; i < ageList.length; i++) {
			System.out.println(i + ":" + ageList[i]);
		}
		
		System.out.println("Frequency:"+ NumBag.getFrequencyOf(19));
		System.out.println(NumBag.contains(18));
		
	}
	
}
