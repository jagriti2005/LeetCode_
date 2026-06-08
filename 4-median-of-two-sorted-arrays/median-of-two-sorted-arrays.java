class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;

        int[] arr = new int[n + m];

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                arr[k++] = a[i++];
            } else {
                arr[k++] = b[j++];
            }
        }

        while (i < n) {
            arr[k++] = a[i++];
        }

        while (j < m) {
            arr[k++] = b[j++];
        }

        int len = n + m;

        if (len % 2 == 1) {
            return arr[len / 2];
        }

        return (arr[len / 2] + arr[len / 2 - 1]) / 2.0;
    }
}