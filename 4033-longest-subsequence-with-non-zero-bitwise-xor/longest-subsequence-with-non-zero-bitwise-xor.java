class Solution {
    public int longestSubsequence(int[] nums) {
        int count = 0;
        boolean notZero = false;

        for(int n:nums){
            count ^= n;
            if(n != 0) notZero = true;
        }

        if(!notZero) return 0;

        return (count != 0) ? nums.length : nums.length-1;
    }
}