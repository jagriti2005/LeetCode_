class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int n = parent.length;

        ArrayList<Integer>[] tree = new ArrayList[n];
        int[] depth = new int[n];

        Queue<Integer> q = new LinkedList<>();
        int height = 1;

        for(int i=0;i<n;i++) tree[i] = new ArrayList<>();
        for(int i=1;i<n;i++){
            tree[parent[i]].add(i);
        }

        q.add(0);
        depth[0] = 1;

        while(q.size() > 0){
            int node = q.poll();

            for(int child: tree[node]){
                depth[child] = depth[node] + 1;
                height = Math.max(height, depth[child]);

                q.add(child);
            }
        }

        long weight = 0;

        for(int i=0;i<n;i++){
            weight += (long) nums[i] * (height - depth[i] + 1);
        }

        return weight;
    }
}