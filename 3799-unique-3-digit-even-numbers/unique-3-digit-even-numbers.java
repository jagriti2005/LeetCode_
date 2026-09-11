class Solution {
    public int totalNumbers(int[] digits) {
        int[] count = new int[10];
        for(int d:digits) count[d]++;

        int total = 0;
        for(int i=100;i<=998;i+=2){
            int d1 = i/100;
            int d2 = (i/10)%10;
            int d3 = i%10;

            int[] need = new int[10];
            need[d1]++;
            need[d2]++;
            need[d3]++;

            if(need[d1] <= count[d1] && need[d2] <= count[d2] && need[d3] <= count[d3]) total++;
        }

        return total;
    }
}