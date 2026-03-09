class Solution{
    class Pair{
        int node;
        long time;
        Pair(int node,long time){
            this.node=node;
            this.time=time;
        }
    }
    public int countPaths(int n,int[][] roads){
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] r:roads){
            adj.get(r[0]).add(new Pair(r[1],r[2]));
            adj.get(r[1]).add(new Pair(r[0],r[2]));
        }
        long[] dist=new long[n];
        long[] ways=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.time,b.time));
        dist[0]=0;
        ways[0]=1;
        pq.add(new Pair(0,0));
        int MOD=1000000007;
        
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int currNode=curr.node;
            long currDist=curr.time;
            for(Pair ele:adj.get(currNode)){
                int newNode=ele.node;
                long newDist=ele.time;
                if(currDist+newDist<dist[newNode]){
                    dist[newNode]=currDist+newDist;
                    ways[newNode]=ways[currNode];
                    pq.add(new Pair(newNode,dist[newNode]));
                }
                else if(currDist+newDist==dist[newNode]){
                    ways[newNode]=(ways[newNode]+ways[currNode])%MOD;
                }
            }
        }
        return (int)(ways[n-1]%MOD);
    }
}