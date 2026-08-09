class Solution {
    public int minOperations(int n) {
        int[] arr = new int[n];
        int sum = 0;

        for(int i=0;i<n;i++){
            arr[i] = (2*i)+1;
            sum += arr[i];
        }

        int target = sum/n;
        int op = 0;

        int x =0;
        int y=n-1;

        while(x<y){
            op += target - arr[x];
            x++;
            y--;
        }

        return op;
    }
}