class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        max[0] = nums[0];

        for(int i=1;i<n;i++){
            max[i] = Math.max(nums[i], max[i-1]);
        }

        long[] ans = new long[n];
        for(int i=0;i<n;i++){
            ans[i] = nums[i] + max[i];
        }

        for(int i=1;i<n;i++){
            ans[i] += ans[i-1];
        }

        return ans;
    }
}