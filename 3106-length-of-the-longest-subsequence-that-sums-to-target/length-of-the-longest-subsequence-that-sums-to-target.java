class Solution {
    public int strLen(List<Integer> nums, int target, int i, int[][] dp){
        if(i==nums.size()){
            if(target==0) return 0;
            else return -1000000;
        }

        if(dp[i][target] != -1) return dp[i][target];

        int skip = strLen(nums,target,i+1,dp);

        int take = -1000000;
        if(target-nums.get(i) >= 0) take = 1+strLen(nums,target-nums.get(i),i+1,dp);

        return dp[i][target] = Math.max(skip,take);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[][] dp = new int[n][target+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        int ans = strLen(nums,target,0,dp);;
        if(ans < 0) return -1;
        return ans;
    }
}