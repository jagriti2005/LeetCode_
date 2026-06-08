class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if(a.length > b.length) return findMedianSortedArrays(b,a);
        int n = a.length, m = b.length;
        int low = 0, hi = n;

        while(low <= hi){
            int cut1 = (low+hi)/2;
            int cut2 = (n+m+1)/2-cut1;

            int l1 = (cut1==0) ? Integer.MIN_VALUE : a[cut1-1];
            int l2 = (cut2==0) ? Integer.MIN_VALUE : b[cut2-1];

            int r1 = (cut1==n) ? Integer.MAX_VALUE : a[cut1];
            int r2 = (cut2==m) ? Integer.MAX_VALUE : b[cut2];

            if(l1 <= r2 && l2 <= r1){
                if((n+m)%2==0) return (Math.max(l1,l2) + Math.min(r1,r2)) / 2.0;
                else return Math.max(l1,l2);
            }
            else if(l1 > r2) hi = cut1-1;
            else low = cut1+1;
        }

        return 0;
    }
}