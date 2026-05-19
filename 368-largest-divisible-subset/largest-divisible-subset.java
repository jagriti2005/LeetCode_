class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);

        int[] dp = new int[nums.length];
        int[] parent = new int[nums.length];
        parent[0] = 0;
        Arrays.fill(dp,1); 
        int maxLen = 1;
        int curr = 0;
        for(int i=0;i<nums.length;i++){
            parent[i] = i;
            for(int j=0;j<i;j++){
                if(nums[i] % nums[j] == 0 && dp[j]+1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }

            if(dp[i] > maxLen){
                maxLen = dp[i];
                curr = i;
            }

        }
        
        while(curr != parent[curr]){
            ans.add(nums[curr]);
            curr = parent[curr];
        }
        ans.add(nums[curr]);
        return ans;
    }
}