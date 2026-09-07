class Solution {
    public int numDistinct(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        Integer[][] dp = new Integer[n1][n2];
        return helper(s, t, 0,0, dp);
    }
    public int helper( String s, String t, int i, int j,  Integer[][] dp){
        int n1 = s.length();
        int n2 = t.length();
        if(j == n2){
            return 1;
        }
        if(i == n1){
            return 0;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        
        if(s.charAt(i) == t.charAt(j)){
            int take = helper(s, t, i+1, j+1, dp);
            int nonTake = helper(s, t, i+1, j, dp);

            return dp[i][j] =  take + nonTake;
        }
         return dp[i][j] = helper(s, t, i+1, j, dp);
    }
}