class Solution {
    public void helper(int[] nums, int idx, ArrayList<Integer> list, List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));

        for(int i=idx;i<nums.length;i++){
            list.add(nums[i]);
            helper(nums,i+1,list,ans);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> ans = new ArrayList<>();
       helper(nums,0,new ArrayList<>(),ans);
       return ans; 
    }
}