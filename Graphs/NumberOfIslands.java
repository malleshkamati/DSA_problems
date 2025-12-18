package DSA_problems.Graphs;
// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of
//  the grid are all surrounded by water.
public class NumberOfIslands {
    
    public int numIslands(char[][] grid) {
        
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }


    public void dfs(char[][] grid,int row, int col){

        if(row<0||col<0||row>=grid.length||col>=grid[0].length||grid[row][col]=='0'){
            return;
        }
        grid[row][col]='0';
        dfs(grid,row-1,col);
        dfs(grid,row,col-1);
        dfs(grid,row+1,col);
        dfs(grid,row,col+1);
    }


    public static void main(String[] args) {

        NumberOfIslands solution = new NumberOfIslands();

        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };

        int result = solution.numIslands(grid);
        System.out.println("Number of Islands: " + result);
    }
}
