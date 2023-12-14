import java.io.File;
import java.util.*;
// Topological Sort and Shortest Path

public class UnweightedGraph {
	private int[][] graph;
	private int numVerts;
	
	public UnweightedGraph() {
		int[][] adj =  {{0,1,1,1,0,0,0}, //1
						{0,0,0,1,1,0,0}, //2
						{0,0,0,0,0,1,0}, //3
						{0,0,1,0,0,1,1},
						{0,0,0,1,0,0,1},
						{0,0,0,0,0,0,0},
						{0,0,0,0,0,1,0}};
						
		graph = adj;
		numVerts = adj.length;
	}
	
	private int findNext(ArrayList<ArrayList<Integer>> incoming) {
		for(int i = 0; i < incoming.size(); i++) {
			if (incoming.get(i).size() == 0) {
				return i;
			}
		}
		return -1;
	}

	private ArrayList<ArrayList<Integer>> adjacencyListIncoming(){
		ArrayList<ArrayList<Integer>> Fred = new ArrayList<ArrayList<Integer>>(); 
		for (int col = 0; col<graph.length; col++) {
			ArrayList<Integer> Joe = new ArrayList<Integer>();
			 for (int row = 0; row<graph[0].length; row++) {
				 if (graph[row][col] == 1) {
					 // connection between col & row
					 Joe.add(row);
				 }
			 }
			 Fred.add(Joe);
		 }
		return Fred;
	}
	
	
	public ArrayList<Integer> topologicalSort(){
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> incoming = adjacencyListIncoming();
		int curr = findNext(incoming);
		for(int i = 0; i < numVerts; i++) {
			System.out.println(curr);
			sorted.add(curr);
			incoming.get(curr).add(-1);
			
			// remove curr from all rows in incoming
			for(int x = 0; x < incoming.size(); x++) {
				incoming.get(x).remove((Integer) curr);	
			}
			
			// find the next node to add to sorted
			curr = findNext(incoming);
			
		}
		return sorted;
		
	}
		
	
	public static void main(String[] args) {
		UnweightedGraph g = new UnweightedGraph();
		System.out.println(g.topologicalSort());
	
	}
}
