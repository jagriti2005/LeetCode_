class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch != ']') st.push(ch);
            else{
                StringBuilder sb = new StringBuilder();
                while(st.peek() != '['){
                    sb.append(st.pop());
                }
                st.pop();
                sb.reverse();

                int k = 0;
                int base = 1;
                while(!st.empty() && Character.isDigit(st.peek())){
                    k = (st.pop() - '0') * base + k;
                    base = base*10;
                }

                while(k-- > 0){
                    for(int i = 0; i<sb.length();i++){
                        st.push(sb.charAt(i));
                    }
                }
            }
        }
        char[] result = new char[st.size()];
        for(int i = st.size()-1; i>=0; i--){
            result[i] = st.pop();
        }
        return new String(result);
    }
}