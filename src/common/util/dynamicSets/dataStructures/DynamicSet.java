package common.util.dynamicSets.dataStructures;

/**
 * Operation defined for a Dynamic Set.
 * @author fernando
 *
 * @param <E>
 */
public interface DynamicSet<E> {
	
	void insert(E item);
	
	/**
	 * 
	 * @return the element to be removed of this set.
	 */
	E remove();
	
	/**
	 * 
	 * @return true if the set is empty.
	 */
	boolean isEmpty();
	
	/**
	 * Number of elements of this set. 
	 * @return
	 */
	int size();
	
	/**
	 * The minimum element of this set. 
	 * @return
	 */
	E minimum();
	
	/**
	 * The maximum element of this set. 
	 * @return
	 */
	E maximum();	

}
