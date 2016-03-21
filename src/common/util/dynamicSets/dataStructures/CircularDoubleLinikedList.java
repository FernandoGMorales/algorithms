package common.util.dynamicSets.dataStructures;

import java.util.Iterator;

/**
 * Unordered circular double linked list. Null items are allowed.
 * 
 * @author fernando
 *
 * @param <E>
 */
public class CircularDoubleLinikedList<E> implements Iterable<E> {
	
	private Node first;
	private Node last;
	private int N; // items in this list
	
	/**
	 * Appends item at the end of the list.
	 * @param item
	 */
	public void add(E item) {
		if(!isEmpty()) {
			if(N>1) {
				Node oldLast = last;
				last = new Node();
				last.item = item;
				last.next = first;
				last.prev = oldLast;
				first.prev = last;
				oldLast.next = last;
			}
			else {
				last = new Node();
				last.item = item;
				last.next = first;
				last.prev = first;
				first.prev = last;
				first.next = last;
			}
		}
		else {
			first = new Node();
			first.item = item;			
		}
		N++;
	}
	
	/**
	 * Insert a new item before the given one, if the given item is not found or the list is empty, the item is
	 * not added to the list.
	 */
	public void add(E newItem, E item) {		
		if(!isEmpty()) {
			Node node = first;	
			do {
				if(node.item.equals(item)) {
					Node newNode = new Node();
					newNode.item = newItem;
					newNode.prev = node.prev;
					newNode.next = node;
					newNode.prev.next = newNode;
					
					node.prev = newNode;				
					
					N++;
					break;
				}
				node = node.next;
			} while(node!=null && !node.equals(first));
		}		
	}

	/**
	 * Removes the given item of this list.
	 * @param item
	 */
	public void remove(E item) {
		if(!isEmpty()) {
			if(first.item.equals(item)) {
				removeFirst();
			}
			else if(last.item.equals(item)) {
				removeLast();
			}
			else {			
				Node node = first;	
				do {
					if(node.item.equals(item)) {
						Node prev = node.prev;
						Node next = node.next;
						prev.next = next;
						next.prev = prev;
						N--;
						break;
					}
					node = node.next;
				} while(!node.equals(first));
			}
		}
	}
	
	/**
	 * Removes the last element of this list
	 * 
	 */
	public void removeLast() {
		if(!isEmpty()) {
			if(last.equals(first)) {
				last = null;
				first = null;
			}
			else {
				last = last.prev;
				last.next = first;
			}			
			N--;
		}
	}
	
	/**
	 * Removes the first element of this list
	 * 
	 */
	public void removeFirst() {
		if(!isEmpty()) {
			if(first.equals(last)) {
				first = null;
				last = null;
			}
			else {
				first = first.next;
				first.prev = last;
				last.next = first;
			}
			N--;
		}
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return N==0;
	}

	private class Node {		
		private E item;
		private Node next;
		private Node prev;
	}
	
	public Iterator<E> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<E> {
		private Node current = first;		
		@Override
		public boolean hasNext() {
			return current!=null;
		}
		@Override
		public E next() {
			E item = (E)current.item;
			current = (current.next==null) ? null : (current.next.equals(first)) ? null : current.next;
			return item;
		}
	}
	
	public static void main(String[] args) {
		CircularDoubleLinikedList<Integer> list = new CircularDoubleLinikedList<>();
		StringBuilder sb = new StringBuilder();
		
		// case 1: add numbers 1 - 12		
		for(int i=1; i<=12; i++) {
			list.add(i);
		}
		for(int i : list) {
			sb.append(i);			
		}
		assert(sb.toString().equals("123456789101112"));
		assert(list.size()==12);
		
		// case 2: remove first element
		sb = new StringBuilder();
		list.removeFirst();
		for(int i : list) {
			sb.append(i);
		}
		assert(sb.toString().equals("23456789101112"));
		assert(list.size()==11);
		
		// case 3: remove last element
		sb = new StringBuilder();
		list.removeLast();
		for (int i : list) {
			sb.append(i);
		}
		assert(sb.toString().equals("234567891011"));
		assert(list.size()==10);
		
		// case 4: remove the given item
		sb = new StringBuilder();
		list.remove(7);
		for (int i : list) {
			sb.append(i);
		}
		assert(sb.toString().equals("23456891011"));
		assert(list.size()==9);
		
		// case 5: add an item before the given one
		sb = new StringBuilder();
		list.add(7, 8);
		for (int i : list) {
			sb.append(i);
		}
		assert(sb.toString().equals("234567891011"));
		assert(list.size()==10);
		
		// case 6: remove all elements
		for(int i : list) {
			list.remove(i);
		}
		assert(list.size()==0);
		
		// case 7: remove last element on an empty list
		list.removeLast();
		assert(list.size()==0);
		
		// case 7: remove first element on an empty list
		list.removeFirst();
		assert(list.size()==0);
		
		// case 8: remove the given item on an empty list
		list.remove(7);
		for (int i : list) {
			sb.append(i);
		}
		assert(list.size()==0);
		
		// case 9: add an item before the given one on an empty list
		sb = new StringBuilder();
		list.add(7, 8);
		for (int i : list) {
			sb.append(i);
		}
		assert(sb.toString().equals(""));
		assert(list.size()==0);

		// case 10: add an item on an empty list
		sb = new StringBuilder();
		list.add(100);
		for (int i : list) {
			sb.append(i);
		}
		assert(sb.toString().equals("100"));
		assert(list.size()==1);
		
		// case 10: add another item
		sb = new StringBuilder();
		list.add(101);
		for (int i : list) {
			sb.append(i);
		}
		assert(sb.toString().equals("100101"));
		assert(list.size()==2);
		
	}
	
}
