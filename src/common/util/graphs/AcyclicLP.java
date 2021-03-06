package common.util.graphs;

import common.util.ADT.Stack;

public class AcyclicLP {
	
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	
	public AcyclicLP(EdgeWeightedDigraph G, int s) {
		edgeTo = new DirectedEdge[G.getVertices()];
		distTo = new double[G.getVertices()];
		for (int v = 0; v < G.getVertices(); v++)
			distTo[v] = Double.NEGATIVE_INFINITY;
		distTo[s] = 0.0;
		Topological top = new Topological(G);
		for (int v : top.order())
			relax(G, v);
	}
	
	private void relax(EdgeWeightedDigraph G, int v) {
		for (DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if (distTo[w] < distTo[v] + e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
			}
		}
	}
	
	public double distTo(int v) {
		return distTo[v];
	}

	public boolean hasPathTo(int v) {
		return distTo[v] < Double.NEGATIVE_INFINITY;
	}

	public Iterable<DirectedEdge> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
			path.push(e);
		}			
		return path;
	}
	
	public double longestPathWeight() {
		double max = Double.NEGATIVE_INFINITY;
		for(double i : distTo) {
			max = Math.max(i, max);
		}
		return max;
	}
	
	public static void main(String[] args) {

	}

}
