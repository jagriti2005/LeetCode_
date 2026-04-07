class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return paths(dp,0,0,m,n);
    }
    public int paths(int[][] dp,int row,int col,int m,int n){
        if(row>=m || col>=n) return 0;
        if(row == m-1 && col == n-1) return 1;
        if(dp[row][col] != -1) return dp[row][col];
        int right = paths(dp,row,col+1,m,n);
        int down = paths(dp,row+1,col,m,n);
        return dp[row][col] = right+down;
    }
}