package com.project.Euler;

import java.io.File;

import common.util.graphs.AcyclicLP;
import common.util.graphs.EdgeWeightedDigraph;

public class MaximumPathSumI {
	
	public static void main(String[] args) {
		EdgeWeightedDigraph graph = new EdgeWeightedDigraph(new File("/home/fernando/tmp/triangle_small.txt"));
		AcyclicLP asp = new AcyclicLP(graph, 0);
		System.out.println("Maximum path sum is: " + asp.longestPathWeight());		
	}

}
