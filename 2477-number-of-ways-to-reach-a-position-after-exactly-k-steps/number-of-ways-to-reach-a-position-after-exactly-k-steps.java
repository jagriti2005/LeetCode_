class Solution {
    Integer[][] dp;
    static int MOD = 1000000007;
    public int solve(int i, int s, int e, int k){
        if(i==k){
            if(s==e) return 1;
            return 0;
        }

        if(dp[i][s+1000]!= null) return dp[i][s+1000];

        int left = solve(i+1,s-1,e,k);
        int right = solve(i+1,s+1,e,k);
        return dp[i][s+1000] = (left+right) % MOD;
    }
    public int numberOfWays(int startPos, int endPos, int k) {
        dp = new Integer[2001][3001];
        return solve(0,startPos, endPos, k);
    }
}