/**
The most common way to represent a graph is via an adjacency list or matrix:

	Adjacency List:
		Every vertex stores a list of adjacent vertices with it.
	Adjacency Matrix:
		An adjacency matrix is an NxN boolean matrix (where N is the number of nodes), 
		where a true value at matrix[i][j] indicates an edge from node i to node j.
		(You can also use an integer matrix with 0s and 1s.)
			In an undirected graph, an adjacency matrix will be symmetric. In a directed graph, it will not (necessarily) be.
			
	The same graph algorithms that are used on adjacency lists (breadth-first search, etc.) can be performed with adjacency matrices,
	but they may be somewhat less efficient. In the adjacency list representation, you can easily iterate through the neighbors of a node. 
	In the adjacency matrix representation, you will need to iterate through all the nodes to identify a node's neighbors.

**/

package treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	
	private final List<List<Node>> neighbors;
	
	public Graph(int vertices) {
		neighbors = new ArrayList<>(vertices);
		for (int i = 0; i < vertices; i++) {
			neighbors.add(new LinkedList<>());
		}
	}
	
	public void addEdge(Node from, Node to) {
		neighbors.get(from).add(to);
	}
	
	public void removeEdge(Node from, Node to) {
		neighbors.get(from).remove(to);
	}
	
	public List<Node> getNeighbors(Node vertex) {
		return neighbors.get(vertex);
	}
	
	public int size() {
		return neighbors.size();
	}
	
	/**
	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.add(1,2);
		g.add(2,1);
		g.add(2,3);
		g.add(3,4);
		g.add(1,4);
		
		for (List<Integer> vertex: g) {
			
		}
	}
	* **/
}
