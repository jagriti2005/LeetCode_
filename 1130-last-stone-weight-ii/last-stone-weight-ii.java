class Solution {
    public int solve(int i, int sum, int[] stones, int total, int[][] dp){
        if(i==stones.length) return Math.abs(total - 2 * sum);
        if(dp[i][sum] != -1) return dp[i][sum];
        int take = solve(i+1, sum + stones[i], stones, total, dp);
        int skip = solve(i+1, sum, stones, total,dp);
        return dp[i][sum] = Math.min(take,skip);
    }
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for (int s : stones) total += s;
        int[][] dp = new int[stones.length][total + 1];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        return solve(0, 0, stones, total, dp);
    }
}