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
		
		  String file_path ="";
		  Scanner sc = new Scanner(System.in);
		  System.out.println("======================================="); 
		  System.out.println("Adicione o caminho completo do arquivo:");
		  System.out.println("=======================================");
		  while(sc.hasNext()){ file_path = sc.next();break; } //sc.close();
		 
		//Lendo grafo de arquivo
		
		String dados = "";
		//"/home/fabricioalmeida/eclipse-workspace/java-adjacency-matrix/src/main/grafo.txt";
		try{    
			FileInputStream fin=new FileInputStream(file_path);    
			int i=0;
			while((i=fin.read())!=-1){    
				//System.out.print((char)i); 
				dados+= (char)i;
			}    
			fin.close();    
		}catch(Exception e){System.out.println("O caminho de arquivo é inválido!");}   

		//fim lendo grafo
		String[] splitDados = dados.split("\n");
		String tipoGraph = (String)splitDados[0];
		String vertices  = (String) splitDados[1];
		String arestas  = (String) splitDados[2];
		/*
		 * System.out.print("grafo: "+tipoGraph+"\n");
		 * System.out.print("Arestas: "+vertices+"\n");
		 * System.out.print("Arestas: "+arestas+"\n");
		 */

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
			System.out.println("Matrix de Adjacencias - GRAFO D");
			System.out.println("================================");

			g.adjacencyMatrix();
			
			
			//g.getGrauDirected("v2");
			//g.isAdj("v2", "v3"); funçao só para grafo nao direcionado
			//g.getVizinhosDirected("v2");
			//g.visitAllEdges();
			menuD(g);


		} else if(tipoGraph.compareTo("ND")==0) {
			
			  //g.addEdge("v1", "v3"); g.addEdge("v4", "v5"); g.addEdge("v6", "v7"); g.addEdge("v3",
			  //"v2");
			 
			
			  for (int i=0; i<edges.length;i++) { 
				  String temp = edges[i];
				  String temp2 = temp.replace("(", ""); 
				  String temp3 = temp2.replace(")", ""); 
				  String[] uv = temp3.split(":"); 
				  g.addEdge(uv[0],uv[1]); //System.out.println(uv[0]+""+uv[1]);
			  }
			 

			System.out.println("================================");
			System.out.println("Matrix de Adjacencias - GRAFO ND");
			System.out.println("================================");

			g.adjacencyMatrix();
			
			/*
			 * System.out.println();
			 * System.out.println("---------------Menu de questoes----------------");
			 * System.out.println("1 - Verificar o grau de um determinado vertice");
			 * System.out.println("2 - Verificar se dois vertices sao adjacentes");
			 * System.out.println("3 - Buscar os vizinhos de um vertice");
			 * System.out.println("4 - Buscar todas as arestas do grafo");
			 * System.out.println("-----------------------------------------------");
			 */
			
			//g.getGrau("v2");
			//g.isAdj("v2", "v3");
			//g.getVizinhos("v2");
			//g.visitAllEdges();
			//sc.close();
			///home/fabricioalmeida/eclipse-workspace/java-adjacency-matrix/src/main/grafo.txt
			//Controle de questões
			/*
			 * Scanner opcao = new Scanner(System.in); String opt = "";
			 * System.out.println(); System.out.println("Adicione a opção correspondente:");
			 * 
			 * while(opcao.hasNext()){ opt = opcao.next();break; } //opcao.close();
			 */			  //System.out.println("O opt é: "+opt);
			  menuND(g);
			
		}


		// Interface grafica
		// FrameGrafoDirecionado f = new FrameGrafoDirecionado();
		/*
		 * try { FileUpload frame = new FileUpload(); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

	}

	public static void menuND(AdjacencyMatrix g) {
		System.out.println();
		System.out.println("---------------Menu de questoes----------------");
		System.out.println("1 - Verificar o grau de um determinado vertice");
		System.out.println("2 - Verificar se dois vertices sao adjacentes");
		System.out.println("3 - Buscar os vizinhos de um vertice");
		System.out.println("4 - Buscar todas as arestas do grafo");
		System.out.println("-----------------------------------------------");
		Scanner opcao = new Scanner(System.in);
		String opt = "";
		  System.out.println(); 
		  System.out.println("Adicione a opção correspondente:");

		  while(opcao.hasNext()){ opt = opcao.next();break; } //opcao.close();
		
		
		
		switch (opt) {
		case "1":
			System.out.println("Entre com o vertice desejado (ex.: v1):");
			Scanner opt1 = new Scanner(System.in);
			String op1 = "";
			while(opt1.hasNext()){ op1 = opt1.next();break; } //opcao.close();
			
			g.getGrau(op1);
			
			System.out.println("-------------------------------------------");
			System.out.println("Digite 0, para voltar ao menu inicial:");
			Scanner opt0 = new Scanner(System.in);
			String op0 = "";
			while(opt0.hasNext()){ op0 = opt0.next();break; } //opcao.close();

			if(op0.compareTo("0")==0) {
				menuND(g);
			}
	
			break;
		case "2":
			System.out.println("Entre com o vertice desejado (ex.: v1,v2):");
			Scanner opt2 = new Scanner(System.in);
			String op2 = "";
			while(opt2.hasNext()){ op2 = opt2.next();break; } //opcao.close();
			String[] v_op2 = op2.split(",");
			
			g.isAdj(v_op2[0], v_op2[1]);
			
			System.out.println("-------------------------------------------");
			System.out.println("Digite 0, para voltar ao menu inicial:");
			Scanner opt0_2 = new Scanner(System.in);
			String op0_2 = "";
			while(opt0_2.hasNext()){ op0_2 = opt0_2.next();break; } //opcao.close();

			if(op0_2.compareTo("0")==0) {
				menuND(g);
			}
			break;
		case "3":
			System.out.println("Entre com o vertice desejado (ex.: v1):");
			Scanner opt3 = new Scanner(System.in);
			String op3 = "";
			while(opt3.hasNext()){ op3 = opt3.next();break; } //opcao.close();
			
			g.getVizinhos(op3);
			
			System.out.println("-------------------------------------------");
			System.out.println("Digite 0, para voltar ao menu inicial:");
			Scanner opt0_3 = new Scanner(System.in);
			String op0_3 = "";
			while(opt0_3.hasNext()){ op0_3 = opt0_3.next();break; } //opcao.close();

			if(op0_3.compareTo("0")==0) {
				menuND(g);
			}
			
			break;
		case "4":
			
			g.visitAllEdges();
			System.out.println("-------------------------------------------");
			System.out.println("Digite 0, para voltar ao menu inicial:");
			Scanner opt0_4 = new Scanner(System.in);
			String op0_4 = "";
			while(opt0_4.hasNext()){ op0_4 = opt0_4.next();break; } //opcao.close();

			if(op0_4.compareTo("0")==0) {
				menuND(g);
			}
			
			break;

		default:
			System.out.println("Opção inválida. Tente novamente!");
			menuND(g);
			break;
		}
		
		
	}

	public static void menuD(AdjacencyMatrix g) {
		System.out.println();
		System.out.println("---------------Menu de questoes----------------");
		System.out.println("1 - Verificar o grau de um determinado vertice");
		System.out.println("2 - Verificar se dois vertices sao adjacentes");
		System.out.println("3 - Buscar os vizinhos de um vertice");
		System.out.println("4 - Buscar todas as arestas do grafo");
		System.out.println("-----------------------------------------------");
		Scanner opcao = new Scanner(System.in);
		String opt = "";
		  System.out.println(); 
		  System.out.println("Adicione a opção correspondente:");

		  while(opcao.hasNext()){ opt = opcao.next();break; } //opcao.close();
		
		
		
		switch (opt) {
		case "1":
			System.out.println("Entre com o vertice desejado (ex.: v1):");
			Scanner opt1 = new Scanner(System.in);
			String op1 = "";
			while(opt1.hasNext()){ op1 = opt1.next();break; } //opcao.close();
			
			g.getGrauDirected(op1);
			
			System.out.println("-------------------------------------------");
			System.out.println("Digite 0, para voltar ao menu inicial:");
			Scanner opt0 = new Scanner(System.in);
			String op0 = "";
			while(opt0.hasNext()){ op0 = opt0.next();break; } //opcao.close();

			if(op0.compareTo("0")==0) {
				menuD(g);
			}
	
			break;
		case "2":
			System.out.println("Entre com o vertice desejado (ex.: v1,v2):");
			Scanner opt2 = new Scanner(System.in);
			String op2 = "";
			while(opt2.hasNext()){ op2 = opt2.next();break; } //opcao.close();
			String[] v_op2 = op2.split(",");
			
			//g.isAdj(v_op2[0], v_op2[1]);
			//g.isAdj(v_op2[0], v_op2[1]);
			g.isAdjDirected(v_op2[0], v_op2[1]);
			
			System.out.println("-------------------------------------------");
			System.out.println("Digite 0, para voltar ao menu inicial:");
			Scanner opt0_2 = new Scanner(System.in);
			String op0_2 = "";
			while(opt0_2.hasNext()){ op0_2 = opt0_2.next();break; } //opcao.close();

			if(op0_2.compareTo("0")==0) {
				menuD(g);
			}
			break;
		case "3":
			System.out.println("Entre com o vertice desejado (ex.: v1):");
			Scanner opt3 = new Scanner(System.in);
			String op3 = "";
			while(opt3.hasNext()){ op3 = opt3.next();break; } //opcao.close();
			
			//g.getVizinhos(op3);
			g.getVizinhos(op3);
			
			System.out.println("-------------------------------------------");
			System.out.println("Digite 0, para voltar ao menu inicial:");
			Scanner opt0_3 = new Scanner(System.in);
			String op0_3 = "";
			while(opt0_3.hasNext()){ op0_3 = opt0_3.next();break; } //opcao.close();

			if(op0_3.compareTo("0")==0) {
				menuD(g);
			}
			
			break;
		case "4":
			
			g.visitAllEdges();
			System.out.println("-------------------------------------------");
			System.out.println("Digite 0, para voltar ao menu inicial:");
			Scanner opt0_4 = new Scanner(System.in);
			String op0_4 = "";
			while(opt0_4.hasNext()){ op0_4 = opt0_4.next();break; } //opcao.close();

			if(op0_4.compareTo("0")==0) {
				menuD(g);
			}
			
			break;

		default:
			System.out.println("Opção inválida. Tente novamente!");
			menuD(g);
			break;
		}
		
		
	}
}
