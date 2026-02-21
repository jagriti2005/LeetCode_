class Solution {
    public int countBits(int n){
        int count = 0;
        while(n>0){
            count += (n&1);
            n >>= 1;
        }
        return count;
    }
    public boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2;i*i <=n;i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for(int i=left;i<=right;i++){
            int bits = countBits(i);
            if(isPrime(bits)) ans++;
        }
        return ans;
    }
}