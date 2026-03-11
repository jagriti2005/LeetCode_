class Solution {
    static int[] parent,size;
    public int find(int u){
        if(parent[u] == u) return u;
        return parent[u] = find(parent[u]);
    }
    public void union(int u,int v){
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
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        for(int[] arr:connections){
            union(arr[0],arr[1]);
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(parent[i] == i) count++;
        }
        return count-1;
    }
}