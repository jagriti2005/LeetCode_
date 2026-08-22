class Solution {
    public boolean checkDivisibility(int n) {
        if(n==0) return true;
        int sum = 0;
        int prd = 1;
        int temp = n;
        while( temp > 0){
            int digit = temp%10;
            sum += digit;
            prd *= digit;
            temp /= 10;
        }
        int total = sum+prd;
        return n % total == 0;
    }
}