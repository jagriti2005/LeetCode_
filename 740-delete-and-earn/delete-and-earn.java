class Solution {
    public int solve(int i, int[] sum, int[] dp){
        if(i<=0) return 0;
        if(dp[i] != -1) return dp[i];
        int skip = solve(i-1,sum,dp);
        int take = sum[i] + solve(i-2,sum,dp);
        return dp[i] = Math.max(take,skip);
    }
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num:nums){
            max = Math.max(max,num);
        }
        int[] sum = new int[max+1];
        for(int num:nums){
            sum[num] += num;
        }
        int[] dp = new int[max+1];
        Arrays.fill(dp,-1);
        return solve(max,sum,dp);
    }
}