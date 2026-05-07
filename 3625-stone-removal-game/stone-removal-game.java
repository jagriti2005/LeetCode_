class Solution {
    public boolean canAliceWin(int n) {
        int stone = 10;
        int move = 0;
        while(n>=stone){
            n -= stone;
            stone--;
            move++;
        }
        return move%2 == 1;
    }
}