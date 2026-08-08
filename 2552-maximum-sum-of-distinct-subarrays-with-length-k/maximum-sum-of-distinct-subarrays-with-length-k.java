class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        long curr = 0;
        int n = nums.length;
        int s = 0;
        int e = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        while(e<n){
            curr += nums[e];
            map.put(nums[e], map.getOrDefault(nums[e],0)+1);

            if(e-s+1 > k){
                curr -= nums[s];
                map.put(nums[s], map.get(nums[s])-1);
                if(map.get(nums[s]) == 0) map.remove(nums[s]);
                s++;
            }

            if(e-s+1==k && map.size()==k) sum = Math.max(sum, curr);
            e++;
        }
        return sum;
    }
}