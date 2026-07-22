class Solution {
    public boolean canFinish(int num, int[][] grid) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indeg = new int[num];

        for(int i=0;i<num;i++) adj.add(new ArrayList<>());

        for(int[] a : grid){
            int u = a[0], v = a[1];
            adj.get(u).add(v);
            indeg[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<num;i++){
            if(indeg[i] == 0) q.add(i);
        }

        while(q.size() > 0){
            int curr = q.poll();
            for(int ele:adj.get(curr)){
                indeg[ele]--;
                if(indeg[ele] == 0) q.add(ele);
            }
        }

        for(int i=0;i<num;i++){
            if(indeg[i] != 0) return false;
        }

        return true;
    }
}