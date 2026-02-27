// class Solution {
//     public boolean canFinish(int numCourses, int[][] grid) {
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         for(int i=0;i<numCourses;i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int i=0;i<grid.length;i++){
//             int u = grid[i][0],v=grid[i][1];
//             adj.get(u).add(v);
//         }
//         int[] indeg = new int[numCourses];
//         for(int i=0;i<numCourses;i++){
//             for(int ele:adj.get(i)){
//                 indeg[ele]++;
//             }
//         }
//         Queue<Integer> q = new LinkedList<>();
//         for(int i=0;i<numCourses;i++){
//             if(indeg[i]==0){
//                 q.add(i);
//             }
//         }
//         while(q.size()>0){
//             int front = q.remove();
//             for(int ele:adj.get(front)){
//                 indeg[ele] --;
//                 if(indeg[ele]==0){
//                     q.add(ele);
//                 }
//             }
//         }
//         for(int i=0;i<numCourses;i++){
//             if(indeg[i] != 0) return false;
//         }
//         return true;
//     }
// }



//dfs
class Solution {
    public void dfs(int i,ArrayList<ArrayList<Integer>> adj,boolean[] vis,boolean[] path,boolean[] ans){
        vis[i] = true;
        path[i] = true;
        for(int ele:adj.get(i)){
            if(path[ele]){
                ans[0] = false;
                return;
            }
            if(!vis[ele]) dfs(ele,adj,vis,path,ans);
        }
        path[i] = false;
    }
    public boolean canFinish(int numCourses, int[][] grid) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<grid.length;i++){
            int u = grid[i][0],v=grid[i][1];
            adj.get(u).add(v);
        }
        boolean[] ans = new boolean[1];
        ans[0] = true;
        boolean[] vis = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i]) dfs(i,adj,vis,path,ans);
        }
        return ans[0];
    }
}