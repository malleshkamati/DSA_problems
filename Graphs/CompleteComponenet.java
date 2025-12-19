package DSA_problems.Graphs;

import java.util.*;
// You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.

// Return the number of complete connected components of the graph.

// A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.

// A connected component is said to be complete if there exists an edge between every pair of its vertices.

public class CompleteComponenet {
    
    public int countCompleteComponents(int n, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> lst=new ArrayList<>();
        boolean[] visited=new boolean[n];

        for(int i=0;i<n;i++){
            lst.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            lst.get(edges[i][0]).add(edges[i][1]);
            lst.get(edges[i][1]).add(edges[i][0]);
        }

        int count=0;
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                List<Integer> t=dfs(lst,visited,i,new ArrayList<>());
                if(isCompleteConnected(lst,t)){
                count++;}
            }
        }

        return count;

    }


    List<Integer>  dfs(ArrayList<ArrayList<Integer>> lst,boolean[] visited,int node,List<Integer> nodelist){
        
        visited[node]=true;
        nodelist.add(node);
        for(int nei:lst.get(node)){
            if(!visited[nei]){
                dfs(lst,visited,nei,nodelist);
            }
        }

        return nodelist;
    }

    boolean isCompleteConnected(ArrayList<ArrayList<Integer>> lst,List<Integer> nodelist){
        int count=0;
        for(int ele:nodelist){
            count+=lst.get(ele).size();
        }

        
        int required=nodelist.size()*(nodelist.size()-1);

        return count==required;
    }

    public static void main(String[] args) {
        CompleteComponenet cc = new CompleteComponenet();

        // Example 1
        int n1 = 6;
        int[][] edges1 = {
            {0, 1}, {0, 2}, {1, 2}, // complete component (0,1,2)
            {3, 4}                  // not complete
        };

        int result1 = cc.countCompleteComponents(n1, edges1);
        System.out.println("Complete Components" + result1); 

        // Example 2
        int n2 = 4;
        int[][] edges2 = {
            {0, 1}, {1, 2}, {2, 0}, // complete
            {3, 3}                  // single node
        };

        int result2 = cc.countCompleteComponents(n2, edges2);
        System.out.println("Complete Components" + result2);
    }
}
