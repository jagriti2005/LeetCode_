class Solution {
    static int[] parent,size;
    public int find(int u){
        if(parent[u] == u) return u;
        return parent[u] = find(parent[u]);
    }
    public void union(int u,int v){
        u = find(u);
        v = find(v);
        if(u==v) return;
        if(size[u] > size[v]){
            parent[v] = u;
            size[u] += size[v];  
        }
        else{
            parent[u] = v;
            size[v] += size[u]; 
        }
    }
    public boolean isSimilar(String a,String b){
        int count = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)){
                count++;
                if(count > 2) return false;
            }
        }
        return true;
    }
    
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isSimilar(strs[i],strs[j])) union(i,j);
            }
        }
        int ans = 0;
        for(int i=0;i<strs.length;i++){
            if(find(i) == i) ans++;
        }
        return ans;
    }
}