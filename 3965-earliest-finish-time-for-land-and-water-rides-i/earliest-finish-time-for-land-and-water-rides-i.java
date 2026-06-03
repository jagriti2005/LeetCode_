class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        int n  = landStartTime.length;
        int m = waterStartTime.length;


        int time = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int landFinish = landStartTime[i] + landDuration[i];

                int waterFinish = Math.max(landFinish, waterStartTime[j]);

                int finish = waterFinish + waterDuration[j];
  

                time = Math.min(time, finish);
            }
        }

        for(int j = 0; j < m; j++){
            for(int i = 0; i < n; i++){
                int waterFinish = waterStartTime[j] + waterDuration[j];

                int landFinish = Math.max(waterFinish, landStartTime[i]);

                int finish = landFinish + landDuration[i];

                time = Math.min(time, finish);
            }
        }

        return time;

        
    }
}