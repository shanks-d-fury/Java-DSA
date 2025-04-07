import java.util.ArrayList;
import java.util.Stack;

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

    public static void topSort(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        // boolean stack[] = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = graph.length - 1; i > 0; i--) {
            if (!visited[i]) {
                topSortUtil(graph, i, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int cur, boolean[] visited, Stack<Integer> stack) {
        visited[cur] = true;
        for (Edge edge : graph[cur]) {
            if (!visited[edge.dest]) {
                topSortUtil(graph, edge.dest, visited, stack);
            }
        }
        stack.push(cur);
    }

    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[6];
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
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));

        // Biparte graph -> acyclic and cyclic with even number of nodes
        // Non - Biparte graph -> cyclic with odd number of nodes
        topSort(graph);
    }
}
