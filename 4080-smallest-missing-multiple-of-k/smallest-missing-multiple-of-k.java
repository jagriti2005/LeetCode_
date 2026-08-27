class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int a:nums) set.add(a);

        int ans = k;
        while(set.contains(ans)){
            ans += k;
        }

        return ans;
    }
}