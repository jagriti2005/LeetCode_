class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;

        if(x==0) return n;
        for(int a:nums) sum += a;

        int target = sum - x;
        if(target < 0) return -1;

        int len = -1;
        int left = 0;
        int currSum = 0;

        for(int right = 0;right<n;right++){
            currSum += nums[right];

            while(currSum > target){
                currSum -= nums[left];
                left++;
            }

            if(currSum == target) len = Math.max(len, right-left+1);
        }

        return (len==-1) ? -1 : n-len;
    }
}