class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int n = parent.length;

        // Build adjacency list
        ArrayList<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        // Find depth of every node using BFS
        int[] depth = new int[n];

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        depth[0] = 1;

        int height = 1;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int child : tree[node]) {
                depth[child] = depth[node] + 1;

                height = Math.max(height, depth[child]);

                q.offer(child);
            }
        }

        // Calculate weighted sum
        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans += (long) nums[i] * (height - depth[i] + 1);
        }

        return ans;
    }
}