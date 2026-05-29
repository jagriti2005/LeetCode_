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
        boolean[] vis = new boolean[n];

        int steps = 0;
        q.add(0);
        vis[0] = true;

        while(q.size() > 0){
            int len = q.size();
            while(len-- > 0){
                int curr = q.poll();
                if(curr == n-1) return steps;

                if(curr+1<n && !vis[curr+1]){
                    q.add(curr+1);
                    vis[curr+1] = true;
                }

                if(curr-1>=0 && !vis[curr-1]){
                    q.add(curr-1);
                    vis[curr-1] = true;
                }

                for(int same : map.get(arr[curr])){
                    if(!vis[same]){
                        q.add(same);
                        vis[same] = true;
                    }
                }
                map.get(arr[curr]).clear();
            }
            steps++;
        }
        return -1;     
    } 
}