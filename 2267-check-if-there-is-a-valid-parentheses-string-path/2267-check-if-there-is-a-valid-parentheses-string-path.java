class Solution {
    int m;
    int n;
    Boolean[][][] dp;


    public boolean hasValidPath(char[][] grid) {
         m = grid.length;
         n = grid[0].length;

        if((m+n-1)%2!=0) return false;
        if((grid[0][0]==')') || grid[m-1][n-1]=='(') return false;

        dp = new Boolean[m][n][m + n];

        return solve(0,0,0,grid);

    }
    private boolean solve (int i , int j , int openCount, char[][] grid){
        openCount = grid[i][j]=='(' ? openCount+1 : openCount -1;

        if(openCount <0) return false;  

        if((i== m-1) && (j== n-1)){
            return openCount ==0;    
        }

         if (dp[i][j][openCount] != null)
            return dp[i][j][openCount];

        boolean ans = false;


        //move down
        if(i+1 < m){
            if(solve(i+1,j,openCount,grid)) return true;
        }

        //move right
        if(j+1 < n){
            if(solve(i,j+1,openCount,grid)) return true;
        }

        dp[i][j][openCount] = ans;

        //if no answer found then exit
        return false;
    }
}