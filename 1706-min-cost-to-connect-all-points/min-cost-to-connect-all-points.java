class Solution {
    class Tuple{
        int u,v,dist;
        Tuple(int u,int v,int dist){
            this.u = u;
            this.v = v;
            this.dist = dist;
        }
    }

    static int[] parent,size;

    public int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public void union(int a,int b){
        a = find(a);
        b = find(b);
        if(size[a] > size[b]){
            parent[b] = a;
            size[a] += size[b];
        }
        else{
            parent[a] = b;
            size[b] += size[a];
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
                pq.add(new Tuple(i,j,dist));
            }
        }
        int minCost = 0;
        while(pq.size()>0){
            Tuple top = pq.poll();
            if(find(top.u) != find(top.v)){
                minCost += top.dist;
                union(top.u,top.v);
            }
        }
        return minCost;
    }
}