class Solution {

    Integer[] dp;
    public int maximumJumps(int[] nums, int target) {
        
        dp = new Integer[nums.length + 1];

        int ans =  solve(0, nums, target);

        return ans == -1 ? -1 : ans;
        
    }

    private int solve(int i, int[] nums, int target){
        if(i == nums.length-1){
            return 0;
        }

        if(dp[i] != null){
            return dp[i];
        }

        int jump = -1;

        for(int j = i + 1; j < nums.length; j++){
            
           
            if(nums[j] - nums[i] >= -target && nums[j] - nums[i] <= target){

                int take = solve(j, nums, target);

                if(take != -1){ 
                    jump = Math.max(1 + take, jump);
                }
            }
        }

        return dp[i] = jump ;
    }
}