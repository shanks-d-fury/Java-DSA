import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphChapter {
    public static class Edge {
        int source, dest, weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static boolean isBiparte(ArrayList<Edge>[] graph) {
        int color[] = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0;
                while (!q.isEmpty()) {
                    int crntQ = q.remove();
                    if (color[crntQ] == -1) {
                        color[crntQ] = 0;
                    }
                    for (Edge edge : graph[crntQ]) {
                        if (color[edge.dest] == -1) {
                            color[edge.dest] = color[crntQ] == 0 ? 1 : 0;
                            q.add(edge.dest);
                        } else if (color[edge.dest] == color[crntQ]) {
                            return false;
                        }
                    }
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[6];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 node
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 2));
        // 1 node
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 3));
        // 2 node
        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 4, 5));
        // 3 node
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 4, 4));
        graph[3].add(new Edge(3, 5, 1));
        // 4 node
        graph[4].add(new Edge(4, 2, 5));
        graph[4].add(new Edge(4, 3, 4));
        graph[4].add(new Edge(4, 5, 3));
        // 5 node
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 3));

        // Biparte graph -> acyclic and cyclic with even number of nodes
        // Non - Biparte graph -> cyclic with odd number of nodes
        System.out.println("\nHas cycle for the current graph : " + isBiparte(graph));

    }
}
