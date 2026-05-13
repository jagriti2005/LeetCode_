class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            if(map.containsKey(n)) map.put(n,map.get(n)+1);
            else map.put(n,1);
        }
        List<Integer> ans = new ArrayList<>();
        for(int key:map.keySet()){
            if(map.get(key) > 1) ans.add(key);
        }
        return ans;
    }
}