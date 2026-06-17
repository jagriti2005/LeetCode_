class Solution {
    public int solve(int i, int j, String s1, String s2, int[][] dp){
        if(i==s1.length()) return s2.length()-j;
        if(j==s2.length()) return s1.length()-i;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = solve(i+1,j+1,s1,s2,dp);
        }
        int insert = 1 + solve(i,j+1,s1,s2,dp);
        int delete = 1 + solve(i+1,j,s1,s2,dp);
        int replace = 1 + solve(i+1,j+1,s1,s2,dp);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        return solve(0,0,word1,word2,dp);
    }
}