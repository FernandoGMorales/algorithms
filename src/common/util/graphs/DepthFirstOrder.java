package common.util.graphs;

import common.util.dynamicSets.dataStructures.Queue;
import common.util.dynamicSets.dataStructures.Stack;

public class DepthFirstOrder {
	
	private boolean[] marked;
	private Queue<Integer> pre; // vertices in preorder
	private Queue<Integer> post; // vertices in postorder
	private Stack<Integer> reversePost; // vertices in reverse postorder
	
	public DepthFirstOrder(EdgeWeightedDigraph G) {
		pre = new Queue<Integer>();
		post = new Queue<Integer>();
		reversePost = new Stack<Integer>();
		marked = new boolean[G.getVertices()];
		for (int v = 0; v < G.getVertices(); v++)
			if (!marked[v])
				dfs(G, v);
	}
	
	private void dfs(EdgeWeightedDigraph G, int v) {
		pre.enqueue(v);
		marked[v] = true;
		for (DirectedEdge de : G.getAdjacentList()[v])
			if (!marked[de.to()]) {
				dfs(G, de.to());
			}				
		post.enqueue(v);
		reversePost.push(v);
	}
	
	public Iterable<Integer> pre() {
		return pre;
	}

	public Iterable<Integer> post() {
		return post;
	}

	public Iterable<Integer> reversePost() {
		return reversePost;
	}
	
	public static void main(String[] args) {

	}

}
