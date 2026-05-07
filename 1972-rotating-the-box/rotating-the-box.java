class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length;
        int m = boxGrid[0].length;

        char[][] ans  = new char[m][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                ans[j][i] = boxGrid[i][j];
                
            }
        }

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n/2; j++){
                char  temp = ans[i][j];
                ans[i][j] = ans[i][n - 1 - j];
                ans[i][n - 1 - j] = temp;
            }

        }

        //har baar lowest empty row ka track rkhenge

        for(int j = 0; j < n; j++){

            int lowestEmpty = m - 1;

            //process each cell from bottom to top

            for(int i = m - 1; i >= 0; i--){

                //found a stone - let it fall to the lowest empty cell
                if(ans[i][j] == '#'){
                    ans[i][j] = '.';
                    ans[lowestEmpty][j] = '#';

                    lowestEmpty--;

                }
                //found an obstacle - reset lowestEmpty to row directly above it
                if(ans[i][j] == '*'){
                    lowestEmpty = i - 1;
                }
            }
        }

        return ans;
        
    }
}