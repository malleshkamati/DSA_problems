package DSA_problems.Graphs;

import java.util.*;
// You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
public class RottenOranges {
    static class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

    
    public int orangesRotting(int[][] grid) {
        
        int fresh=0;
        int rotten=0;
        int row=grid.length;
        int col=grid[0].length;

        Queue<Pair<Integer,Integer>> q=new LinkedList<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    fresh++;
                }else if(grid[i][j]==2){
                    rotten++;
                    q.offer(new Pair(i,j));
                }
            }
        }

        int[][] dirs={{1,0},{0,1},{0,-1},{-1,0}};

        if(fresh==0&&rotten==0){
            return 0;
        }

        if(fresh==0){
            return 0;
        }
        int count=0;
        while(!q.isEmpty()){
            count++;
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair<Integer,Integer> cur=q.poll();
                for(int j=0;j<4;j++){
                    int r=cur.getKey()+dirs[j][0];
                    int c=cur.getValue()+dirs[j][1];

                    if(r<0||c<0||r>=row||c>=col||grid[r][c]==0||grid[r][c]==2 ){
                        continue;
                    }
                    grid[r][c]=2;
                    fresh--;
                    q.offer(new Pair(r,c));
                }
            }

            if(fresh==0){
                return count;
            }
        }

        if(fresh>0){
            return -1;
        }

        return count;

    }


    public static void main(String[] args) {

        RottenOranges obj = new RottenOranges();

        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };

        int result = obj.orangesRotting(grid);
        System.out.println("Time taken  to rot all oranges: " + result);
    }
}
