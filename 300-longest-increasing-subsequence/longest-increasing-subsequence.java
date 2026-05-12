class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                int skip = dp[i+1][j];
                int take = 0;
                if(j==0 || nums[i] > nums[j-1]) take = 1 + dp[i+1][i+1];
                dp[i][j] = Math.max(take,skip);
            }
        }
        return dp[0][0];
    }
}