package common.util.dynamicSets.dataStructures;

import java.util.Iterator;

/**
 * Linked list implementation of a LIFO stack. Null items are allowed.
 * 
 * @author fernando
 *
 * @param <E>
 */
public class Stack<E> implements Iterable<E> {
	
	private Node first; // top of stack (most recently added node)
	private int N; // number of items
	
	/**
	 * Push a an item at the top of this stack.
	 * @param item
	 */
	public void push(E item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	
	/**
	 * Retrieves and remove the top item of the stack.
	 * @return
	 */
	public E pop() {
		E item = null;
		if(!isEmpty()) {
			item =(E)first.item;
			first = first.next;
			N--;
		}		
		return item;
	}
	
	/**
	 * Retrieves the top item of the stack without removing it.
	 * @return
	 */
	public E peek() {
		E item = null;
		if(!isEmpty()) {
			item =(E)first.item;			
		}		
		return item;
	}
	
	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	@Override
	public Iterator<E> iterator() {		
		return new StackIterator();
	}
	
	private class Node {		
		private E item;
		private Node next;		
	}
	
	private class StackIterator implements Iterator<E> {
		private Node current = first;		
		@Override
		public boolean hasNext() {
			return current!=null;
		}
		@Override
		public E next() {
			E item = (E)current.item;
			current = current.next;
			return item;
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		
		// case 1: add numbers from 1 - 12 to the stack
		for(int i=1; i<13; i++) {
			stack.push(i);
		}
		assert(stack.size()==12);		
		for(int i : stack) {
			sb.append(i);
		}
		assert(sb.toString().equals("121110987654321"));
		assert(stack.size()==12);
		
		// case 2: remove an item
		sb = new StringBuilder();
		stack.pop();
		for(int i :  stack) {
			sb.append(i);
		}
		assert(sb.toString().equals("1110987654321"));
		assert(stack.size()==11);
		
		// case 3: remove all items
		sb = new StringBuilder();
		for(int i :  stack) {
			stack.pop();
		}
		for(int i :  stack) {
			sb.append(i);
		}
		assert(sb.toString().equals(""));
		assert(stack.size()==0);
		
		// case 4: remove an item from an empty stack
		stack.pop();
		assert(stack.size()==0);
		
		// case 5: remove all items but one
		sb = new StringBuilder();
		for (int i = 1; i < 13; i++) {
			stack.push(i);
		}
		do {
			stack.pop();
		} while(stack.size()>1);
		for(int i : stack) {
			sb.append(i);
		}
		assert(sb.toString().equals("1"));
		assert(stack.size()==1);

		// case 6: add an item
		sb = new StringBuilder();
		stack.push(2);
		for(int i : stack) {
			sb.append(i);
		}
		assert(sb.toString().equals("21"));
		assert(stack.size()==2);
		
	}

}
