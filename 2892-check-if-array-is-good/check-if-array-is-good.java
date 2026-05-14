class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int maxVal = n-1;

        if(nums[n-1] != maxVal || nums[n-2] != maxVal) return false;

        for(int i=0;i<n-1;i++){
            if(nums[i] != i+1 && i < n-1){
                if(i==n-2) continue;
                return false;
            }
        }
        return true;
    }
}