package common.util.graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

import common.util.ADT.DoubleLinkedList;

public class GraphBuilder {
	
	private final static Logger LOG = Logger.getLogger("GraphBuilder.java");
	
	public static void build(File file, Graphical graph) {
		try {
			Scanner sc = new Scanner(file);
			int v = sc.nextInt();
			int k = v; 
			for(int i=v-1; i>=0; i--) {
				v+=i;
			}
			init(graph, v);	
			
			//first case is special
			int vertex = 0;
			double weight = sc.nextDouble();
			graph.addEdge(new DirectedEdge(vertex, vertex + 1, weight + sc.nextDouble()));
			graph.addEdge(new DirectedEdge(vertex, vertex + 2, weight + sc.nextDouble()));
			vertex++;
			
			/*
			 * from now, there is a pattern to follow for this particular kind of input
			 *  	 00 
					01 02 
				   03 04 05 
				 06 07 08 09
				10 11 12 13 14
			   15 16 17 18 19 20 -> n = 6
				for example, vertex 11 is related to 16 and 17 it means 11+n-1 and 11+n  
			 */
			for (int i=3; i<=k; i++) {
				int n = (i-2)*2+2;
				double[] weights = new double[n];
				int j = 0;
				weights[j] = sc.nextDouble();				
				do {
					double w = sc.nextDouble();
					weights[++j] = w;
					weights[++j] = w;
				} while(j<weights.length-2 && sc.hasNextDouble());
				weights[n-1] = sc.nextDouble();
				
				for(int h=0; h<weights.length; h++) {					
					graph.addEdge(new DirectedEdge(vertex, vertex + i-1, weights[h]));
					if(++h==weights.length) break;
					graph.addEdge(new DirectedEdge(vertex, vertex + i, weights[h]));
					vertex++;
				}				
				
			}
			
		} catch (FileNotFoundException e) {
			LOG.info("Cannot open file.");			
		}		
	}
	
	private static void init(Graphical graph, int v) {
		EdgeWeightedDigraph g = (EdgeWeightedDigraph)graph;
		g.setVertices(v);
		g.setAdjacentList(new DoubleLinkedList[v]);		
		for(int i=0; i<v; i++) {
			g.getAdjacentList()[i] = new DoubleLinkedList<DirectedEdge>();
		}
	}
	
	public static void main(String[] args) {

	}
	
}
