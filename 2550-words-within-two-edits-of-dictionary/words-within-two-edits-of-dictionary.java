class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for(String query : queries){
            for(String word : dictionary){
                int edit = 0;
                for(int i=0;i<query.length();i++){
                    if(query.charAt(i) != word.charAt(i)) edit++;
                }
                if(edit <= 2){
                    ans.add(query);
                    break;
                }
            }
        }
        return ans;
    }
}