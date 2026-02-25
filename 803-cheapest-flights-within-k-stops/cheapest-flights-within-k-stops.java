class Solution {
    class Pair{
        int node;
        int cost;
        int stops;
        Pair(int node,int cost,int stops){
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] edges,
                                 int src, int dst, int k) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0], v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new Pair(v,w,0));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,0,0));
        dist[src] = 0;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int node = curr.node;
            int cost = curr.cost;
            int stops = curr.stops;
            if(stops > k) continue;
            for(Pair nei : adj.get(node)){
                int next = nei.node;
                int newCost = cost + nei.cost;
                if(newCost < dist[next]){
                    dist[next] = newCost;
                    q.add(new Pair(next, newCost, stops+1));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}