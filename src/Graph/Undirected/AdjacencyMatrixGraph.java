package Graph.Undirected;

public class AdjacencyMatrixGraph {

    public static void addEdge(int[][] adjMatrix, int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
    }

    // print graph
    public static void printGraph(int adjMatrix[][]) {
        for (int[] matrix : adjMatrix) {
            for (int i : matrix) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 7;
        int E = 8;
        int[][] adjMatrix = new int[V][V];

        addEdge(adjMatrix, 0, 1);
        addEdge(adjMatrix, 0, 2);
        addEdge(adjMatrix, 1, 3);
        addEdge(adjMatrix, 1, 4);
        addEdge(adjMatrix, 2, 5);
        addEdge(adjMatrix, 2, 6);
        addEdge(adjMatrix, 3, 4);
        addEdge(adjMatrix, 5, 6);

        printGraph(adjMatrix);


    }
}
