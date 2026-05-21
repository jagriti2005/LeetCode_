class Solution {
    public boolean equalFrequency(String word) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<word.length();i++){
            if(map.containsKey(word.charAt(i))) map.put(word.charAt(i),map.get(word.charAt(i)) + 1);
            else map.put(word.charAt(i),1);
        }

        for(char key:map.keySet()){
            map.put(key,map.get(key)-1);

            HashSet<Integer> set = new HashSet<>();
            for(int value:map.values()){
                if(value > 0) set.add(value);
            }
            if(set.size() == 1) return true;
            
            map.put(key,map.get(key)+1);
        }
        return false;
    }
}