class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int j=0;j<n;j++){
            dp[n-1][j] = matrix[n-1][j];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int down = dp[i+1][j];
                int leftDiagonal = (j>0) ? dp[i+1][j-1] : Integer.MAX_VALUE;
                int rightDiagonal = (j<n-1) ? dp[i+1][j+1] : Integer.MAX_VALUE;
                dp[i][j] = matrix[i][j] + Math.min(down,Math.min(rightDiagonal,leftDiagonal));
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int arr:dp[0]){
            ans = Math.min(ans,arr);
        }
        return ans;
    }
}