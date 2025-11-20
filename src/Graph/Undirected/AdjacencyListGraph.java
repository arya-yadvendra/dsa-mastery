package Graph.Undirected;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AdjacencyListGraph {
    static class Edge {
        int source;
        int destination;

        public Edge(int s, int d) {
            this.source = s;
            this.destination = d;
        }
    }

    private static void printGraph(ArrayList<Edge> graph[]) {
        for (ArrayList<Edge> edges : graph) {
            for (Edge e : edges) {
                System.out.println("Edge " + e.source + " -> " + e.destination);
            }
        }
    }

    public static void bfsTraversal(ArrayList<Edge>[] graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        queue.add(0);
        while(!queue.isEmpty()) {
            int curr = queue.remove();
            if (!visited[curr]) {
                visited[curr] = true;
                System.out.print(curr + " ");
                for (Edge e : graph[curr]) {
                    queue.add(e.destination);
                }
            }

        }
    }

    public static void dfsTraversal(ArrayList<Edge>[] graph, boolean[] visited, int current) {
        visited[current] = true;
        System.out.print(current + " ");
        for (Edge e : graph[current]) {
            if (!visited[e.destination]) {
                dfsTraversal(graph, visited, e.destination);
            }
        }
    }

    public static void printAllPath(ArrayList<Edge>[] graph, boolean[] visited, int curr, String path, int target) {
        if (curr == target) {
            System.out.println(path);
            return;
        }

        // Mark current node as visited
        visited[curr] = true;
        for (Edge e : graph[curr]) {
            if (!visited[e.destination]) {
                printAllPath(graph, visited, e.destination, path + " -> " + e.destination, target);
            }
        }
        // Unmark current node as visited, to allow other paths to use it
        visited[curr] = false;
    }

    public static boolean isCyclic(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
       for (int i = 0; i < graph.length; i++) {
           if (!visited[i]) {
               if (modifyDFSCycleDetect(graph, visited, i, -1)) return true;
           }
       }
       return false;
    }

    private static boolean modifyDFSCycleDetect(ArrayList<Edge>[] graph, boolean[] visited, Integer current, Integer parent) {
        visited[current] = true;
        for (Edge e : graph[current]) {
            if (!visited[e.destination]) {
                if (modifyDFSCycleDetect(graph, visited, e.destination, current)) return true;
            } else if (e.destination != parent) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i<graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        graph[6].add(new Edge(6, 5));


        boolean[] visited = new boolean[graph.length];
//        System.out.println("Traversing Graph"); printGraph(graph);

        // BFS Traversal
//        System.out.println("\nBFS Traversal:"); bfsTraversal(graph);
//
        // DFS Traversal
//        System.out.println("\n\nDFS Traversal:"); dfsTraversal(graph, visited, 0);

        // Print All Path
        int source = 0; int target = 5;
        System.out.printf("\nAll possible path from source : %d to target : %d\n", source, target);
        printAllPath(graph, visited, 0, Integer.toString(source), target);

        // Check Cyclic
        System.out.printf("\nIs Cyclic : %b\n", isCyclic(graph));

    }

}
