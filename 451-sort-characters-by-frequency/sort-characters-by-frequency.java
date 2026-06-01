class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch:s.toCharArray()){
            if(map.containsKey(ch)) map.put(ch,map.get(ch)+1);
            else map.put(ch,1);
        }
        List<Character>[] list = new List[s.length()+1];
        for(char key:map.keySet()){
            int freq = map.get(key);
            if(list[freq]==null) list[freq] = new ArrayList<>();
            list[freq].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i] != null) {
                for (char ch : list[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(ch);
                    }
                }
            }
        }
        return sb.toString();
    }
}