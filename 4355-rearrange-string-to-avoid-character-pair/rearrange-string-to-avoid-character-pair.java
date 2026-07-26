class Solution {
    public String rearrangeString(String s, char x, char y) {
        if(s.indexOf(x)==-1 || s.indexOf(y)==-1) return s;

        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int cnt_y = map.get(y);
        int cnt_x = map.get(x);

        StringBuilder sb = new StringBuilder();

        while(cnt_y > 0){
            sb.append(y);
            cnt_y--;
        }

        while(cnt_x > 0){
            sb.append(x);
            cnt_x--;
        }

        for(char ch:s.toCharArray()){
            if(ch!=y && ch!=x) sb.append(ch);
        }

        return sb.toString();
    }
}