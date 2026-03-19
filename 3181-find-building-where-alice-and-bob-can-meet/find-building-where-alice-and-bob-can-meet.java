class Solution {
    int[] st;
    public void buildTree(int i, int s, int e, int[] heights){
        if(s == e){
            st[i] = heights[s];
            return;
        }
        int mid = (s + e) / 2;
        buildTree(2*i + 1, s, mid, heights);
        buildTree(2*i + 2, mid + 1, e, heights);
        st[i] = Math.max(st[2*i + 1], st[2*i + 2]);
    }

    public int query(int i, int s, int e, int qs, int target){
        if(e < qs || st[i] <= target) return -1;
        if(s == e) return s;
        int mid = (s + e) / 2;
        int left = query(2*i + 1, s, mid, qs, target);
        if(left != -1) return left;
        return query(2*i + 2, mid + 1, e, qs, target);
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int m = queries.length;
        int[] ans = new int[m];
        st = new int[4*n];
        buildTree(0, 0, n-1, heights);

        for(int i = 0; i < m; i++){
            int a = queries[i][0];
            int b = queries[i][1];
            if(a > b){
                int temp = a;
                a = b;
                b = temp;
            }

            if(a == b) ans[i] = a;
            else if(heights[a] < heights[b]) ans[i] = b; 
            else {
                int target = Math.max(heights[a], heights[b]);
                int res = query(0, 0, n-1, b+1, target);
                ans[i] = (res == -1 ? -1 : res);
            }
        }
        return ans;
    }
}