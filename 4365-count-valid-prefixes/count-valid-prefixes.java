class Solution {
    public int countValidPrefixes(String s) {
        int n = s.length();
        int count = 0;

        for(int i=1;i<=n;i++){
            int cnt1 = 0;
            int cnt0 = 0;

            String sub = s.substring(0,i);

            for(int j=0;j<sub.length();j++){
                if(sub.charAt(j)=='0') cnt0++;
                else cnt1++;
            }

            if(Math.abs(cnt1 - cnt0) <= 1) count++;
        }

        return count;
    }
}