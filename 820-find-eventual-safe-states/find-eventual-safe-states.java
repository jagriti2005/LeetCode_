class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }
        int[] indeg = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            for(int j:graph[i]){
                adj.get(j).add(i);
                indeg[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
                vis[i] = true;
            }
        }
        while(q.size()>0){
            int front = q.remove();
            ans.add(front);
            for(int ele:adj.get(front)){
                indeg[ele]--;
                if(indeg[ele]==0){
                    q.add(ele);
                    vis[ele] = true;
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}