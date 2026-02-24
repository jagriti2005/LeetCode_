class Solution {
    class Pair{
        int node;
        int weight;
        Pair(int node,int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    public int networkDelayTime(int[][] edges, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0], v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new Pair(v,w));
        }
        int[] ans = new int[n+1];
        Arrays.fill(ans,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        pq.add(new Pair(k,0));
        ans[k] = 0;
        while(pq.size()>0){
            Pair front = pq.poll();
            int currnode = front.node;
            int currdist = front.weight;
            if(currdist > ans[currnode]) continue;
            for(Pair ele:adj.get(currnode)){
                int newNode = ele.node;
                int newDist = ele.weight;
                if (currdist + newDist < ans[newNode]) {
                    ans[newNode] = currdist + newDist;
                    pq.add(new Pair(newNode, ans[newNode]));
                }
            }
        }
        int time = 0;
        for(int i=1;i<=n;i++){
            if(ans[i] == Integer.MAX_VALUE) return -1;
            time = Math.max(time,ans[i]);
        }
        return time;
    }
}