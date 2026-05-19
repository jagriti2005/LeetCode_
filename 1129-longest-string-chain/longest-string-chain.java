class Solution {
    public boolean isPred(String a, String b){
        if(a.length() != b.length()+1) return false;

        int i=0,j=0;

        while(i<a.length()){
            if(j<b.length() && a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }

        return j==b.length();
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> Integer.compare(a.length(), b.length()));
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        
        int maxLen = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(isPred(words[i], words[j])){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}