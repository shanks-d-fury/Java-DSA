import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class GraphChapter {
    public static class Edge {
        int source, dest;
        int weight;

        // undirected Graph
        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }

        // // Directed Graph
        // public Edge(int source, int dest) {
        // this.source = source;
        // this.dest = dest;
        // }
    }

    public static class Pair {
        int node;
        int path;

        public Pair(int node, int path) {
            this.node = node;
            this.path = path;
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

    public static void DijkstraAlgo(ArrayList<Edge>[] graph, int src) {
        int[] dist = new int[graph.length];
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.path));
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair cur = pq.remove();
            if (!visited[cur.node]) {
                visited[cur.node] = true;
                for (Edge edge : graph[cur.node]) {
                    if (dist[edge.source] + edge.weight < dist[edge.dest]) {
                        dist[edge.dest] = dist[edge.source] + edge.weight;
                        pq.add(new Pair(edge.dest, dist[edge.dest]));
                    }
                }
            }
        }
        int i = 0;
        for (int dis : dist) {
            System.out.println(src + "->" + i + "(" + dis + ")");
            i++;
        }
    }

    public static void BellmanFordAlgo(ArrayList<Edge> edgeGraph, int src, int V) {
        int[] dist = new int[V];
        for (int i = 0; i < dist.length; i++) {
            if (src != i) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        System.out.println(Arrays.toString(dist));
        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : edgeGraph) {
                if (dist[edge.source] != Integer.MAX_VALUE && dist[edge.source] + edge.weight < dist[edge.dest]) {
                    dist[edge.dest] = dist[edge.source] + edge.weight;
                }
            }
            System.out.println(Arrays.toString(dist));
        }
        System.out.println();
        int i = 0;
        for (int dis : dist) {
            System.out.println(src + "->" + i + "(" + (dis == Integer.MAX_VALUE ? null : dis) + ")");
            i++;
        }
    }

    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[5];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Undirected graphs
        // // 0 node
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
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, -4));
        graph[2].add(new Edge(2, 3, 2));
        graph[3].add(new Edge(3, 4, 4));
        graph[4].add(new Edge(4, 1, -1));

        // Biparte graph -> acyclic and cyclic with even number of nodes
        // Non - Biparte graph -> cyclic with odd number of nodes
        // topSort(graph);

        // The time complexity for the findpath is O(v^v) which is a exponential
        // for the worst case there will be v vertesis from the curnt vertex
        // findPath(graph, 5, 1, "");
        // for (int i = 0; i < graph.length; i++) {
        // System.out.println("From the source " + i);
        // DijkstraAlgo(graph, i);
        // System.out.println();
        // }
        ArrayList<Edge> edgeGraph = new ArrayList<>();
        for (ArrayList<Edge> list : graph) {
            for (Edge edge : list) {
                edgeGraph.add(edge);
            }
        }
        BellmanFordAlgo(edgeGraph, 0, graph.length);
    }
}
