class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        int maxJumps = 0;
        
        for (int i = 0; i < n; i++) {
            maxJumps = Math.max(maxJumps, dfs(arr, d, i, dp));
        }
        
        return maxJumps;
    }
    
    private int dfs(int[] arr, int d, int i, int[] dp) {
        if (dp[i] != 0) {
            return dp[i];
        }
        
        int maxResult = 1;
        int n = arr.length;
        
        for (int x = i + 1; x <= Math.min(i + d, n - 1); x++) {
            if (arr[x] >= arr[i]) {
                break;
            }
            maxResult = Math.max(maxResult, 1 + dfs(arr, d, x, dp));
        }
        
        for (int x = i - 1; x >= Math.max(0, i - d); x--) {
            if (arr[x] >= arr[i]) {
                break;
            }
            maxResult = Math.max(maxResult, 1 + dfs(arr, d, x, dp));
        }
        
        dp[i] = maxResult;
        return maxResult;
    }
}