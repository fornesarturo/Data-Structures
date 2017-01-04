package Graph;

public class MatrixGraph {
	Integer[][] graph;
	int size = 20;
	
	public MatrixGraph(){
		this.graph = new Integer[this.size][this.size];
		for(int i = 0; i < 20; i++){
			for(int j = 0; j < 20; j++){
				this.graph[i][j] = null;
			}
		}
	}
	
	@SuppressWarnings("unused")
	private void resize(){
		int newSize = size*2;
		Integer[][] newGraph = new Integer[newSize][newSize];
		for(int i = 0; i < this.size; i++){
			for(int j = 0; j < this.size; j++){
				newGraph[i][j] = this.graph[i][j];
			}
		}
		this.graph = newGraph;
		this.size*=2;
	}
	
	public void addEdge(int v, int w, int cost){
		if(v < 0 || w < 0 || v > this.size || w > this.size)
			throw new IndexOutOfBoundsException();
		this.graph[v][w] = cost;
		this.graph[w][v] = cost;
	}
	
}