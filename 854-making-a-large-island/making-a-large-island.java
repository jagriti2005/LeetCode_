import java.util.*;
class Solution {
    class Pair{
        int r,c;
        Pair(int r,int c){
            this.r = r;
            this.c = c;
        }
    }

    int[] rowD = {-1,1,0,0};
    int[] colD = {0,0,-1,1};

    public int bfs(int i,int j,int id,int[][] grid){
        int n = grid.length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));

        grid[i][j] = id;
        int area = 1;

        while(!q.isEmpty()){
            Pair cur = q.poll();
            for(int k=0;k<4;k++){
                int nr = cur.r + rowD[k];
                int nc = cur.c + colD[k];
                if(nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc]==1){
                    grid[nr][nc] = id;
                    area++;
                    q.add(new Pair(nr,nc));
                }
            }
        }

        return area;
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Map<Integer,Integer> map = new HashMap<>();
        int id = 2;
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    int area = bfs(i,j,id,grid);
                    map.put(id,area);
                    max = Math.max(max,area);

                    id++;
                }
            }
        }

        // Step 2: try flipping 0
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j] == 0){

                    Set<Integer> set = new HashSet<>();
                    int area = 1;

                    for(int k=0;k<4;k++){

                        int nr = i + rowD[k];
                        int nc = j + colD[k];

                        if(nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc] > 1){
                            set.add(grid[nr][nc]);
                        }
                    }

                    for(int island : set){
                        area += map.get(island);
                    }

                    max = Math.max(max,area);
                }
            }
        }

        return max;
    }
}