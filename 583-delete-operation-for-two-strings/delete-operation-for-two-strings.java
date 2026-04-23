class Solution {
    public int lcs(String s1, String s2, int[][] dp, int i, int j){
        if(i>=s1.length() || j >= s2.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = 1 + lcs(s1,s2,dp,i+1,j+1);
        else dp[i][j] = Math.max(lcs(s1,s2,dp,i+1,j) , lcs(s1,s2,dp,i,j+1));
        return dp[i][j];
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        return (m - lcs(word1,word2, dp, 0,0)) + (n- lcs(word1,word2, dp, 0,0));
    }
}