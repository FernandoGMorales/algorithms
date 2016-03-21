package common.util.graphs;

public class DirectedEdge implements Edge {
	
	private final int from;
	private final int to;
	private final double weight;
	
	public DirectedEdge(int from, int to, double weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	public double weight() {
		return weight;
	}

	public int from() {
		return from;
	}

	public int to() {
		return to;
	}

	public String toString() {
		return String.format("%d->%d %.2f", from, to, weight);
	}
	
	public static void main(String[] args) {

	}

}
