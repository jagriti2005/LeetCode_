class Solution {
    public boolean isPalindrome(String sub){
        int left = 0, right = sub.length()-1;
        while(left < right){
            if(sub.charAt(left) != sub.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        String result = "";

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                String sub = s.substring(i,j+1);

                if(isPalindrome(sub) && sub.length() > result.length()) result = sub;
            }
        }
        return result;
    }
}