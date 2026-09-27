class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int idx = 0;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int a:nums){
            if(map.containsKey(a)) map.put(a, map.get(a)+1);
            else map.put(a,1);
        }

        while(!map.isEmpty()){
            List<Integer> keys = new ArrayList<>(map.keySet());
            
            for(int key: keys){
                ans[idx] = key;
                int rem = map.get(key)-1;
                if(rem == 0) map.remove(key);
                else map.put(key, rem);

                idx++;
            }
        }
        return ans;
    }
}