class Solution {
    public void dfs(int[][] grid, int i, boolean[] vis){
        vis[i] = true;
        for(int j=0;j<grid.length;j++){
            if(grid[i][j] == 1 && !vis[j]){
                dfs(grid,j,vis);
            }
        }
    }
    public int findCircleNum(int[][] grid) {
        int n = grid.length;
        boolean[] vis = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(grid,i,vis);
                count++;
            }
        }
        return count;
    }
}