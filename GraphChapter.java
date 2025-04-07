import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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

    public static void findInDegree(int[] indeg, ArrayList<Edge>[] graph) {
        for (ArrayList<Edge> graphx : graph) {
            for (Edge edge : graphx) {
                indeg[edge.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge>[] graph) {
        int[] indeg = new int[graph.length];
        findInDegree(indeg, graph);
        System.out.println(Arrays.toString(indeg));
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0)
                q.add(i);
        }
        System.out.println(q);
        while (!q.isEmpty()) {
            int curnt = q.remove();
            System.out.print(curnt + " ");
            for (Edge edge : graph[curnt]) {
                indeg[edge.dest]--;
                if (indeg[edge.dest] == 0) {
                    q.add(edge.dest);
                }
            }
            System.out.println(q);
        }
    }

    public static void findPath(ArrayList<Edge>[] graph, int src, int dest, String path) {
        if (src == dest) {
            path = path + dest;
            for (char c : path.toCharArray()) {
                System.out.print(c + " ");
            }
            System.out.println();
            return;
        }
        for (Edge edge : graph[src]) {
            findPath(graph, edge.dest, dest, path + src);
        }
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
        // graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[0].add(new Edge(0, 3));
        graph[0].add(new Edge(0, 4));

        // Biparte graph -> acyclic and cyclic with even number of nodes
        // Non - Biparte graph -> cyclic with odd number of nodes
        // topSort(graph);

        // The time complexity for the findpath is O(v^v) which is a exponential
        // for the worst case there will be v vertesis from the curnt vertex
        findPath(graph, 5, 1, "");
    }
}
