package main;

import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

import frames.FileUpload;
import frames.FrameGrafoDirecionado;

public class Main {

	public static void main(String[] args) {
		// entrada de texto para escolher tipo do grafo
		/*
		 * Scanner sc = new Scanner(System.in);
		 * System.out.println("================================"); System.out.
		 * print("Escolha o tipo do grafo: \n D -(direcionado)\n ND -(Não direcionado)\n"
		 * ); System.out.println("================================");
		 * while(sc.hasNext()){ tipoGraph = sc.next();break; } sc.close();
		 */
		//Lendo grafo de arquivo
		
		String dados = "";
		try{    
			FileInputStream fin=new FileInputStream("/home/fabricioalmeida/eclipse-workspace/java-adjacency-matrix/src/main/grafo.txt");    
			int i=0;
			while((i=fin.read())!=-1){    
				//System.out.print((char)i); 
				dados+= (char)i;
			}    
			fin.close();    
		}catch(Exception e){System.out.println(e);}   

		//fim lendo grafo
		String[] splitDados = dados.split("\n");
		String tipoGraph = (String)splitDados[0];
		String vertices  = (String) splitDados[1];
		String arestas  = (String) splitDados[2];
		System.out.print("grafo: "+tipoGraph+"\n");
		System.out.print("Arestas: "+vertices+"\n");
		System.out.print("Arestas: "+arestas+"\n");

		String[] v = vertices.split(",");


		List<String> lista_vertices = new ArrayList<String>();
		for (int i=0; i< v.length;i++) {
			lista_vertices.add(v[i]);
		}
		/*
		 * lista_vertices.add("A"); lista_vertices.add("B"); lista_vertices.add("C");
		 * lista_vertices.add("D"); lista_vertices.add("E"); lista_vertices.add("F");
		 */

		AdjacencyMatrix g = new AdjacencyMatrix(lista_vertices);
		/*
		 * g.addEdgeDirected("A", "B"); g.addEdgeDirected("A", "C");
		 * g.addEdgeDirected("E", "A"); g.addEdgeDirected("C", "A");
		 */

		String[] edges = arestas.split(",");
		
		///String a = "A";
		//if(tipoGraph == (String)"D") {System.out.println("True");}
		if (tipoGraph.compareTo("D")==0){// deterministico
			for (int i=0; i<edges.length;i++) {
				String temp = edges[i];
				String temp2 = temp.replace("(", "");
				String temp3 = temp2.replace(")", "");
				String[] uv = temp3.split(":");
				g.addEdgeDirected(uv[0],uv[1]);
				//System.out.println(uv[0]+""+uv[1]);
			}

			/*
			 * g.addEdgeDirected("A", "C"); g.addEdgeDirected("E", "A");
			 * g.addEdgeDirected("D", "A");
			 */

			System.out.println("================================");
			System.out.println("GRAFO DIRECIONADO");
			System.out.println("================================");

			g.adjacencyMatrix();
			g.getGrauDirected("v2");
			//g.isAdj("v2", "v3"); funçao só para grafo nao direcionado
			g.getVizinhosDirected("v2");
			g.visitAllEdges();


		} else if(tipoGraph.compareTo("ND")==0) {
			
			  //g.addEdge("v1", "v3"); g.addEdge("v4", "v5"); g.addEdge("v6", "v7"); g.addEdge("v3",
			  //"v2");
			 
			
			  for (int i=0; i<edges.length;i++) { String temp = edges[i]; String temp2 =
			  temp.replace("(", ""); String temp3 = temp2.replace(")", ""); String[] uv =
			  temp3.split(":"); g.addEdge(uv[0],uv[1]); //System.out.println(uv[0]+""+uv[1]);
			  }
			 

			System.out.println("================================");
			System.out.println("GRAFO NÃO DIRECIONADO");
			System.out.println("================================");

			g.adjacencyMatrix();
			g.getGrau("v2");
			g.isAdj("v2", "v3");
			g.getVizinhos("v2");
			g.visitAllEdges();
		}


		// Interface grafica
		// FrameGrafoDirecionado f = new FrameGrafoDirecionado();
		try {
			FileUpload frame  = new FileUpload();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
