class Solution {
    public static boolean subset(int arr[], int target, int[][] dp, int i){
        if(i==arr.length){
            if(target==0) return true;
            else return false; 
        }
        if(dp[i][target] != -1) return (dp[i][target]==1);
        boolean ans = false;
        boolean skip = subset(arr,target,dp,i+1);
        if(target-arr[i] < 0) ans = skip;
        else{
            boolean take = subset(arr,target - arr[i],dp,i+1);
            ans = take||skip;
        }
        if(ans) dp[i][target] = 1;
        else dp[i][target] = 0;
        return ans;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int e:nums) sum += e;
        if(sum%2!=0) return false;

        int n = nums.length;
        int target = sum/2;
        int[][] dp = new int[n][target+1];
        for(int[] a: dp){
            Arrays.fill(a,-1);
        }
        return subset(nums,target,dp,0);
    }
}