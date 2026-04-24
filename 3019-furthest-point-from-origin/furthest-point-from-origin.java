class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int RCount = 0;
        int LCount = 0;
        int underScore = 0;

        for(char ch : moves.toCharArray()){
            if(ch == 'R') RCount++;
            else if(ch == 'L') LCount++;
            else underScore++;
        }

        return Math.abs(RCount - LCount) + underScore;
    }
}