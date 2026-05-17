class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis){
        vis[i] = true;
        for(int ele:adj.get(i)){
            if(!vis[ele]) dfs(adj,ele,vis);
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] arr:edges){
            int u = arr[0];
            int v = arr[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        dfs(adj,source,vis);
        return vis[destination];
    }
}