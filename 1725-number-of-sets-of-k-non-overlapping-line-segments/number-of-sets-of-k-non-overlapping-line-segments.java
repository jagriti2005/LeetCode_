class Solution {
    public int numberOfSets(int n, int k) {
        long[][] dp = new long[n + k][2 * k + 1];
        long MOD = 1000000007;

        dp[0][0] = 1;

        for (int i = 0; i < n + k - 1; i++) {
            for (int j = 0; j <= 2 * k; j++) {
                dp[i + 1][j] = (dp[i + 1][j] + dp[i][j]) % MOD;

                if (j < 2 * k) {
                    dp[i + 1][j + 1] =
                        (dp[i + 1][j + 1] + dp[i][j]) % MOD;
                }
            }
        }

        return (int) dp[n + k - 1][2 * k];
    }
}