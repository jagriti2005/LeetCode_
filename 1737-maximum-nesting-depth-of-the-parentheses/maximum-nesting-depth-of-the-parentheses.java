class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int ans = 0;

        for(char ch:s.toCharArray()){
            if(ch == '('){
                count++;

                if(ans < count) ans = count;
            }
            else if(ch == ')') count--;
        }

        return ans;
    }
}