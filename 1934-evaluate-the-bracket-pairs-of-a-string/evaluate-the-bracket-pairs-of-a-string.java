class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();

        for(List<String> list: knowledge){
            map.put(list.get(0), list.get(1));
        }

        StringBuilder ans = new StringBuilder();
        int i = 0;

        while(i<s.length()){
            char ch = s.charAt(i);
            if(ch != '('){
                ans.append(ch);
                i++;
            }
            else{
                int j = i+1;
                StringBuilder sb = new StringBuilder();
                while(s.charAt(j) != ')'){
                    sb.append(s.charAt(j));
                    j++;
                }
                if(map.containsKey(sb.toString())){
                    ans.append(map.get(sb.toString()));
                }
                else ans.append("?");

                i = j+1;
            }
        }

        return ans.toString();
    }
}