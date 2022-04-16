package main;

/*import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.io.*;*/
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
//import java.io.IOException;



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
		//"/home/fabricioalmeida/eclipse-workspace/java-adjacency-matrix/src/main/g.txt";
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
		String [] vtx = splitDados;//vator aux
		String[] list_vtx = new String[vtx.length-1];//listarestas
		//System.out.println(vtx.length);
		for(int i=1; i<vtx.length;i++) {
			list_vtx[i-1] = vtx[i];
		}
				
		String tipoGraph = (String)splitDados[0];//tipodografo
		
		
		String list_vtx_to_string = "";
		for (int i=0; i<list_vtx.length;i++) {list_vtx_to_string+= list_vtx[i]+" ";}
	
		String nos  = list_vtx_to_string.replace(",", " ");//dividindo arestas em nós
		
		
		
		//String vertices  = (String) splitDados[1];
		String arestas  = (String) list_vtx_to_string;
		
		String[] v = nos.split(" ");
		//removendo vertices duplicados
        Arrays.sort(v);
        List<String> distinctArray = new ArrayList<String>(); 
        for(int i = 0; i < v.length; i++) {
        	distinctArray.add(v[i]);
        	//System.out.println( distinctArray.get(i) + "-");
        	}
		List<String> lista_vertices = new ArrayList<String>();
		for (int i=0; i< v.length;i++) {
			lista_vertices.add(v[i]);
		}
		String lenvtx = lista_vertices.get(lista_vertices.size()-1);
		char lenvtx_number = lenvtx.charAt(1);
		char lenvtx_label = lenvtx.charAt(0);
		int size = Integer.parseInt(String.valueOf(lenvtx_number));
		///home/fabricioalmeida/eclipse-workspace/java-adjacency-matrix/src/main/g.txt
		
		List<String> lista_vertices2 = new ArrayList<String>();
		for(int i=1; i<=size;i++){
			lista_vertices2.add(lenvtx_label+""+i);
		}
		
		AdjacencyMatrix g = new AdjacencyMatrix(lista_vertices2);

		String[] edges = arestas.split(" ");
		if (tipoGraph.compareTo("D")==0){// deterministico
			for (int i=0; i<edges.length;i++) {
				String temp = edges[i];
				String[] uv = temp.split(",");
				
				g.addEdgeDirected(uv[0],uv[1]);
			}
			System.out.println("================================");
			System.out.println("Matrix de Adjacencias - GRAFO D");
			System.out.println("================================");

			g.adjacencyMatrix();
			menuD(g);


		} else if(tipoGraph.compareTo("ND")==0) {
			
			  //g.addEdge("v1", "v3"); g.addEdge("v4", "v5"); g.addEdge("v6", "v7"); g.addEdge("v3",
			  //"v2");
			 
			
			  for (int i=0; i<edges.length;i++) { 
				  String temp = edges[i];
				  //String temp2 = temp.replace("(", ""); 
				  //String temp3 = temp2.replace(")", ""); 
				  //String[] uv = temp3.split(":"); 
				  String[] uv = temp.split(",");
				  g.addEdge(uv[0],uv[1]); //System.out.println(uv[0]+""+uv[1]);
			  }
			 

			System.out.println("================================");
			System.out.println("Matrix de Adjacencias - GRAFO ND");
			System.out.println("================================");

			g.adjacencyMatrix();
			
			  menuND(g);
			
		}

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
