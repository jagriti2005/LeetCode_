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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            List<String> arr = accounts.get(i);
            for(int j=1;j<arr.size();j++){
                String email = arr.get(j);
                if(!map.containsKey(email)) map.put(email,i);
                else union(i,map.get(email));
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(new ArrayList<>());
        }
        for(String key:map.keySet()){
            int parent = find(map.get(key));
            ans.get(parent).add(key);
        }

        List<List<String>> res = new ArrayList<>();
        for(int i=0;i<ans.size();i++){
            if(ans.get(i).size() == 0) continue;
            Collections.sort(ans.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(ans.get(i));
            res.add(temp);
        }
        return res;
    }
}