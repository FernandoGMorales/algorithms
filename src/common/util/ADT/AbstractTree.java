package common.util.ADT;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractTree<E> implements Tree<E> {	

	@Override
	public boolean isInternal(Position<E> p) throws IllegalArgumentException {
		return numChildren(p) > 0;
	}

	@Override
	public boolean isExternal(Position<E> p) throws IllegalArgumentException {
		return numChildren(p) == 0;
	}

	@Override
	public boolean isRoot(Position<E> p) throws IllegalArgumentException {
		return p == root( );
	}	

	@Override
	public boolean isEmpty() {
		return size( ) == 0;
	}

	@Override
	public Iterable<Position<E>> positions() {
		return preorder();
	}
	
	/**
	 * Returns the number of levels separating Position p from the root.
	 * @param p
	 * @return
	 */
	public int depth(Position<E> p) {
		if (isRoot(p))
			return 0;
		else
			return 1 + depth(parent(p));
	}
	
	/**
	 * Returns the height of the subtree rooted at Position p.
	 * @param p
	 * @return
	 */
	public int height(Position<E> p) {
		int h = 0; // base case if p is external
		for (Position<E> c : children(p))
			h = Math.max(h, 1 + height(c));
		return h;
	}
	
	@Override
	/**
	 * Returns an iterator of the elements stored in the tree.
	 */
	public Iterator<E> iterator() {
		return new ElementIterator();
	}
	
	/**
	 * Returns an iterable collection of positions of the tree, reported in preorder.
	 * The iterator-snapshot approach has been followed (iterator has his own copy of the elements).
	 * @return
	 */
	public Iterable<Position<E>> preorder() {
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty())
			preorderSubtree(root(), snapshot); // fill the snapshot recursively
		return snapshot;
	}
	
	/**
	 * Adds positions of the subtree rooted at Position p to the given snapshot.
	 * @param p
	 * @param snapshot
	 */
	private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		snapshot.add(p); // for preorder, we add position p before exploring subtrees
		for (Position<E> c : children(p))
			preorderSubtree(c, snapshot);
	}
	
	/**
	 * Adds positions of the subtree rooted at Position p to the given snapshot.
	 * @param p
	 * @param snapshot
	 */
	private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		for (Position<E> c : children(p)) {
			postorderSubtree(c, snapshot);
		}
		snapshot.add(p); // for postorder, we add position p after exploring subtrees
	}
	
	/**
	 * Returns an iterable collection of positions of the tree, reported in postorder.
	 * The iterator-snapshot approach has been followed (iterator has his own copy of the elements).
	 * @return
	 */
	public Iterable<Position<E>> postorder() {
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty()) {
			postorderSubtree(root(), snapshot); // fill the snapshot recursively
		}			
		return snapshot;
	}
	
	/**
	 * Returns an iterable collection of positions of the tree in breadth-first order.
	 * The iterator-snapshot approach has been followed (iterator has his own copy of the elements).
	 * @return
	 */
	public Iterable<Position<E>> breadthfirst() {
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty()) {
			Queue<Position<E>> fringe = new Queue<>();
			fringe.enqueue(root()); // start with the root
			while (!fringe.isEmpty()) {
				Position<E> p = fringe.dequeue(); // remove from front of the queue
				snapshot.add(p); // report this position
				for (Position<E> c : children(p)) {
					fringe.enqueue(c); // add children to back of queue
				}				
			}
		}
		return snapshot;
	}
	
	/**
	 *  This class adapts the iteration produced by positions() to return elements.
	 * @author fernando
	 *
	 */
	private class ElementIterator implements Iterator<E> {
		Iterator<Position<E>> posIterator = positions().iterator();

		public boolean hasNext() {
			return posIterator.hasNext();
		}

		public E next() {
			return posIterator.next().getElement();
		} // return element!

		public void remove() {
			posIterator.remove();
		}
	}
	
	

}
