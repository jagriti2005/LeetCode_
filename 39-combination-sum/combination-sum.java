class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp= new ArrayList<>();
        backtrack(nums, target , 0, ans, temp); 
        return ans;    
    }

    public void backtrack(int[] nums, int target , int i ,List<List<Integer>> ans , List<Integer> temp){
        if(i>=nums.length || target<0) return;
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(target>0){
            temp.add(nums[i]);
            backtrack(nums, target-nums[i] , i, ans, temp); 
            //take
            // backtrack(nums, target , i+1, ans, temp); 
            temp.remove(temp.size()-1);
        }
        backtrack(nums, target , i+1, ans, temp); 
    }
}