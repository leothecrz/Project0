package main;

public class LinkedBagTest {
		
	public static void main(String[] args) {
	
		LinkedBag<Integer> NumBag = new LinkedBag<>();
		LinkedBag<String> StrBag = new LinkedBag<>();
		
		
		NumBag.add(19);
		NumBag.add(2002);
		NumBag.add(14);
		NumBag.add(2007);
		StrBag.add("Davalos");
		StrBag.add("Leonardo");
		StrBag.add("Alondra");
		StrBag.add("Morales");
		
		Object[] namelist;
		namelist = StrBag.toArray();
		namelist.toString();
		
		Object[] AgeList = NumBag.toArray();
		AgeList.toString();
		
		
	}
	
}
