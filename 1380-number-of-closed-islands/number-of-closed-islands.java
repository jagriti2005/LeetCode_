class Solution {
    boolean isClosed;
    public void dfs(int[][] grid, int i, int j, boolean[][] vis){
        int n = grid.length;
        int m = grid[0].length;

        if(i<0 || i>=n || j<0 || j>=m || grid[i][j] != 0 || vis[i][j]) return;

        vis[i][j] = true;

        if(i==0 || i==n-1 || j==0 || j==m-1) isClosed = false;

        dfs(grid,i+1,j,vis);
        dfs(grid,i,j+1,vis);
        dfs(grid,i-1,j,vis);
        dfs(grid,i,j-1,vis);
    }
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int count = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0 && !vis[i][j]){
                    isClosed = true;
                    dfs(grid,i,j,vis);
                    if(isClosed) count++;
                }
            }
        }
        return count;
    }
}