class Solution {
    static int sum;
    public int ways(int i,int res,int[] arr, int target, int[][] dp) {
        if(i==arr.length){
            if(res==target) return 1;
            else return 0;
        }
        if(dp[i][res+sum] != -1) return dp[i][res+sum];
        int add = ways(i+1,res-arr[i], arr,target,dp);
        int sub = ways(i+1,res+arr[i],arr,target,dp);
        return dp[i][res+sum] = add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        sum = 0;
        for(int num:nums) sum += num;
        int[][] dp = new int[n][2*sum+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return ways(0,0,nums,target,dp);
    }
}