import java.util.*;

public class DijkstraWithPathTrace {

    // Dijkstra algorithm to find the shortest paths from the source
    public static void dijkstra(int n, int[][] edges, int source) {
        // Create adjacency list representation of the graph
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Fill adjacency list with edges
        for (int[] edge : edges) {
            int u = edge[0]; // Start vertex
            int v = edge[1]; // End vertex
            int weight = edge[2]; // Edge weight
            adjList.get(u).add(new int[]{v, weight});
        }

        // Distance array to store the shortest distances from source to each vertex
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        // Previous array to trace the shortest path
        int[] previous = new int[n];
        Arrays.fill(previous, -1);  // Initialize with -1, meaning no previous vertex

        // Priority Queue (Min-Heap) to process the node with the smallest distance first
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{source, 0});

        // Process the priority queue
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];  // Current vertex
            int distU = current[1];  // Current distance

            // For all neighbors of u, try to relax the edge
            for (int[] neighbor : adjList.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                // Relaxation step: if a shorter path is found
                if (distU + weight < distances[v]) {
                    distances[v] = distU + weight;
                    pq.add(new int[]{v, distances[v]});
                    previous[v] = u;  // Update the previous node for vertex v
                }
            }
        }

        // Output the shortest distances and paths from the source
        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("Vertex " + i + " -> Distance: " + distances[i]);
        }

        System.out.println("\nShortest paths from source " + source + ":");
        for (int i = 0; i < n; i++) {
            if (i != source) {
                System.out.print("Path to vertex " + i + ": ");
                printPath(previous, i);
                System.out.println();
            }
        }
    }

    // Utility function to print the path from the source to a given target vertex
    public static void printPath(int[] previous, int target) {
        List<Integer> path = new ArrayList<>();
        for (int at = target; at != -1; at = previous[at]) {
            path.add(at);
        }
        Collections.reverse(path);  // Reverse the path to get it from source to target
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }
    }

    public static void main(String[] args) {
        // Number of vertices
        int n = 6;

        // Graph edges represented as {start vertex, end vertex, weight}
        int[][] edges = {
            {0, 1, 10},
            {0, 2, 3},
            {1, 2, 1},
            {1, 3, 2},
            {2, 1, 4},
            {2, 3, 8},
            {2, 4, 2},
            {3, 4, 7},
            {4, 3, 9}
        };

        // Source vertex
        int source = 0;

        // Run Dijkstra's algorithm and trace the paths
        dijkstra(n, edges, source);
    }
}


/*


Shortest distance calculation: O((V + E) log V)
Shortest path tracing for all vertices: O(V^2) in the worst case (if you trace paths for all vertices).

In the worst case, the graph is dense (i.e., nearly complete), and the number of edges can be up to E = O(V^2)

Shortest distances from source 0:
Vertex 0 -> Distance: 0
Vertex 1 -> Distance: 7
Vertex 2 -> Distance: 3
Vertex 3 -> Distance: 9
Vertex 4 -> Distance: 5

Shortest paths from source 0:
Path to vertex 1: 0 -> 2 -> 1
Path to vertex 2: 0 -> 2
Path to vertex 3: 0 -> 2 -> 3
Path to vertex 4: 0 -> 2 -> 4
Path to vertex 5: 0 -> 2 -> 4 -> 5


*/


