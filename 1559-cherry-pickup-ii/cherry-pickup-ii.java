class Solution {
    Integer[][][][] dp;

    public int solve(int r1, int c1, int r2, int c2, int R, int C, int[][] grid){
        if(r1>=R || c1<0 || c1>=C || r2>=R || c2<0 || c2>=C) return Integer.MIN_VALUE;

        if(r1==R-1 && r2==R-1){
            if(c1==c2) return grid[r1][c1];
            return grid[r1][c1] + grid[r2][c2];
        }

        if(dp[r1][c1][r2][c2] != null) return dp[r1][c1][r2][c2];

        int cherry;

        if(c1==c2) cherry = grid[r1][c1];
        else cherry = grid[r1][c1] + grid[r2][c2];

        int best = Integer.MIN_VALUE;

        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int next = solve(r1+1,c1+i,r2+1,c2+j,R,C,grid);
                best = Math.max(best, next);
            }
        }

        return dp[r1][c1][r2][c2] = cherry + best;
    }
    public int cherryPickup(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        dp = new Integer[R][C][R][C];

        return solve(0,0,0,C-1, R, C, grid);
    }
}