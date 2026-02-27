class Solution{
    class Pair{
        int node,time,cost;
        Pair(int node,int time,int cost){
            this.node=node;
            this.time=time;
            this.cost=cost;
        }
    }
    public int minCost(int maxTime,int[][] edges,int[] passingFees){
        int n=passingFees.length;
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2],0));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2],0));
        }
        int[][] dist = new int[n][maxTime+1];
        for(int i=0;i<n;i++) Arrays.fill(dist[i],Integer.MAX_VALUE);
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new Pair(0,0,passingFees[0]));
        dist[0][0]=passingFees[0];
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int node=curr.node;
            int time=curr.time;
            int cost=curr.cost;
            if(node==n-1) return cost;
            for(Pair nei:adj.get(node)){
                int newTime=time+nei.time;
                if(newTime<=maxTime){
                    int newCost=cost+passingFees[nei.node];
                    if(newCost<dist[nei.node][newTime]){
                        dist[nei.node][newTime]=newCost;
                        pq.add(new Pair(nei.node,newTime,newCost));
                    }
                }
            }
        }
        return -1;
    }
}