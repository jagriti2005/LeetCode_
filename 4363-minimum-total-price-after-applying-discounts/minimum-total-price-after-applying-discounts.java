class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        double ans = 0;
        Arrays.sort(prices);
        Arrays.sort(discounts);

        int i=discounts.length-1;
        int j = prices.length-1;

        boolean[] vis = new boolean[prices.length];

        while(i>=0 && j>=0){
            ans += prices[j] * (100.0 - discounts[i]) / 100.0;
            vis[j] = true;
            i--;
            j--;
        }

        for(int k=0;k<prices.length;k++){
            if(!vis[k]) ans += prices[k];
        }

        return ans;
    }
}