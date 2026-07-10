class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        long curr = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        int s = 0;
        int e = 0;
        while(e<nums.length){
            curr += nums[e];
            if(map.containsKey(nums[e])){
                map.put(nums[e], map.get(nums[e]) + 1);
            }
            else map.put(nums[e],1);

            if(e-s+1 > k){
                curr -= nums[s];
                map.put(nums[s],map.get(nums[s])-1);

                if(map.get(nums[s]) == 0) map.remove(nums[s]);
                s++;
            }

            if(e-s+1==k && map.size() == k) sum = Math.max(sum, curr);
            e++;
        }

        return sum;
    }
}