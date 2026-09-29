class Solution {
    boolean[][][] dp;
    int m, n;

    public boolean solve(int i, int j, int check, char[][] grid){
        if(check < 0) return false;
        if(i==m-1 && j==n-1) return check==0 && grid[i][j]==')';

        if(dp[i][j][check]) return false;
        dp[i][j][check] = true;

        if(i+1 < m){
            int newCheck = check;
            if(grid[i+1][j] == '(') newCheck++;
            else newCheck--;
            if(solve(i+1,j,newCheck,grid)) return true;
        }
        if(j+1 < n){
            int newCheck = check;
            if(grid[i][j+1] == '(') newCheck++;
            else newCheck--;
            if(solve(i,j+1,newCheck,grid)) return true;
        }

        return false;
    }
    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        if((m+n-1)%2 != 0) return false;

        if(grid[0][0] != '(') return false;

        dp = new boolean[m][n][m+n+1];

        return solve(0,0,1,grid);
    }
}