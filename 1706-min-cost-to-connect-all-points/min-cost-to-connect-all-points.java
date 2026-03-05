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
            for(int i=0;i<points.length;i++){
                if(i==top.node) continue;
                int x1 = points[top.node][0], y1 = points[top.node][1];
                int x2 = points[i][0], y2 = points[i][1];
                int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
                pq.add(new Pair(i,dist));
            }
        }
        return cost;
    }
}