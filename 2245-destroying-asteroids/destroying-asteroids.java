class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currMass = mass;

        for(int num : asteroids){
            if(currMass < num) return false;
            currMass += num;
        }

        return true;
    }
}