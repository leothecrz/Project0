package main;

/** OUTLINE
    A class of bags whose entries are stored in a chain of linked nodes.
    The bag is never full.
    @author Frank M. Carrano, Timothy M. Henry
    @version 5.0
*/
public class LinkedBag<T> implements BagInterface<T> {
	private Node firstNode;       // reference to first node
	private int numberOfEntries;

	public LinkedBag() {
		firstNode = null;
      numberOfEntries = 0;
	} // end default constructor

	public void DebugDump(Node Selected) {
		
		try { System.out.println(Selected.data); }
		catch (Exception nullPointerException) { System.out.println("Empty"); }
		
	}
	
	public boolean add(T newEntry) {
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;
		
		DebugDump(firstNode);
		firstNode = newNode;
		DebugDump(firstNode);
		numberOfEntries++;
		
		return true;
	}
	
	
	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	public T[] toArray() {
		
		@SuppressWarnings("unchecked")
		T[] array = (T[])new Object[this.numberOfEntries];
		
		int i = 0;
		Node currentNode = firstNode;
		while ((i < numberOfEntries) && (currentNode != null)) {
			array[i] = currentNode.data;
			i++;
			currentNode = currentNode.next;
		}
		
		return array;
	}

	
	public T union(T aBag) { // ######################################
		// TODO Auto-generated method stub
		return null;
	}

	
	public T intersection(T aBag) { // ######################################
		// TODO Auto-generated method stub
		return null;
	}

	
	public T difference(T aBag) { // ######################################
		// TODO Auto-generated method stub
		return null;
	}
	
	private class Node {
		private T    data; // Entry in bag
		private Node next; // Link to next node
      
		private Node(T dataPortion) { // Node Constructor when there is no NextNode
			this(dataPortion, null); 
		} // end constructor
		
		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		} // end constructor
		
	} // end Node
	
} // end LinkedBag
