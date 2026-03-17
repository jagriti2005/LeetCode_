class Solution {
    public void dfs(int[][] graph, int i, List<Integer> path, List<List<Integer>> ans){
        path.add(i);
        if(i==graph.length-1){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int ele: graph[i]){
            dfs(graph,ele,new ArrayList<>(path),ans);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(graph,0,path,ans);
        return ans;
    }
}