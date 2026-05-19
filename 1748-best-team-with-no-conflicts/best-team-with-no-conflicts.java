import java.util.*;

class Solution {
    public int solve(int i, int prev, int[][] dp, int[][] player) {
        if (i == player.length) return 0;

        if (dp[i][prev+1] != -1) return dp[i][prev+1];

        int skip = solve(i + 1,prev,dp,player);
        int take = 0;

        if (prev== -1 || player[i][1] >= player[prev][1]) {
            take = player[i][1] + solve(i + 1,i,dp,player);
        }

        return dp[i][prev + 1] = Math.max(take, skip);
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] player = new int[n][2];

        for (int i = 0; i < n; i++) {
            player[i][0] = ages[i];
            player[i][1] = scores[i];
        }

        Arrays.sort(player, (a, b) -> { 
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int[][] dp = new int[n][n + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);

        return solve(0, -1, dp, player);
    }
}