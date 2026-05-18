class Solution {
    public int minJumps(int[] arr) {

        int n = arr.length;

        if(n == 1) return 0;

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], new ArrayList<>());
            }

            map.get(arr[i]).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        int steps = 0;

        q.offer(0);
        visited[0] = true;

        while(!q.isEmpty()){
            
            int len = q.size();

            for(int i = 0; i < len; i++){
                int curr = q.poll();

                if(curr == n - 1) return steps;

                //forward

                if(curr + 1 < n && !visited[curr+1]){
                    q.offer(curr + 1);
                    visited[curr+1] = true;
                }

                   //backward

                if(curr - 1 >= 0 && !visited[curr - 1]){
                    q.offer(curr - 1);
                    visited[curr - 1] = true;
                }

                //same value

                for(int same : map.get(arr[curr])){
                    if(!visited[same]){
                        q.offer(same);
                        visited[same] = true;
                    }
                }

                map.get(arr[curr]).clear();


            }
            steps++;
            

        }
        
        

        return -1;



        
    }
    
    
}