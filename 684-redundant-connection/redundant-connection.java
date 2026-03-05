class Solution {
    static int[] parent,size;
    public int find(int u){
        if(parent[u] == u) return u;
        return parent[u] = find(parent[u]);
    }
    public void unioun(int u,int v){
        u = find(u);
        v = find(v);
        if(size[u] > size[v]){
            parent[v] = u;
            size[u] += size[v];  
        }
        else{
            parent[u] = v;
            size[v] += size[u]; 
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        int[] ans = new int[2];
        for(int[] arr:edges){
            int u=arr[0], v=arr[1];
            if(find(u) == find(v)){
                ans[0] = u;
                ans[1] = v;
            }
            else unioun(u,v);
        }
        return ans;
    }
}