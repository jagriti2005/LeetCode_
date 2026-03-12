class Solution {
    class DSU{
        int[] parent;
        DSU(int n){
            parent = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            if(parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        public void union(int a,int b){
            int pa = find(a);
            int pb = find(b);
            if(pa != pb) parent[pb] = pa;
        }
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        DSU obj = new DSU(n);
        Arrays.sort(edgeList,(a,b)->a[2]-b[2]);
        int q = queries.length;
        int[][] q2 = new int[q][4];
        for(int i=0;i<q;i++){
            q2[i][0] = queries[i][0];
            q2[i][1] = queries[i][1];
            q2[i][2] = queries[i][2];
            q2[i][3] = i;
        }
        Arrays.sort(q2,(a,b)->a[2]-b[2]);
        int j=0;
        boolean[] ans = new boolean[q];
        for(int i=0;i<q;i++){
            int limit = q2[i][2];
            while(j<edgeList.length && edgeList[j][2] < limit){
                obj.union(edgeList[j][0],edgeList[j][1]);
                j++;
            }
            if(obj.find(q2[i][0]) == obj.find(q2[i][1])) ans[q2[i][3]] = true;
        }
        return ans;
    }
}