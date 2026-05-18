class Solution {
    public void dfs(int[][] adj, int i, boolean[] vis){
        vis[i] = true;
        for(int j=0;j<adj.length;j++){
            if(adj[i][j] == 1 && !vis[j]) dfs(adj,j,vis);
        }
    }
    public int findCircleNum(int[][] adj) {
        int n = adj.length;
        int count = 0;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(adj,i, vis);
                count++;
            }
        }
        return count;
    }
}