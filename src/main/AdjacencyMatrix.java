package main;

public class AdjacencyMatrix {
	// Graph node
	public int[][] node;
	// Number of nodes
	public int size;
	public AdjacencyMatrix(int size)
	{
		if (size <= 0)
		{
			// Invalid number of nodes
			return;
		}
		this.node = new int[size][size];
		this.size = size;
	}
	public void addEdge(int start, int end)
	{
		if (size > start && size > end)
		{
			// Set the connection
			node[start][end] = 1;
			node[end][start] = 1;
		}
	}
	public void adjacencyMatrix(){
		if (this.size > 0){
			for (int row = 0; row < this.size; row++){
				System.out.print("   ");
				for (int col = 0; col < size; col++){
					
					System.out.print("  "+col+" ");
					
					}
				break;
				}
			System.out.println();
			for (int row = 0; row < this.size; row++){
				
				System.out.print("" + row + " :");
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

}