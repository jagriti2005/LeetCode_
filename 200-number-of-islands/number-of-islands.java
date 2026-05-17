class Solution {
    public void dfs(char[][] grid, int i, int j, boolean[][] vis){
        int n = grid.length;
        int m = grid[0].length;

        if(i<0 || i>= n || j<0 || j>=m || grid[i][j] != '1' || vis[i][j]) return;
        
        vis[i][j] = true;

        dfs(grid,i+1,j,vis);
        dfs(grid,i,j+1,vis);
        dfs(grid,i-1,j,vis);
        dfs(grid,i,j-1,vis);
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        
        int count = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    count++;
                    dfs(grid,i,j,vis);
                }
            }
        }
        return count;
    }
}