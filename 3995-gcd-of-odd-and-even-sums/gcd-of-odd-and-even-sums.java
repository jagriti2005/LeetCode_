class Solution {
    public int gcd(int a, int b){
        return (b==0) ? a : gcd(b, a%b);
    }
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0;
        int sumEven = 0;

        int temp = n;
        int i = 2;

        while(temp > 0){
            sumEven += i;
            i += 2;
            temp--;
        }

        int j = 1;

        while(n > 0){
            sumOdd += j;
            j += 2;
            n--;
        }

        return gcd(sumOdd, sumEven);
    }
}