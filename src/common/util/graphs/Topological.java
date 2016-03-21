package common.util.graphs;

/**
 * 
 * @author fernando
 *
 */
public class Topological {
	
	private Iterable<Integer> order;  // topological order
	
	public Topological(EdgeWeightedDigraph G) {
		DepthFirstOrder dfs = new DepthFirstOrder(G);
		order = dfs.reversePost();
	}
	
	public Iterable<Integer> order() {
		return order;
	}

	public static void main(String[] args) {

	}
	
}
