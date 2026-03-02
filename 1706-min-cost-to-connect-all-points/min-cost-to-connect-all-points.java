class Solution {
    class Pair{
        int node;
        int weight;
        Pair(int node,int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<points.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int u = points[i][0], v = points[i][1];
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adj.get(i).add(new Pair(j, dist));
                adj.get(j).add(new Pair(i, dist));
            }
        }
        boolean[] vis = new boolean[points.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.weight-b.weight);
        pq.add(new Pair(0,0));
        int cost = 0;
        while(pq.size()>0){
            Pair top = pq.poll();
            if(!vis[top.node]){
                cost += top.weight;
                vis[top.node] = true;
            }
            else continue;
            for(Pair ele:adj.get(top.node)){
                pq.add(new Pair(ele.node,ele.weight));
            }
        }
        return cost;
    }
}