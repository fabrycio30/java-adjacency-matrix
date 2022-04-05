package main;

public class Main {

	public static void main(String[] args) {
		// inicianlizando a matrix de acordo com a quantidade de vértices
		AdjacencyMatrix g = new AdjacencyMatrix(6);
				//  Adcionando aresta não direcionada
				g.addEdge(0, 1);
				g.addEdge(0, 2);
				g.addEdge(0, 3);
				g.addEdge(1, 4);
				g.addEdge(2, 3);
				g.addEdge(3, 4);
				// Imprimindo a matriz com as adajacências
				// 1 - existe uma aresta adjacente 0- não há adj
				g.adjacencyMatrix();

	}

}
