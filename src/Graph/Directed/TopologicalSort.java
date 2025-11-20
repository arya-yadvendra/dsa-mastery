package Graph.Directed;


import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    static class Edge {
        int source;
        int dest;

        public Edge(int s, int d) {
            source = s;
            dest = d;
        }
    }

    public static void modDFSTopSort(ArrayList<Edge>[] graph, boolean[] visited, int curr, Stack<Integer> stack) {
        visited[curr] = true;
        for (Edge e : graph[curr]) {
            if (!visited[e.dest]) {
                modDFSTopSort(graph, visited, e.dest, stack);
            }
        }
        stack.push(curr);
    }

    public static void topSort(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];

        // here using the stack to store the sorted elements
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                modDFSTopSort(graph, visited, i, stack);
            }
        }
        // printing stack
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }


    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        // creating graph
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[5].add(new Edge(5, 2));
        graph[5].add(new Edge(5, 0));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));

        // check cyclic or not
        boolean[] recStack = new boolean[graph.length];
        boolean[] visited = new boolean[graph.length];
//        boolean isCyclic = UtilityClass.isCycle(graph, recStack, visited, 0);
//        System.out.println("Is Cyclic : " + isCyclic);

        // calling Topological Sort here
        topSort(graph);


    }
}
