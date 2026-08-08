class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int maxLen = 0;
        int start = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(fruits[i])) map.put(fruits[i],map.get(fruits[i])+1);
            else map.put(fruits[i],1);

            while(map.size() > 2){
                map.put(fruits[start], map.get(fruits[start])-1);
                if(map.get(fruits[start]) == 0) map.remove(fruits[start]); 
                start++;
            }
            maxLen = Math.max(maxLen, i-start+1);
        }
        return maxLen;
    }
}