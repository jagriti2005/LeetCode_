class Solution {
    public long solve(int i, int parity, int[] nums, int x, long[][] dp){
        if(i==nums.length) return 0;
        if(dp[i][parity] != -1) return dp[i][parity];

        long skip = solve(i+1,parity,nums,x,dp);
        long panalty = 0;
        if(nums[i]%2 != parity){
            panalty = x;
        }
        else panalty = 0;

        long take = nums[i] - panalty + solve(i+1,nums[i] % 2,nums,x,dp);

        return dp[i][parity] = Math.max(skip,take);
    }
    public long maxScore(int[] nums, int x) {
        long[][] dp = new long[nums.length][2];
        for(long[] arr: dp) Arrays.fill(arr,-1);
        return nums[0] + solve(1,nums[0]%2,nums,x,dp);
    }
}