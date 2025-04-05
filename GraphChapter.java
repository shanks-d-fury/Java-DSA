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

    static boolean[] visited = new boolean[6];

    public static boolean hasCycle(ArrayList<Edge>[] graph) {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) { // return hasCycleUtil(graph, i, -1); should not write like this , if one
                               // component doesn't may be other compenent may have the cycle
                if (hasCycleUtil(graph, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasCycleUtil(ArrayList<Edge>[] graph, int curt, int par) {
        visited[curt] = true;
        for (Edge edge : graph[curt]) {
            if (!visited[edge.dest]) {// here the hascycleutil is not called within the if statement because !visited
                                      // is true and if we call the hascycleutil then , if no cycle is present then
                                      // return false or if present return true , in both case the visited will become
                                      // true and again that checks for the else if statement so we have to write it
                                      // in a inner "if"
                if (hasCycleUtil(graph, edge.dest, curt)) {
                    return true;
                }
            } else if (visited[edge.dest] && edge.dest != par) {
                return true;
            }
        }
        return false;
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
        // graph[3].add(new Edge(3, 4, 4));
        // graph[3].add(new Edge(3, 5, 1));
        // 4 node
        graph[4].add(new Edge(4, 2, 5));
        // graph[4].add(new Edge(4, 3, 4));
        graph[4].add(new Edge(4, 5, 3));
        // 5 node
        // graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 3));

        // BSF traversal
        System.out.println("BSF traversal :");
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int curnt = q.remove();
            if (!visited[curnt]) {
                System.out.print(curnt + " ");
                visited[curnt] = true;
                for (Edge edge : graph[curnt]) {
                    if (!visited[edge.dest]) {
                        q.add(edge.dest);
                    }
                }
            }
        }

        // System.out.println("\nDFS traversal :");
        // DFS(graph, 0);

        // System.out.println("\n\nHAS PATH from 0 to 5: " + hasPath(graph, 0, 5, new
        // boolean[6]));

        System.out.println("\nHas cycle for the current graph : " + hasCycle(graph));

    }
}
