class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int len = 1;
        int curr = 1;
        // int[] dp = new int[n];
        for(int i=1;i<n;i++){
            if(nums[i] > nums[i-1]) curr++;
            else curr = 1;
            len = Math.max(len,curr);
        }
        return len;
    }
}