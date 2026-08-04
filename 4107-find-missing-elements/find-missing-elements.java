class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int s = nums[0];
        int e = nums[nums.length-1];


        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int n:nums) set.add(n);

        for(int i=s;i<=e;i++){
            if(!set.contains(i)) ans.add(i);
        }
        return ans;
    }
}