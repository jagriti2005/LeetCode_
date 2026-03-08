class Solution {
    class Pair{
        int node,w;
        Pair(int node,int w){
            this.node = node;
            this.w = w;
        }
    }
    public int countRestrictedPaths(int n, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr: edges){
            int u=arr[0],v=arr[1],w=arr[2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.w-b.w);
        pq.add(new Pair(n,0));
        dist[n] = 0;
        while(pq.size()>0){
            Pair curr = pq.remove();
            if(curr.w > dist[curr.node]) continue;
            for(Pair ele:adj.get(curr.node)){
                if(ele.w + curr.w < dist[ele.node]){
                    dist[ele.node] = ele.w+curr.w;
                    pq.add(new Pair(ele.node,dist[ele.node]));
                }
            }
        }

        Integer[] nodes = new Integer[n];
        for(int i=0;i<n;i++) nodes[i] = i+1;
        Arrays.sort(nodes,(a,b)->dist[a]-dist[b]);

        int MOD = 1_000_000_007;
        long[] dp = new long[n+1];
        dp[n] = 1;
        for(int node : nodes){
            for(Pair nei : adj.get(node)){
                if(dist[nei.node] > dist[node]){
                    dp[nei.node] = (dp[nei.node] + dp[node]) % MOD;
                }
            }
        }
        return (int)dp[1];
    }
}