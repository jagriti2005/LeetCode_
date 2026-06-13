class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for(String s:words){
            int sum = 0;
            for(char ch:s.toCharArray()){
                sum += weights[ch-'a'];
            }
            int val = sum % 26;
            char mapping = (char)('z' - val);
            sb.append(mapping);
        }
        return sb.toString();
    }
}