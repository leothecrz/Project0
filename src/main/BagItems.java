package main;

class BagItems{
	private String name;
	private double cost;
	
	
	public BagItems(String name, double cost) {
		this.name=name;
		this.cost=cost;
	}
	public BagItems() {
		this.name=null;
		this.cost=0;
	}
	@Override
	public String toString() {
		String out = name + ", $" + String.valueOf(cost);
		return out;
	}
	
}
