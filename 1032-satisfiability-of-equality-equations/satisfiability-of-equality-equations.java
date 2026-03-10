class Solution {
    static int[] parent,size;
    public int find(int u){
        if(parent[u] == u) return u;
        return parent[u] = find(parent[u]);
    }
    public void union(int u,int v){
        int pu = find(u);
        int pv = find(v);
        if(size[pu] > size[pv]){
            parent[pv] = pu;
            size[pu] += size[pv];  
        }
        else{
            parent[pu] = pv;
            size[pv] += size[pu]; 
        }
    }
    public boolean equationsPossible(String[] arr) {
        int n = arr.length;
        parent = new int[26];
        size = new int[26];
        for(int i=0;i<26;i++){
            parent[i] = i;
            size[i] = 1;
        }
        for(int i=0;i<arr.length;i++){
            String s = arr[i];
            if(s.charAt(1) == '='){
                int a = s.charAt(0) - 'a';
                int b = s.charAt(3) -'a';
                union(a,b);
            }
        }

        for(int i=0;i<arr.length;i++){
            String s = arr[i];
            if(s.charAt(1) == '!'){
                int a = s.charAt(0) - 'a';
                int b = s.charAt(3) -'a';
                if(find(a) == find(b)) return false;
            }
        }
        return true;
    }
}