class Solution {
    public boolean dfs(int[] arr, int idx, boolean[] vis){
        if(idx<0 || idx>=arr.length) return false;
        if(vis[idx]) return false;

        if(arr[idx] == 0) return true;

        vis[idx] = true;
        int forward = idx + arr[idx];
        int backward = idx - arr[idx];

        return dfs(arr,forward,vis) || dfs(arr,backward,vis);
    }
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] vis = new boolean[n];
        return dfs(arr,start,vis);
    }
}