class Solution {
    public void backtrack(int[] nums, int target , int i ,List<List<Integer>> ans , List<Integer> temp){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int j=i;j<nums.length;j++){
            if(nums[j] > target) break;

            if(j>i && nums[j]==nums[j-1]) continue;

            temp.add(nums[j]);
            backtrack(nums, target-nums[j] , j+1, ans, temp); 
            temp.remove(temp.size()-1);

        } 
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp= new ArrayList<>();
        backtrack(nums, target , 0, ans, temp); 
        return ans;
    }
}