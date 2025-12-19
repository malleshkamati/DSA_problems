package DSA_problems.Graphs;

import java.util.Arrays;

public class BipartateCheck {
    
    public boolean isBipartite(int[][] graph) {
        int[] colors=new int[graph.length];
        Arrays.fill(colors,-1);

        
        for(int i=0;i<colors.length;i++){
            if(colors[i]==-1){
                
                if(!dfs(graph,i,0,colors)){
                    return false;
                }
            }
        }

        return true;



    }
    
    public boolean dfs(int[][] graph,int node,int color,int[]  colors){

            colors[node]=color;

            for(int n:graph[node]){
                if(colors[n]==-1){
                    
                    if(dfs(graph,n,1-color,colors)==false){
                        return false;
                    };
                }else if(colors[n]==color){
                    return false;
                }
            }

            return true;
        }

        public static void main(String[] args) {
        BipartateCheck checker = new BipartateCheck();

        // Bipartite graph
        int[][] graph1 = {
            {1, 3},
            {0, 2},
            {1, 3},
            {0, 2}
        };

        // Non-bipartite graph (odd cycle)
        int[][] graph2 = {
            {1, 2},
            {0, 2},
            {0, 1}
        };

        System.out.println("Graph 1 is Bipartite " + checker.isBipartite(graph1));
        System.out.println("Graph 2 is Bipartite " + checker.isBipartite(graph2));
    }
}
