import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scan = new Scanner(System.in);
        int n;
        int m;

        int q = scan.nextInt();

        for(int j = 0; j < q; j++) {

            n = scan.nextInt();
            m = scan.nextInt();

            Graph g = new Graph(n);

            int u;
            int v;
            int s;

            for (int k = 0; k < m; k ++) {
                u = scan.nextInt() - 1;
                v = scan.nextInt() - 1;
                g.addEdge(u, v);
                g.addEdge(v, u);
            }

            s = scan.nextInt() - 1;

            int arry[] = g.BFS(s);

            for (int i = 0; i < arry.length; i++) {
                if (arry[i] != 0) {
                    if (arry[i] == -1) {
                        System.out.print(arry[i] + " ");
                    } else {
                        System.out.print(arry[i] * 6 + " ");
                    }
                }
            }
            System.out.println();
        }



    }
}


class Graph {
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // prints BFS traversal from a given source s
    int[] BFS(int s) {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];
        ArrayList<Integer> path = new ArrayList<Integer>();
        int distance[] = new int[V];
        Arrays.fill(distance, -1);

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        distance[s] = 0;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
//            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    distance[n] = distance[s] + 1;
                    queue.add(n);
                }
            }
        }
        return distance;
    }
}