class Solution {
    public int calPoints(String[] operations) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();

        for(String s : operations){
            if(s.equals("C")) st.pop();
            else if(s.equals("D")){
                st.push(2*st.peek());
            }
            else if(s.equals("+")){
                int a = st.pop();
                int add = a + st.peek();
                st.push(a);
                st.push(add);
            }
            else st.push(Integer.parseInt(s));
        }

        while(!st.isEmpty()){
            ans += st.pop();
        }
        return ans;
    }
}