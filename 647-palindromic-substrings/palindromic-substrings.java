class Solution {
    public int expand(String s, int left, int right){
        int count = 0;
        while(left >= 0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }

        return count;
    }
    public int countSubstrings(String s) {
        int totalcount = 0;
        for(int i=0;i<s.length();i++){
            totalcount += expand(s,i,i);
            totalcount += expand(s,i,i+1);
        } 
        return totalcount;
    }
}