import java.util.ArrayList;

public class GraphChapter {
    public static class Edge {
        int source, dest;
        // int weight;

        // undirected Graph
        // public Edge(int source, int dest, int weight) {
        // this.source = source;
        // this.dest = dest;
        // this.weight = weight;
        // }

        // Directed Graph
        public Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }

    public static boolean directedIsCycle(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (isCycleUtil(graph, i, visited, stack)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int cur, boolean[] visited, boolean[] stack) {
        visited[cur] = true;
        stack[cur] = true;
        for (Edge edge : graph[cur]) {
            if (stack[edge.dest]) {
                return true;
            }
            if (!visited[edge.dest] && isCycleUtil(graph, edge.dest, visited, stack)) {
                return true;
            }
        }
        stack[cur] = false;
        return false;
    }

    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[5];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Undirected graphs
        // 0 node
        // graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 2, 2));
        // // 1 node
        // graph[1].add(new Edge(1, 0, 1));
        // graph[1].add(new Edge(1, 3, 3));
        // // 2 node
        // graph[2].add(new Edge(2, 0, 2));
        // graph[2].add(new Edge(2, 4, 5));
        // // 3 node
        // graph[3].add(new Edge(3, 1, 3));
        // graph[3].add(new Edge(3, 4, 4));
        // graph[3].add(new Edge(3, 5, 1));
        // // 4 node
        // graph[4].add(new Edge(4, 2, 5));
        // graph[4].add(new Edge(4, 3, 4));
        // graph[4].add(new Edge(4, 5, 3));
        // // 5 node
        // graph[5].add(new Edge(5, 3, 1));
        // graph[5].add(new Edge(5, 4, 3));

        // Directed Graphs
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 2));

        // Biparte graph -> acyclic and cyclic with even number of nodes
        // Non - Biparte graph -> cyclic with odd number of nodes
        System.out.println("\nHas cycle for the current Directed graph : " + directedIsCycle(graph));

    }
}
