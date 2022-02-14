package main;

public class Node<T> {
	private T data;
	private Node<T> next;
	
	Node(T data, Node<T> next){
		this.data = data;
		this.next = next;
	}
	Node(T data){
		this(data, null);
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T newData) {
		data = newData;
	}
	
	public Node<T> getNextNode(){
		return next;
	}
	
	public void setNextNode(Node<T> newNext) {
		next = newNext;
	}
	
}
