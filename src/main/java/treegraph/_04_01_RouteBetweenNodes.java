package treegraph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;
import java.util.HashSet;
/**
 * Given a directed graph, design an algorithm to find out whether
 * there is a route between two nodes.
 */
class _04_01_RouteBetweenNodes {

    private final Digraph digraph;

    _04_01_RouteBetweenNodes(Digraph digraph) {
        this.digraph = digraph;
    }

    boolean hasRoute(int start, int end) {
        if (start == end) return true;

        Deque<Integer> visiting = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        visiting.add(start);
        while(!visiting.isEmpty()) {
            int curr = visiting.poll();
            for (Integer neighbor : digraph.adjacent(curr)) {
                if (!visited.contains(neighbor)) {
                    if (neighbor == end) return true;
                }
                visited.add(neighbor);
                visiting.add(neighbor);
            }
        }
        return false;
    }

}
