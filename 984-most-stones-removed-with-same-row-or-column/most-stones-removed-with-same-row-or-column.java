class Solution {
    static int[] parent,size;
    public int find(int u){
        if(parent[u] == u) return u;
        return parent[u] = find(parent[u]);
    }
    public void union(int u,int v){
        u = find(u);
        v = find(v);
        if(find(u)==find(v)) return;
        if(size[u] > size[v]){
            parent[v] = u;
            size[u] += size[v];  
        }
        else{
            parent[u] = v;
            size[v] += size[u]; 
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        for(int i=0;i<n;i++){
            int row = stones[i][0];
            int col = stones[i][1];
            for(int j=i+1;j<n;j++){
                int currRow = stones[j][0];
                int currCol = stones[j][1];
                if(currRow == row || currCol == col) union(i,j);
            }
        }
        int count = 0;
        int maxSize = 0;
        for(int i=0;i<n;i++){
            if(parent[i] == i){
                count ++;
                maxSize += size[i];
            }
        }
        return maxSize - count;
    }
}