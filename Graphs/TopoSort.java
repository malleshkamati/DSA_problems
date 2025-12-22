package DSA_problems.Graphs;

import java.util.*;


public class TopoSort {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjlst=new ArrayList<>();
        int[] indegree=new int[numCourses];
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> topo=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adjlst.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            adjlst.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

       

        for(int i=0;i<adjlst.size();i++){   
            for(int a:adjlst.get(i)){
                indegree[a]++;
            }
        }

       

        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int node=q.peek();
            q.poll();
            topo.add(node);
            for(int it:adjlst.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.offer(it);
                    
                }
            }
        }

        if(topo.size()==numCourses){
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        TopoSort ts = new TopoSort();

        
        int numCourses1 = 4;
        int[][] prerequisites1 = {
            {1, 0},
            {2, 1},
            {3, 2}
        };
        System.out.println(ts.canFinish(numCourses1, prerequisites1)); 

        
        int numCourses2 = 2;
        int[][] prerequisites2 = {
            {1, 0},
            {0, 1}
        };
        System.out.println(ts.canFinish(numCourses2, prerequisites2)); 
    }
}
