class Solution {
    class Pair{
        int r,c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    int[] rowD = {0,0,-1,1};
    int[] colD = {-1,1,0,0};

    public void bfs(int[][] image, int sr, int sc, int color, boolean[][] vis){
        int n = image.length;
        int m = image[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        vis[sr][sc] = true;
        int original = image[sr][sc];
        image[sr][sc] = color;

        while(q.size() > 0){
            Pair curr = q.poll();
            int r = curr.r;
            int c = curr.c;
            for(int i=0;i<4;i++){
                int nr = rowD[i] + r;
                int nc = colD[i] + c;

                if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && image[nr][nc] == original){
                    q.add(new Pair(nr,nc));
                    vis[nr][nc] = true;
                    image[nr][nc] = color;
                }
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        bfs(image, sr,sc,color,vis);
        return image;
    }
}