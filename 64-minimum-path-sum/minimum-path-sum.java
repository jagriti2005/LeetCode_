class Solution {
    public int paths(int i, int j, int[][] dp, int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        if(i>=m || j>=n) return Integer.MAX_VALUE;
        if(i==m-1 && j==n-1) return grid[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        int right = paths(i,j+1,dp,grid);
        int down = paths(i+1,j,dp,grid);
        return dp[i][j] = grid[i][j] + Math.min(right,down);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }
        return paths(0,0,dp,grid);
    }
}