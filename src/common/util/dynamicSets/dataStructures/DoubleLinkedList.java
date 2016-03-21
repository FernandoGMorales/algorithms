package common.util.dynamicSets.dataStructures;

import java.util.Iterator;

/**
 * Unordered double linked list. Null items are allowed.
 * It can be used as a stack or queue.
 * Insert/remove operations at the begining/end are done in O(1) time 
 * 
 * @author fernando
 *
 */
public class DoubleLinkedList<E> implements Iterable<E> {
	
	private Node first;
	private Node last;
	private int N;
	
	/**
	 * Adds an item at the begining of the list
	 * @param item
	 */
	public void addFirst(E item) {
		if(!isEmpty()) {
			Node oldFirst = first;
			first = new Node();
			first.item = item;
			first.next = oldFirst;
			if(last==null) {
				addLastNode(oldFirst.item);
			}
			else {
				oldFirst.prev = first;
				N++;
			}
		}
		else {
			addFirstNode(item);
		}
	}
	
	/**
	 * Adds an item at the end of the list
	 * @param item
	 */
	public void addLast(E item) {
		if(!isEmpty()) {
			if(last!=null) {
				Node oldLast = last;
				last = new Node();
				last.item = item;
				last.prev = oldLast;
				oldLast.next = last;
				N++;
			}
			else {
				addLastNode(item);
			}
		}
		else {
			addFirstNode(item);
		}
	}
	
	/**
	 * Adds an item before the given one, if currentItem is not found, the newItem is not added to the list
	 * @param item
	 */
	public void add(E newItem, E currentItem) {
		if(!isEmpty()) {
			Node node = first;
			do {
				if(node.item.equals(currentItem)) {
					if(node.equals(first)) {
						addFirst(newItem);
					}
					else {
						Node oldNode = node;
						Node prev = node.prev;
						node = new Node();
						node.item = newItem;
						node.next = oldNode;
						node.prev = prev;
						prev.next = node;
						oldNode.prev = node;
						N++;
					}					
					break;
				}
				node = node.next;
			} while(node!=null);			
		}		
	}
	
	private void addFirstNode(E item) {
		first = new Node();
		first.item = item;
		N++;
	}
	
    private void addLastNode(E item) {
    	last = new Node();
		last.item = item;
		last.prev = first;
		first.next = last;
		N++;
	}
	
    public E removeFirst() {
    	E item = null;
    	if(!isEmpty()) {
    		item = first.item;
    		if(last!=null) {
    			if(first.next==last) {
    				first = last;
    				last.prev = null;
    				last = null;
    			}
    			else {
    				first = first.next;
            		first.prev = null;
    			}        		
    		}
    		else {
    			first = null;
    		}
    		N--;    		
    	}
    	return item;
    }
    
    /**
     * Removes the last element in this list. 
     * It is not recommended to use this method within the ListIterator iterator!
     * 
     * @return
     */
	public E removeLast() {
		E item = null;
		if(!isEmpty()) {
    		if(last!=null) {
    			item = last.item;
    			if(!last.prev.equals(first)) {
    				last = last.prev;
        			last.next = null;
    			}
    			else {
    				last = null;
    				first.next = null;
    			}
    		}
    		else {
    			item = first.item;
    			first = null;    			
    		}
    		N--;
    	}
		return item;
	}
	
	/**
	 * Removes the given item of this list.
	 * 
	 */
	public void remove(E item) {
		if(!isEmpty()) {
			Node node = first;
			do {
				if(node.item.equals(item)) {
					if(node.equals(first)) {
						removeFirst();						
					}
					else if(node.equals(last)) {
						removeLast();
					}
					else {
						Node prev = node.prev;
						Node next = node.next;
						prev.next = next;
						next.prev = prev;
						N--;
					}
					break;
				}
				node = node.next;
			} while(node!=null);			
		}
	}
    
	public boolean isEmpty() {
		return N==0;
	}
	
	public int size() {
		return N;
	}
	
