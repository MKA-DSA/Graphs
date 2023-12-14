//unweighted undirected graph
import java.util.*;
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
		numNodes = graph.length;
	}
	public void breadthFirst() {
		ArrayList<Integer> queue = new ArrayList<Integer>();
		ArrayList<Integer> visited = new ArrayList<Integer>();
		int curr = 0;
		queue.add(curr);
		while (queue.size() > 0) {
			curr = queue.remove(0);
			visited.add(curr);
			for (int con = curr + 1; con < graph.length; con++) {
				boolean isConnected = graph[curr][con] == 1;
				if (isConnected && !visited.contains(con) && !queue.contains(con)) queue.add(con);				
			}
		}
		System.out.println(visited);
	}
	
	private ArrayList<Integer> depthFirstHelper(int curr, ArrayList<Integer> visited) {
		visited.add(curr);
		for (int con = curr + 1; con < graph.length; con++) {
			boolean isConnected = graph[curr][con] == 1;
			if (isConnected && !visited.contains(con)) visited = depthFirstHelper(con, visited);
		}
		return visited;
	}
	
	public void depthFirst() {System.out.println(depthFirstHelper(0, new ArrayList<Integer>())); }
	
	public static void main(String[] args) {
		Graph g = new Graph();
		g.breadthFirst();
		g.depthFirst();
	}
}
