class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(nums.length == 1) return nums[0];
        return Math.max(amount(nums,0,n-2),amount(nums,1,n-1));
    }
    public int amount(int[] nums,int start,int end){
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        if(start+1<=end){
            dp[start+1] = Math.max(nums[start],nums[start+1]);
        } 
        for(int i =start+2;i<=end ;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[end];
    }
}