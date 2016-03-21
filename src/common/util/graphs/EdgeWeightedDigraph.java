package common.util.graphs;

import java.io.File;
import java.util.logging.Logger;

import common.util.dynamicSets.dataStructures.DoubleLinkedList;

public class EdgeWeightedDigraph implements Graphical {
	
	private final Logger LOG = Logger.getLogger("EdgeWeightedDigraph.java");	
	private int vertices;
	private int edges;
	private DoubleLinkedList<DirectedEdge>[] adjacentList;	
	
	/**
	 * Builds an empty graph with vertices = v.
	 * @param v
	 */
	public EdgeWeightedDigraph(int v) {
		init(v);
	}
	
	/**
	 * Builds a graph from a file,
	 * @param file
	 */
	public EdgeWeightedDigraph(File file) {		
		GraphBuilder.build(file,this);
	}
	
	private void init(int v) {
		vertices = v;
		adjacentList = new DoubleLinkedList[vertices];
		for(int i=0; i<vertices; i++) {
			adjacentList[i] = new DoubleLinkedList<DirectedEdge>();
		}
	}
	
	public void addEdge(Edge edge) {
		DirectedEdge de = (DirectedEdge)edge;
		adjacentList[de.from()].addLast(de);
		edges++;		
	}
	
	public Iterable<DirectedEdge> adj(int v) {
		return adjacentList[v];
	}

	public Iterable<DirectedEdge> edges() {
		DoubleLinkedList<DirectedEdge> edgeList = new DoubleLinkedList<DirectedEdge>();
		for (int i=0; i<vertices; i++)
			for (DirectedEdge e : adjacentList[i])
				edgeList.addLast(e);
		return edgeList;
	}

	public int getVertices() {
		return vertices;
	}

	public int getEdges() {
		return edges;
	}

	public void setEdges(int edges) {
		this.edges = edges;
	}

	public void setVertices(int vertices) {
		this.vertices = vertices;
	}

	public DoubleLinkedList<DirectedEdge>[] getAdjacentList() {
		return adjacentList;
	}

	public void setAdjacentList(DoubleLinkedList<DirectedEdge>[] adjacentList) {
		this.adjacentList = adjacentList;
	}
	
	public static void main(String[] args) {

	}

}
