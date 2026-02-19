class Solution {
    public boolean canFinish(int numCourses, int[][] grid) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<grid.length;i++){
            int u = grid[i][0],v=grid[i][1];
            adj.get(u).add(v);
        }
        int[] indeg = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int ele:adj.get(i)){
                indeg[ele]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        while(q.size()>0){
            int front = q.remove();
            for(int ele:adj.get(front)){
                indeg[ele] --;
                if(indeg[ele]==0){
                    q.add(ele);
                }
            }
        }
        for(int i=0;i<numCourses;i++){
            if(indeg[i] != 0) return false;
        }
        return true;
    }
}