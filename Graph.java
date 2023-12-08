//unweighted undirected graph
public class Graph {
	private int[][] graph;
	private int numNodes;
	
	public Graph() {
		int[][] g = {{0,1,0,1,1,0},
					{1,0,1,0,0,0},
					{0,1,0,0,0,1},
					{1,0,0,0,1,0},
					{1,0,0,1,0,1},
					{0,0,1,0,1,0}};
		graph = g;
		numNodes = graph.length();
	}
	public void breadthFirst() {}
	public void depthFirst() {}

}
