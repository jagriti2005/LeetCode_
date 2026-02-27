class Solution {
    class Pair{
        int node;
        double prob;
        Pair(int node,double prob){
            this.node = node;
            this.prob = prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {   
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }       
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];   
            adj.get(u).add(new Pair(v, prob));
            adj.get(v).add(new Pair(u,prob));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder((a, b) -> Double.compare(a.prob,b.prob))); 
        double[] ans = new double[n];
        ans[start] = 1.0;    
        pq.add(new Pair(start,1)); 
        while (pq.size()>0) {
            Pair top = pq.poll();
            int node = top.node;
            double prob = top.prob;
            if(prob > ans[node]) continue;
            for(Pair p:adj.get(node)){
                double totalprob = prob * p.prob;
                if(totalprob > ans[p.node]){
                    ans[p.node] = totalprob;
                    pq.add(new Pair(p.node, totalprob));
                }
            }
        }  
        return ans[end];
    }
}