	private class Node {		
		private E item;
		private Node next;
		private Node prev;				
	}

	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<E> {
		
		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public E next() {
			E item = current.item;
			current = current.next;
			return item;
		}
	}
	
	public static void main(String[] args) {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		
		// case 1: add 1 to 12 numbers
		for(int i=1; i<13; i++) {
			list.addLast(i);
		}
		assert(list.size()==12);
		for(int i : list) {
			sb.append(i);
		}
		assert(sb.toString().equals("123456789101112"));
		
		// case 2: add 1 to 12 numbers by inserting at the begining of the list
		list = new DoubleLinkedList<Integer>();
		sb = new StringBuilder();
		for (int i = 1; i < 13; i++) {
			list.addFirst(i);
		}
		assert (list.size() == 12);
		for (int i : list) {
			sb.append(i);
		}
		assert (sb.toString().equals("121110987654321"));
		
		// case 3: remove the last element of the list
		sb = new StringBuilder();
		list.removeLast();
		assert( list.size() == 11);
		for(int i : list) {
			sb.append(i);
		}
		assert(sb.toString().equals("12111098765432"));
		
		// case 4: remove the first element of this list
		sb = new StringBuilder();
		int item = list.removeFirst();
		assert(item==12);
		assert( list.size() == 10);
		for(int i : list) {
			sb.append(i);
		}
		assert(sb.toString().equals("111098765432"));
		
		// case 5: remove the given item of this list
		sb = new StringBuilder();
		list.remove(7);
		assert( list.size() == 9);
		for(int i : list) {
			sb.append(i);
		}
		assert(sb.toString().equals("11109865432"));
		
		// case 6: remove the first item on an empty list
		list = new DoubleLinkedList<Integer>();
		sb = new StringBuilder();
		assert(list.removeFirst()==null);
		assert( list.size() == 0);
		for(int i : list) {
			sb.append(i);
		}
		assert(sb.toString().equals(""));
		
		// case 7: remove the last item on an empty list
		assert (list.removeLast() == null);
		assert (list.size() == 0);
		for (int i : list) {
			sb.append(i);
		}
		assert (sb.toString().equals(""));
		
		// case 8: remove the last item on a list with just one item
		list.addFirst(88);
		assert(list.size()==1);
		list.removeLast();
		assert(list.size()==0);
		
		// case 9: remove the last item on a list with just two items
		list.addFirst(88);
		list.addFirst(89);
		assert (list.size() == 2);
		list.removeLast();
		assert (list.size() == 1);
		
		// case 10: remove the first item on a list with just one item
		list = new DoubleLinkedList<Integer>();
		list.addLast(88);
		assert (list.size() == 1);
		list.removeFirst();
		assert (list.size() == 0);
		
		// case 11: remove the first item on a list with just two items
		sb = new StringBuilder();
		list.addLast(100);
		list.addLast(101);
		assert (list.size() == 2);
		for(int i : list) {
			sb.append(i);
		}
		assert(sb.toString().equals("100101"));
		item = list.removeFirst();
		assert (item==100);
		assert (list.size() == 1);
		
		// case 12: remove the given item on a list with two items (the item is in the list)
		list = new DoubleLinkedList<Integer>();
		sb = new StringBuilder();
		list.addLast(300);
		list.addLast(301);
		assert (list.size() == 2);
		list.remove(301);
		assert (list.size() == 1);
		for (int i : list) {
			sb.append(i);
		}
		assert(sb.toString().equals("300"));
		
		// case 13: remove the given item on a list with just one item (the item is in the list) TODO
		list = new DoubleLinkedList<Integer>();
		sb = new StringBuilder();
		list.addLast(400);
		assert (list.size() == 1);
		list.remove(400);
		assert (list.size() == 0);
		
		// case 14: add an item before the given one on a list with one item (the item is in the list)
		list = new DoubleLinkedList<Integer>();
		sb = new StringBuilder();
		list.addFirst(101);
		assert (list.size() == 1);
		list.add(102, 101);
		for(int i : list) {
			sb.append(i);
		}
		assert(list.size()==2);
		assert (sb.toString().equals("102101"));
		
		// case 15: add an item before the given one on a list with one item (the item is not the given one)
		list = new DoubleLinkedList<Integer>();
		sb = new StringBuilder();
		list.addFirst(103);
		assert (list.size() == 1);
		list.add(102, 101);
		for (int i : list) {
			sb.append(i);
		}
		assert (list.size() == 1);
		assert (sb.toString().equals("103"));
		
		// case 16: add an item before the given one on a list with two items (the item is in the list).
		list = new DoubleLinkedList<Integer>();
		sb = new StringBuilder();
		list.addFirst(105);
		list.addLast(103);
		assert (list.size() == 2);
		list.add(104, 103);
		for (int i : list) {
			sb.append(i);
		}
		assert (list.size() == 3);
		assert (sb.toString().equals("105104103"));
		
		// case 17: add items alternating first and last insertions
		list = new DoubleLinkedList<Integer>();
		sb = new StringBuilder();
		for(int i=100; i<1000; i+=100) {
			if((i/100)%2==0) list.addLast(i);
			else list.addFirst(i);
		}
		assert(list.size()==9);
		for(int i : list) {
			sb.append(i);
		}
		assert(sb.toString().equals("900700500300100200400600800"));
		
		// case 18: remove the given item
		list = new DoubleLinkedList<Integer>();
		sb = new StringBuilder();
		for (int i=1; i<10; i++) {
			list.addLast(i);
		}
		assert (list.size()==9);
		for (int i : list) {
			sb.append(i);
		}
		assert(sb.toString().equals("123456789"));
		list.remove(7);
		sb = new StringBuilder();
		for (int i : list) {
			sb.append(i);
		}
		assert(list.size()==8);
		assert(sb.toString().equals("12345689"));
		
		// case 19: remove all the given items 
		list = new DoubleLinkedList<Integer>();
		sb = new StringBuilder();
		for (int i=1; i<10; i++) {
			list.addLast(i);
		}
		assert (list.size()==9);
		for (int i : list) {
			sb.append(i);
		}
		assert(sb.toString().equals("123456789"));
		for(int i : list) {
			list.remove(i);
		}
		assert(list.size()==0);
		
		// case 20: remove all items using removeFirst
		list = new DoubleLinkedList<Integer>();
		sb = new StringBuilder();
		for (int i = 1; i < 10; i++) {
			list.addLast(i);
		}
		assert (list.size() == 9);
		for (int i : list) {
			sb.append(i);
		}
		assert (sb.toString().equals("123456789"));
		for (int i : list) {
			list.removeFirst();
		}
		assert (list.size() == 0);
		
		// case 21: remove all items using removeLast
		list = new DoubleLinkedList<Integer>();
		sb = new StringBuilder();
		for (int i = 1; i < 10; i++) {
			list.addLast(i);
		}
		assert (list.size() == 9);
		for (int i : list) {
			sb.append(i);
		}
		assert (sb.toString().equals("123456789"));
		do {
			list.removeLast();
		} while(list.size()>0);
		assert (list.size() == 0);
		
		// case 22: remove all items using both removeLast and removeFirst
		list = new DoubleLinkedList<Integer>();
		sb = new StringBuilder();
		for (int i = 1; i < 10; i++) {
			list.addLast(i);
		}
		assert (list.size() == 9);
		for (int i : list) {
			sb.append(i);
		}
		assert (sb.toString().equals("123456789"));
		do {
			list.removeLast();
			list.removeFirst();
		} while (list.size() > 0);
		assert (list.size() == 0);
		
		// case 23: insert 1_000_000 items
		list = new DoubleLinkedList<Integer>();
		sb = new StringBuilder();
		for (int i = 0; i < 1_000_000; i++) {
			list.addLast(i);
		}
		assert(list.size()==1_000_000);
		
	}

}
