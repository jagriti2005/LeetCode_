class Solution {
    class Pair{
        char ch;
        int freq;
        Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    public String reorganizeString(String s) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.freq-a.freq);
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch:s.toCharArray()){
            if(map.containsKey(ch)) map.put(ch,map.get(ch)+1);
            else map.put(ch,1);
        }

        for(char ch:map.keySet()){
            pq.add(new Pair(ch,map.get(ch)));
        }

        while(pq.size() >= 2){
            Pair curr = pq.poll();
            Pair next = pq.poll();
            sb.append(curr.ch);
            sb.append(next.ch);
            if(curr.freq-1 > 0) pq.add(new Pair(curr.ch,curr.freq-1));
            if(next.freq-1 > 0) pq.add(new Pair(next.ch,next.freq-1));     
        }

        while(pq.size() > 0){
            Pair curr = pq.poll();
            if(curr.freq > 1) return "";
            sb.append(curr.ch);
        }

        return sb.toString();
    }
}