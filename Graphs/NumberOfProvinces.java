package DSA_problems.Graphs;
// There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

// A province is a group of directly or indirectly connected cities and no other cities outside of the group.

// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

// Return the total number of provinces.

public class NumberOfProvinces {

   public int findCircleNum(int[][] isConnected) {
        int ans=0;
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1){
                    dfs(isConnected,i,j);
                    ans++;
                }
            }
        }

        return ans;
        

    }

    public void dfs(int[][] isConnected,int row, int col){

        if(row<0||col<0||row>=isConnected.length||col>=isConnected[0].length||isConnected[row][col]==0){
            return;
        }
        isConnected[row][col]=0;
        dfs(isConnected,row-1,col);
        dfs(isConnected,row,col-1);
        dfs(isConnected,row+1,col);
        dfs(isConnected,row,col+1);
    }
    public static void main(String[] args) {
        NumberOfProvinces obj = new NumberOfProvinces();

        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };

        int result = obj.findCircleNum(isConnected);
        System.out.println("Number of Provinces: " + result);
    }

}

