class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        for(int n:nums) set.add(n);

        for(int i=1;i<=nums[nums.length-1];i++){
            if(!set.contains(i)) return i;
        }
        return (nums[nums.length-1] < 1) ? 1 : nums[nums.length-1] + 1;
    }
}