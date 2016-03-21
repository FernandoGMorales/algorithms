package common.util.ADT;

import java.util.Iterator;

/**
 * Linked list implementation of a FIFO queue. Null items are allowed.
 *   
 * @author fernando
 *
 * @param <E>
 */
public class Queue<E> implements Iterable<E> {
	
	private Node first; // link to least recently added node
	private Node last; // link to most recently added node
	private int N; // number of items on the queue
	
	/**
	 * Append this item at the end of the queue;
	 * @param item
	 */
	public void enqueue(E item) {
		Node oldLast = last;		
		last = new Node();
		last.item = item;		
		if(isEmpty()) {
			first = last;
		}
		else {
			oldLast.next = last;
		}
		N++;
		
	}
	
	/**
	 * Returns and removes the first element of the queue.
	 * @return the first element of the queue or null if the queue is empty;
	 */
	public E dequeue() {
		E item = null;
		if(!isEmpty()) {
			item = (E)first.item;
			first = first.next;		
			N--;
		}		
		return item;
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return first==null;
	}

	@Override
	public Iterator<E> iterator() {
		return new QueueIterator();
	}
	
	private class Node {		
		private E item;
		private Node next;		
	}
	
	private class QueueIterator implements Iterator<E> {
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
		Queue<Integer> queue = new Queue<Integer>();
		StringBuilder sb = new StringBuilder();
		
		// case 1 add numbers from 1 to 15
		for(int i=15; i>0; i--) {
			queue.enqueue(i);			
		}
		for(int i : queue) {
			sb.append(i);			
		}
		assert(sb.toString().equals("151413121110987654321"));
		
		// case 2 the first two elements
		sb = new StringBuilder();
		queue.dequeue();
		queue.dequeue();
		for(int i : queue) {
			sb.append(i);			
		}
		assert(sb.toString().equals("13121110987654321"));
		
		// case 3 remove all elements				
		for(int i : queue) {
			queue.dequeue();
		}
		assert(queue.isEmpty());
		
		// case 4 add one element
		sb = new StringBuilder();
		queue.enqueue(6846);		
		assert(queue.size()==1);
		for(int i : queue) {
			sb.append(i);
		}
		assert(sb.toString().equals("6846"));
		
		// case 5 dequeue on an empty queue
		queue = new Queue<Integer>();		
		assert(queue.dequeue()==null);
		
	}

}
