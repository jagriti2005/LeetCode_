class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        int start = 0;
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) == '(') count++;
            else count--;
            if(count == 0){
                String part = s.substring(start+1,i);
                result.append(part);
                start = i+1;
            }
        }
        return result.toString();
    }
}