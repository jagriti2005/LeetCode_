class Solution {
    public int longestSubarray(int[] nums) {
        int count = 0;
        int start = 0, end = 0;
        int maxLen = 0;
        while(end<nums.length){
            if(nums[end] == 0) count++;
            while(count > 1){
                if(nums[start]==0) count--;
                start++;
            }
            maxLen = Math.max(maxLen,end-start+1);
            end++;
        }
        return maxLen - 1;
    }
}