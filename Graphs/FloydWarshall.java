package DSA_problems.Graphs;
// You are given a weighted directed graph, represented by an adjacency matrix, dist[][] of size n x n, where dist[i][j] represents the weight of the edge from node i to node j. If there is no direct edge, dist[i][j] is set to a large value (i.e., 108) to represent infinity.
// The graph may contain negative edge weights, but it does not contain any negative weight cycles.

// Your task is to find the shortest distance between every pair of nodes i and j in the graph.

// Note: Modify the distances for every pair in place.
public class FloydWarshall {
    public void floydWarshall(int[][] dist) {
        // Code here
        for(int mid=0;mid<dist.length;mid++){
                
                for(int start=0;start<dist.length;start++){
                    
                    for(int end=0;end<dist.length;end++){
                        
                        if(dist[start][mid]!=100000000&&dist[mid][end]!=100000000){
                        dist[start][end]=Math.min(dist[start][end],dist[start][mid]+dist[mid][end]);}
                    }
                }
            }
    }
    public static void main(String[] args) {

        int INF = 100000000;

        int[][] dist = {
            {0,   5,  INF, 10},
            {INF, 0,   3,  INF},
            {INF, INF, 0,   1},
            {INF, INF, INF, 0}
        };

        FloydWarshall obj = new FloydWarshall();
        obj.floydWarshall(dist);

        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
