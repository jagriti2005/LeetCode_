class Solution {
    class Tuple{
        int node,costs,stops;
        Tuple(int node,int costs,int stops){
            this.node = node;
            this.costs = costs;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Tuple>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Tuple(flights[i][1],flights[i][2],0));
        }
        Queue<Tuple> pq = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        pq.add(new Tuple(src,0,0));
        dist[src] = 0;
        while(pq.size()>0){
            Tuple top = pq.remove();
            int currNode = top.node;
            int currCost = top.costs;
            int currStop = top.stops;
            if(currStop == k+1) continue;
            for(Tuple ele:adj.get(currNode)){
                int totalCost = currCost + ele.costs;
                if(totalCost < dist[ele.node]){
                    dist[ele.node] = totalCost;
                    pq.add(new Tuple(ele.node,totalCost,currStop+1));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}