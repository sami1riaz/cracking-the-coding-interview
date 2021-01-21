/**

4.1 Route Between Nodes
Given a directed graph, design an algorithm to find out whether there is a route between two nodes.

To find out whether two nodes have are connected, we can simply traverse the graph starting at one node and ending when we reach the other node.
We can use both BFS or DFS for this question. Since we have not been provided more information, we can't tell which algorithm will perform better,
but it's a good idea to discuss the tradeoffs of each algorithm regardless of how they perform.

For example, BFS is good in finding the shortest path, while DFS is a much cleaner solution as it can be implemented using recursion.

Both solution will take O(n) time as in the worst case, the path does not exist and we traverse the entire graph.

The BFS solution will take O(n) space for the queue used to keep track of visited nodes.


Note, for questions like this, ask the interviewer if you can assume that you have a node and graph class and what functions those classes have.
I have written these classes in the treesandgraphsgraphs package so that they can be used for treegraphs questions.

**/

package treesandgraphs;

import java.util.Set;
import java.util.HashSet;
import java.util.Deque;
import java.util.ArrayDeque;


public class RouteBetweenNodes {


	public static boolean pathExists(Graph g, Node start, Node end) {
		
		if (start == end) return true;
		
		Deque<Node> visiting = new ArrayDeque<>();
		Set<Node> visited = new HashSet<>();
		visiting.add(start);
		while(!visiting.isEmpty()) {
			Node curr = visiting.poll();
			for (Node neighbor : g.getNeighbors(curr)) {
				if (!visited.contains(neighbor)) {
					if (neighbor == end) return true;
				}
				visited.add(neighbor);
				visiting.add(neighbor);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
	
	
	}
	
}
