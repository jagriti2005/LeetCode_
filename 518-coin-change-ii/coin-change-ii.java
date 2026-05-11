class Solution {
    public int ways(int amount, int[] coins, int i, int[][] dp){
        if(amount == 0) return 1;
        if(i==coins.length) return 0;
        if(dp[i][amount] != -1) return dp[i][amount];
        int skip = ways(amount,coins,i+1,dp);
        int take = 0;
        if(amount >= coins[i]) take = ways(amount-coins[i],coins,i,dp);
        return dp[i][amount] = take + skip;
    }
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        return ways(amount, coins, 0, dp);
    }
}