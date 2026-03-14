class Solution {
    public boolean isPossible(int[] nums,int k,int capacity){
        int split = 1;
        int sum = 0;
        for(int n:nums){
            if(sum+n > capacity){
                split++;
                sum = n;
            }
            else sum+=n;
        }
        return split <= k;
    }
    public int splitArray(int[] nums, int k) {
        int start = 1;
        int end = 0;
        int ans = 0;
        for(int n:nums){
            start = Math.max(start,n);
            end += n;
        }
        while(start<=end){
            int mid = (start+end)/2;
            if(isPossible(nums,k,mid)){
                ans = mid;
                end = mid-1;
            }
            else start = mid+1;
        }
        return ans;
    }
}