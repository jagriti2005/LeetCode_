// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[][] dp = new int[n+1][n+1];
//         for(int i=n-1;i>=0;i--){
//             for(int j=i-1;j>=-1;j--){
//                 int take = 0;
//                 if(j==-1 || nums[i] > nums[j]) take = 1 + dp[i+1][i+1];
//                 int skip = dp[i+1][j+1];
//                 dp[i][j+1] = Math.max(take,skip);
//             }
//         }
//         return dp[0][0];
//     }
// }


class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]) dp[i] = Math.max(dp[i],dp[j]);
            }
            dp[i] += 1;
            maxLen = Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }
}