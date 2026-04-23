class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        prefixMax[0] = nums[0];
        for(int i=1;i<n;i++){
            prefixMax[i] = Math.max(nums[i], prefixMax[i-1]);
        }

        int[] prefixMin = new int[n];
        prefixMin[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            prefixMin[i] = Math.min(nums[i], prefixMin[i+1]);
        }

        for(int i=0;i<n;i++){
            int instability = prefixMax[i] - prefixMin[i];
            if(instability <= k) return i;
        }
        return -1;
    }
}