class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for(int j=1;j<=amount;j++){
            dp[n][j] = Integer.MAX_VALUE;
        }

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=amount;j++){
                int skip = dp[i+1][j];
                int take = Integer.MAX_VALUE;
                if(j >= coins[i] && dp[i][j-coins[i]] != Integer.MAX_VALUE){
                    take = 1 + dp[i][j-coins[i]];
                }
                dp[i][j] = Math.min(skip,take);
            }
        }

        if(dp[0][amount] == Integer.MAX_VALUE) return -1;
        else return dp[0][amount];
    }
}