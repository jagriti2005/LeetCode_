class Solution {
    public void dfs(int[][] graph, int i, List<List<Integer>> res, List<Integer> list){
        list.add(i);
        if(i==graph.length-1){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int ele:graph[i]){
            dfs(graph,ele,res,new ArrayList<>(list));
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(graph,0,res,new ArrayList<>());
        return res;
    }
}