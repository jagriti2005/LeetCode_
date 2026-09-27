class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            char ch = s.charAt(i);

            if(ch != '(') st.push(ch);
            else{
                StringBuilder sb = new StringBuilder();
                while(st.peek() != ')'){
                    sb.append(st.pop());
                }
                st.pop();
                sb.reverse();

                for(int j=sb.length()-1;j>=0;j--) st.push(sb.charAt(j));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());
        
        return sb.toString();
    }
}