package main;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrix {
	// Graph node
	public int[][] node;
	// Number of nodes
	public int size;
	// Vertex list
	public List<Vertex> list = new ArrayList<Vertex>();
	public AdjacencyMatrix(List<String> vertices){
		
		if (vertices.isEmpty()){return;}
		
		this.node = new int[vertices.size()][vertices.size()];
		this.size = vertices.size();
		
		for (int i = 0; i<vertices.size(); i++) {
			Vertex temp = new Vertex(vertices.get(i),i);
		    this.list.add(temp);
		}
	}
	public void addEdge(String start, String end){
		//Vertex temp;
		for (int i = 0; i < this.list.size(); i++) {
			Vertex u = list.get(i);
			for (int j = 0; j < this.list.size(); j++) {
				Vertex v = list.get(j);
				//System.out.println(""+v.getLabel());
				//verifica se contem os vertices para a aresta
			    if(u.getLabel().compareTo(start)==0 && v.getLabel().compareTo(end)==0) {
			    	if (size > u.getId() && size > v.getId()){
						// Set the connection
			    		node[u.getId()][v.getId()] = 1;
						node[v.getId()][u.getId()] = 1;
						//node[v.getId()][u.getId()] = 1;
						//System.out.println(i);
					}
			    }
			}
		}	
		
	}
	public void addEdgeDirected(String start, String end){
		//Vertex temp;
		for (int i = 0; i < this.list.size(); i++) {
			Vertex u = list.get(i);
			for (int j = 0; j < this.list.size(); j++) {
				Vertex v = list.get(j);
				//verifica se contem os vertices para a aresta
			    if(u.getLabel().compareTo(start)==0 && v.getLabel().compareTo(end)==0) {
			    	if (size > u.getId() && size > v.getId()){
						// Set the connection
						node[i][j] = 1;
						//node[v.getId()][u.getId()] = 1;
						//System.out.println(i);
					}
			    }
			}
		}	
		
	}
	public void adjacencyMatrix(){
		if (this.size > 0){
			for (int row = 0; row < this.size; row++){
				System.out.print("   ");
				for (int col = 0; col < size; col++){
					Vertex temp = list.get(col);
					System.out.print(" "+temp.getLabel()+" ");
					
					}
				break;
				}
			System.out.println();
			for (int row = 0; row < this.size; row++){
				Vertex temp = list.get(row);
				System.out.print("" + temp.getLabel() + " ");
				for (int col = 0; col < size; col++){
					if (node[row][col] == 1){
						System.out.print(" [1]");
					}else {
						System.out.print(" [0]");
					}
				}
				System.out.print("\n");
			}
		}else{
			System.out.println("Empty Graph");
		}
	}
	public int getGrau(String vertice){
		Vertex temp;
		int grau =0;
		for (int i=0; i<this.list.size();i++) {
			temp = list.get(i);
			if(temp.getLabel().compareTo(vertice) == 0) {
				for (int row = temp.getId(); row < this.size; row++){
					for (int col = 0; col < size; col++){
						if(node[row][col] == 1) {grau = grau+1;}
						//System.out.println(col);
						}
					break;
					}
			}
		}
		System.out.println("O grau do v??rtice "+vertice+ " ??: "+grau);
		return grau;
	}
	public int getGrauDirected(String vertice){
		Vertex temp;
		int grau =0;
		for (int i=0; i<this.list.size();i++) {
			temp = list.get(i);
			if(temp.getLabel().compareTo(vertice) == 0) {
				for (int row = temp.getId(); row < this.size; row++){
					for (int col = 0; col < size; col++){
						if(node[row][col] == 1) {grau = grau+1;}
						//System.out.println(col);
						}
					break;
					}
				for (int row =0; row < this.size; row++){
					for (int col =  temp.getId(); col < size; col++){
						if(node[row][col] == 1) {grau = grau+1;}
						//System.out.println(col);
						break;
						}
					
					}
			}
		}
		System.out.println("O grau do v??rtice "+vertice+ " ??: "+grau);
		return grau;
	}
	public boolean isAdj(String u, String v) {//s?? para grafo n??o direcionado
	
		Vertex x;
		Vertex y;
		for (int i = 0; i < this.list.size(); i++) {
			x=list.get(i);
			for (int j = 0; j < this.list.size(); j++) {
				y=list.get(j);
				if(x.getLabel().compareTo(u) == 0 && y.getLabel().compareTo(v)== 0) {
					//checa se s??o adj
					//grafo n??o direcionado
					if(node[i][j] == 1) { 
						System.out.println(u+" e "+v+" s??o Adjacentes!");
						return true;
					}else {
						System.out.println(u+" e "+v+" n??o s??o adjacentes");
						return false;
					}
					
					
				}
			}
		}
		return false;
	}
	public void isAdjDirected(String u, String v) {//s?? para grafo n??o direcionado
		
		Vertex x;
		Vertex y;
		boolean ij = false;
		boolean ji  = false;
		for (int i = 0; i < this.list.size(); i++) {
			x=list.get(i);
			for (int j = 0; j < this.list.size(); j++) {
				y=list.get(j);
				if(x.getLabel().compareTo(u) == 0 && y.getLabel().compareTo(v)== 0) {
					if(node[i][j] == 1) {ij=true;}
				}
			}
		}
		for (int i = 0; i < this.list.size(); i++) {
			x=list.get(i);
			for (int j = 0; j < this.list.size(); j++) {
				y=list.get(j);
				if(x.getLabel().compareTo(u) == 0 && y.getLabel().compareTo(v)== 0) {
					if(node[j][i] == 1) {ji=true;}
				}
			}
		}
		if(ij==true && ji==true) {
			System.out.println("Os vertices "+ u + " e "+v+" s??o adjacentes");
		}else if(ij==true && ji==false) {
			System.out.println(v+" ?? adjacente de " +u+", mas "+u+ " n??o ?? adjacente de "+ v);
		}else if(ij==false && ji==true) {
			System.out.println(u+" ?? adjacente de " +v+", mas "+v+ " n??o ?? adjacente de "+ u);
		}else if(ij==false && ji==false) {
			System.out.println(u+" e "+v+" n??o s??o adjacentes!");
		}
		
		//System.out.println(v+" ?? adjacentes de " +u);
		//
		//pegando os vizinhos n??o adjacentes
		/*
		 * for (int i=0; i<this.list.size();i++) { temp = list.get(i);
		 * if(temp.getLabel().compareTo(vertice) == 0) {
		 * //System.out.print("Vizinhos de "+vertice+": "); for (int row = 0; row <
		 * this.size; row++){ for (int col = temp.getId(); col < size; col++){
		 * if(node[row][col] == 1) { Vertex v = list.get(row);
		 * System.out.print(v.getLabel()+" "); } break; }
		 * 
		 * }
		 * 
		 * System.out.println(); } }
		 */
		//fim teste
		//return false;
	}
	public void getVizinhos(String vertice) {
		Vertex temp;
		List<String> vizinhos =  new ArrayList<String>();
		for (int i=0; i<this.list.size();i++) {
			temp = list.get(i);
			if(temp.getLabel().compareTo(vertice) == 0) {
				System.out.print("Vizinhos de "+vertice+": ");
				for (int row = temp.getId(); row < this.size; row++){
					for (int col = 0; col < size; col++){
						if(node[row][col] == 1) {
							Vertex v = list.get(col);
							//vizinhos.add(v.getLabel());
							System.out.print(v.getLabel()+" ");
						}
						
					}
					break;
				}
				System.out.println();
				/*
				 * for (int row =0; row < this.size; row++){ for (int col = temp.getId(); col <
				 * size; col++){ if(node[row][col] == 1) {grau = grau+1;}
				 * //System.out.println(col); break; }
				 * 
				 * }
				 */
			}
		}
		for(int i = 0;i<vizinhos.size();i++) {
			System.out.print(vizinhos.size()+" ");
		}
	}
	public void getVizinhosDirected(String vertice) {
		Vertex temp;
		List<String> vizinhos =  new ArrayList<String>();
		for (int i=0; i<this.list.size();i++) {
			temp = list.get(i);
			if(temp.getLabel().compareTo(vertice) == 0) {
				System.out.print("Vizinhos de "+vertice+": ");
				for (int row = temp.getId(); row < this.size; row++){
					for (int col = 0; col < size; col++){
						if(node[row][col] == 1) {
							Vertex v = list.get(col);
							System.out.print(v.getLabel()+" ");
						}

					}
					break;
				}

				//System.out.println();
			}
		}
		//pegando os vizinhos n??o adjacentes
		for (int i=0; i<this.list.size();i++) {
			temp = list.get(i);
			if(temp.getLabel().compareTo(vertice) == 0) {
				//System.out.print("Vizinhos de "+vertice+": ");
				for (int row = 0; row < this.size; row++){
					for (int col = temp.getId(); col < size; col++){
						if(node[row][col] == 1) {
							Vertex v = list.get(row);
							System.out.print(v.getLabel()+" ");
						}
						break;
					}
					
				}

				System.out.println();
			}
		}
		//fim bizinhos nao adjacentes
		
		for(int i = 0;i<vizinhos.size();i++) {
			System.out.print(vizinhos.size()+" ");
		}
	}
	public void visitAllEdges() {
		Vertex x;
		Vertex y;
		System.out.print("Todas as arestas: ");
		 for (int row = 0; row < this.list.size(); row++) {
			 x = this.list.get(row);
			 for (int col = 0; col < this.list.size(); col++) {
				 y = this.list.get(col);
				 if(node[x.getId()][y.getId()] == 1) {
					 System.out.print("("+x.getLabel()+", "+y.getLabel()+") ");
				 }
				 
			 }
		 }
		 System.out.println();
		 
		 
	}
}