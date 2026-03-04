class Solution {
    public int findTheCity(int n, int[][] edges, int t) {
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j] =Integer.MAX_VALUE;
            }
        }
        for(int[] edge:edges){
            int u=edge[0], v=edge[1], wt=edge[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                if(i==k) continue;
                for(int j=0;j<n;j++){
                    if(j==k) continue;
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][k]+dist[k][j],dist[i][j]);
                    }
                }
            }
        }
        int minCity = -1;
        int minCount = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(dist[i][j] <= t) count++;
            }
            if(minCount >= count){
                minCount = count;
                minCity = i;
            }
        }
        return minCity;
    }
}