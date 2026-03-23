class Solution {
    public int minRemovals(int[] nums, int target) {
        int n = nums.length;
        Integer[][] dp = new Integer[n + 1][17000];
        int ans =  solve(0, 0, target, nums, dp);
        if(ans < 0) return -1;
        return n - ans;
    }

    public int solve(int idx, int xor, int target, int[] nums, Integer[][] dp){
        if(idx == nums.length){
            if(xor == target){
                return 0;
            }
            return Integer.MIN_VALUE;
        }
        if(dp[idx][xor] != null){
            return dp[idx][xor];
        }
        int nontake = solve(idx + 1, xor, target, nums, dp);
        int take =  1 + solve(idx + 1, xor ^ nums[idx], target, nums, dp);
        return dp[idx][xor] = Math.max(nontake, take);
    }
}