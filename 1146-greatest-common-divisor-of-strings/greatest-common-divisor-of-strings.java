class Solution {
    public int gcd(int a, int b){
        return (b==0) ? a : gcd(b,a%b);
    }
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) return "";

        int m = str1.length();
        int n = str2.length();

        int len = gcd(m,n);

        return str1.substring(0,len); 
    }
}