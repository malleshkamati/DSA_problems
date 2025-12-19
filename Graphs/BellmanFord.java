package DSA_problems.Graphs;

import java.util.Arrays;

public class BellmanFord {
    
    public int[] bellmanFord(int V, int[][] edges, int src) {
        
        int inf=(int) Math.pow(10,8);
        int[] ans=new int[V];
        Arrays.fill(ans,inf);
        ans[src]=0;
        
        
        for(int i=0;i<V;i++){
            
            for(int j=0;j<edges.length;j++){
                
                int[]e=edges[j];
                
                int u=e[0];int v=e[1];int w=e[2];
                
                if(ans[u]!=inf&&ans[u]+w<ans[v]){
                    ans[v]=ans[u]+w;
                    
                }
                
            }
        }
        
        for(int i=0;i<1;i++){
            
            for(int j=0;j<edges.length;j++){
                
                int[]e=edges[j];
                
                int u=e[0];int v=e[1];int w=e[2];
                
                if(ans[u]!=inf&&ans[u]+w<ans[v]){
                    ans[v]=ans[u]+w;
                    
                    return new int[]{-1};
                    
                }
                
            }
        }
        
        return ans;
        
        
    }

    public static void main(String[] args) {

        BellmanFord obj = new BellmanFord();

        // GFG Test Case
        int V = 5;
        int[][] edges = {
            {0, 1, -1},
            {0, 2, 4},
            {1, 2, 3},
            {1, 3, 2},
            {1, 4, 2},
            {3, 2, 5},
            {3, 1, 1},
            {4, 3, -3}
        };

        int src = 0;

        int[] res = obj.bellmanFord(V, edges, src);
        if (res.length == 1 && res[0] == -1) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < V; i++) {
                System.out.print(res[i] + " ");
            }
        }
    }
}
