class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int k=1;k<=n;k++){
            if(n%k == 0){
                if(isValid(nums,n,k)) totalSum += k;
            }
        }
        return totalSum;
    }
    public boolean isValid(int[] nums, int n, int k){
        int prevMax = -1;
        for(int i=0;i<n;i+=k){
            int val = 0;
            int idx = -1;

            for(int j=0;j<k;j++){
                int curr = nums[i+j];
                int next = nums[i+(j+1)%k];

                if(curr>next){
                    val++;
                    idx = j;
                }
            }
            if(val>1) return false;
            int currMin,currMax;
            if(val==0){
                currMin = nums[i];
                currMax = nums[i+k-1];
            }
            else{
                currMin = nums[i+(idx+1)%k];
                currMax = nums[i+idx];
            }
            if(currMin<prevMax) return false;
            prevMax = currMax;
        }
        return true;
    }
}