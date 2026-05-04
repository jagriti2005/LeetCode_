class Solution {
    public void rotate(int[][] arr) {
        // transpose
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        //rotate-> reverse each row
        for(int i = 0;i<arr.length;i++){
            int a = 0, b = arr.length-1;
            while(a<b){
                int temp = arr[i][a];
                arr[i][a] = arr[i][b];
                arr[i][b] = temp;
                a++;
                b--;
            }
        }
    }
}