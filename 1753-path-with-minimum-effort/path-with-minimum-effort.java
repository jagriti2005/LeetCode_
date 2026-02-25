import java.util.*;

class Solution {
    class Node{
        int r,c,effort;
        Node(int r,int c,int effort){
            this.r=r;
            this.c=c;
            this.effort=effort;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int[][] dist=new int[n][m];
        for(int[] row:dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        PriorityQueue<Node> pq= new PriorityQueue<>((a,b)->a.effort-b.effort);
        pq.add(new Node(0,0,0));
        dist[0][0]=0;
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        while(pq.size()>0){
            Node cur=pq.poll();
            if(cur.r==n-1 && cur.c==m-1)
                return cur.effort;
            for(int i=0;i<4;i++){
                int nr=cur.r+dr[i];
                int nc=cur.c+dc[i];

                if(nr<0||nc<0||nr>=n||nc>=m) continue;
                int edge=Math.abs(heights[cur.r][cur.c]-heights[nr][nc]);
                int newEffort=Math.max(cur.effort,edge);
                if(newEffort<dist[nr][nc]){
                    dist[nr][nc]=newEffort;
                    pq.add(new Node(nr,nc,newEffort));
                }
            }
        }
        return 0;
    }
}