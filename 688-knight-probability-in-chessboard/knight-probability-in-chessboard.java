class Solution {
    int[][] dir = {
        {-2,-1},
        {-2,1},
        {-1,2},
        {-1,-2},
        {1,-2},
        {2,-1},
        {2,1},
        {1,2}
    };
    Double[][][] dp;
    public double solve(int n, int move, int r, int c){
        if(move == 0) return 1.0;
        if(dp[r][c][move] != null) return dp[r][c][move];

        double ans = 0;

        for(int[] d:dir){
            int nr = d[0]+r;
            int nc = d[1]+c;

            if(nr>=0 && nr<n && nc>=0 && nc<n){
                ans += solve(n, move-1, nr, nc) / 8.0;
            }
        }
        return dp[r][c][move] = ans;
    }
    public double knightProbability(int n, int k, int row, int column) {
        dp = new Double[n+1][n+1][k+1];
        return solve(n,k,row,column);
    }
}