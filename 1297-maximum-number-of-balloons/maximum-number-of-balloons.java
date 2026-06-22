class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[5];

        for(char ch:text.toCharArray()){
            switch(ch){
                case 'b': count[0]++; break;
                case 'a': count[1]++; break;
                case 'l': count[2]++; break;
                case 'o': count[3]++; break;
                case 'n': count[4]++; break;
            }
        }

        count[2] /= 2;
        count[3] /= 2;

        int minBalloon = count[0];
        for(int i=1;i<count.length;i++){
            if(count[i] < minBalloon) minBalloon = count[i];
        }

        return minBalloon;
    }
}