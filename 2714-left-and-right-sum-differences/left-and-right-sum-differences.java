class Solution {
    public int[] leftRightDifference(int[] nums){
        int[] ans = new int[nums.length];
        ans[0] = 0;
        for(int i=1;i<ans.length;i++){
            ans[i] = ans[i-1] + nums[i-1];
        }
        int suffix = 0;
        for(int i=ans.length-1;i>=0;i--){
            ans[i] = Math.abs(ans[i] - suffix);
            suffix += nums[i];
        }
        return ans;
    }   
}