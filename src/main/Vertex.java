package main;

public class Vertex {
	int id;
	String label;
	int grau;
	public Vertex(String label, int id)
	{
		this.id = id; //id numerico do vértice
		this.label = label;//rótulo do vertice (ex.: A,B,..,N)
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public int getId() {
		return id;
	}
}
