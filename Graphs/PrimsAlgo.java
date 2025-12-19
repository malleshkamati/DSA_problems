package DSA_problems.Graphs;

import java.util.*;
// Given a weighted, undirected, and connected graph with V vertices and E edges,
//  your task is to find the sum of the weights of the edges in the Minimum Spanning Tree (MST)
//   of the graph. The graph is provided as a list of edges, where each edge is represented as
//    [u, v, w], indicating an edge between 
// vertex u and vertex v with edge weight w.

public class PrimsAlgo {
   
    public int spanningTree(int V, int[][] edges) {
        
        List<List<int[]>> adjlst=new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adjlst.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            
            adjlst.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]});
            adjlst.get(edges[i][1]).add(new int[]{edges[i][0],edges[i][2]});
        }
        
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        
        boolean[] visited=new boolean[V];
        
        
        pq.offer(new int[]{0,0});
        int cost=0;
        
        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            
            int node=temp[0];
            int weight=temp[1];
            
            if(visited[node]) continue;
            visited[node]=true;
            cost+=weight;
            
            for(int[] p:adjlst.get(node)){
                if(!visited[p[0]]){
                    pq.offer(p);
                }
            }
        }
        
        
        
        
        return cost;
        
        
    }

    public static void main(String[] args) {

        PrimsAlgo obj = new PrimsAlgo();

        int V = 5;
        int[][] edges = {
            {0, 1, 2},
            {0, 3, 6},
            {1, 2, 3},
            {1, 3, 8},
            {1, 4, 5},
            {2, 4, 7},
            {3, 4, 9}
        };

        int mstCost = obj.spanningTree(V, edges);
        System.out.println("MST COST " + mstCost);
    }

}
