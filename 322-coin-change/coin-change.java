class Solution {
    public long coinCount(int i, int[] coins, int amount, long[][] dp){
        if(i==coins.length){
            if(amount==0) return 0;
            else return Integer.MAX_VALUE;
        }
        if(dp[i][amount] != -1) return dp[i][amount];
        long skip = coinCount(i+1,coins,amount,dp);
        if(amount-coins[i] < 0) return dp[i][amount] = skip;
        long take = 1 + coinCount(i,coins,amount-coins[i],dp);
        return dp[i][amount] = Math.min(skip,take);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        long[][] dp = new long[n][amount+1];
        for(long[] arr:dp){
            Arrays.fill(arr,-1);
        }
        int ans = (int)coinCount(0,coins,amount,dp);
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}