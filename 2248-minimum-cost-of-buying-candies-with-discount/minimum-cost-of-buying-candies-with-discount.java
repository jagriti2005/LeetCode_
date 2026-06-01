class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;
        int candy = 0;
        Arrays.sort(cost);
        for(int num:cost) candy += num;

        for(int i=n-3;i>=0;i-=3){
            candy -= cost[i];
        }
        return candy;
    }
}