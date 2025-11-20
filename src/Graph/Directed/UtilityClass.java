package Graph.Directed;

import java.util.ArrayList;

public class UtilityClass {
    public static boolean isCycle(ArrayList<TopologicalSort.Edge>[] graph, boolean[] visited, boolean[] recStack, int curr) {
        visited[curr] = true;
        recStack[curr] = true;

        for (TopologicalSort.Edge e: graph[curr]) {
            if (recStack[e.dest]) return true;
            else if (!visited[e.dest]) {
                isCycle(graph, visited, recStack, e.dest);
            }
        }
        recStack[curr] = false;
        return false;
    }

}
