class Solution {
    class DSU{
        int[] parent,size;
        DSU(int n){
            parent = new int[n];
            size = new int[n];

            for(int i=0;i<n;i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int x){
            if(parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }
        void union(int a,int b){
            a = find(a);
            b = find(b);
            if(a == b) return;
            if(size[a] < size[b]){
                parent[a] = b;
                size[b] += size[a];
            }else{
                parent[b] = a;
                size[a] += size[b];
            }
        }
    }

    int[] rowD = {-1,1,0,0};
    int[] colD = {0,0,-1,1};

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DSU dsu = new DSU(n*n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j] == 1){

                    for(int k=0;k<4;k++){

                        int ni = i + rowD[k];
                        int nj = j + colD[k];

                        if(ni>=0 && nj>=0 && ni<n && nj<n && grid[ni][nj]==1){

                            int a = i*n + j;
                            int b = ni*n + nj;

                            dsu.union(a,b);
                        }
                    }
                }
            }
        }

        int max = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j] == 0){

                    HashSet<Integer> set = new HashSet<>();
                    int area = 1;

                    for(int k=0;k<4;k++){

                        int ni = i + rowD[k];
                        int nj = j + colD[k];

                        if(ni>=0 && nj>=0 && ni<n && nj<n && grid[ni][nj]==1){

                            int parent = dsu.find(ni*n + nj);

                            if(!set.contains(parent)){
                                set.add(parent);
                                area += dsu.size[parent];
                            }
                        }
                    }

                    max = Math.max(max,area);
                }
            }
        }

        for(int i=0;i<n*n;i++){
            if(dsu.find(i) == i)
                max = Math.max(max, dsu.size[i]);
        }

        return max;
    }
}