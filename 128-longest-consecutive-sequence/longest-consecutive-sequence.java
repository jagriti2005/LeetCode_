class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length<=1) return nums.length;
        int count = 1;
        int maxLen = 1;
        int n = nums.length;
        Arrays.sort(nums);

        for(int i=1;i<n;i++){
            if(nums[i] - nums[i-1] == 1){
                count++; 
                maxLen = Math.max(maxLen,count);
            }
            else if(nums[i] - nums[i-1] == 0) continue;
            else count = 1;
        }

        return maxLen;
    }
}