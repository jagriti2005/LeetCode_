class Solution {
    public boolean validDigit(int n, int x) {
        String num = String.valueOf(n);
        char digit = (char)(x + '0');
        int count = 0;
        if(num.charAt(0) == digit) return false;
        for(int i=1;i<num.length();i++){
            if(num.charAt(i) == digit) count++;
        }
        if(count > 0) return true;
        return false;
    }
}