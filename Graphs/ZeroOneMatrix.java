package DSA_problems.Graphs;

import java.util.*;
// Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

// The distance between two cells sharing a common edge is 1.
public class ZeroOneMatrix {
    
    public int[][] updateMatrix(int[][] mat) {
        int[][] ans=new int[mat.length][mat[0].length];
        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){

                    q.offer(new int[]{i,j});
                }else{
                    ans[i][j]=-1;
                    
                }
            }
        }

        int[] dx={1,-1,0,0};
        int[] dy={0,0,-1,+1};

        while(!q.isEmpty()){

            int[] temp=q.poll();


            for(int i=0;i<4;i++){
                int x=temp[0]+dx[i];
                int y=temp[1]+dy[i];
                if(x>=0&&y>=0&&x<ans.length&&y<ans[0].length&&ans[x][y]==-1){
                    ans[x][y]=1+ans[temp[0]][temp[1]];
                    q.offer(new int[]{x,y});
                }

            }
        }

        return ans;
    }


    public static void main(String[] args) {

        ZeroOneMatrix obj = new ZeroOneMatrix();

        int[][] mat = {
            {0, 0, 0},
            {0, 1, 0},
            {1, 1, 1}
        };

        int[][] result = obj.updateMatrix(mat);

        System.out.println("Updated Matrix:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

}
