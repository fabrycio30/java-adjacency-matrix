package main;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<String> lista_vertices = new ArrayList<String>();
		lista_vertices.add("A");
		lista_vertices.add("B");
		lista_vertices.add("C");
		lista_vertices.add("D");
		lista_vertices.add("E");
		lista_vertices.add("F");
		
		AdjacencyMatrix g = new AdjacencyMatrix(lista_vertices);
		/*
		 * g.addEdgeDirected("A", "B"); g.addEdgeDirected("A", "C");
		 * g.addEdgeDirected("E", "A"); g.addEdgeDirected("C", "A");
		 */
		g.addEdge("A", "B");
		g.addEdge("A", "C");
		g.addEdge("E", "A");
		g.addEdge("D", "A");
				
		g.adjacencyMatrix();
		g.getGrau("A");
		g.isAdj("C", "E");
		g.getVizinhos("A");
				
	}

}
