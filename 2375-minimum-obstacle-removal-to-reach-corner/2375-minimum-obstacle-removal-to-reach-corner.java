class Solution {
    private final int[][] directions ={{0,1},{0,-1},{1,0},{-1,0}};
    public int minimumObstacles(int[][] grid) {
        int m =grid.length;
        int n = grid[0].length;
        int[][] minobstacles = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                minobstacles[i][j]=Integer.MAX_VALUE;
            }
        }
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[] {grid[0][0],0,0});
        minobstacles[0][0]=grid[0][0];
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int obstacles =cur[0], row=cur[1], col=cur[2];
            if(row==m-1 && col==n-1) return obstacles;
            for(int[] dir : directions){
                int newrow= row+dir[0],newcol=col+dir[1];
                if(newrow>=0 && newcol>=0 && newrow<m && newcol<n){
                    int newobstacle=obstacles+grid[newrow][newcol];
                    if(minobstacles[newrow][newcol]==Integer.MAX_VALUE){
                        minobstacles[newrow][newcol]=newobstacle;
                        pq.add(new int[] {newobstacle,newrow,newcol});
                    }
                }
            }
        }
return -1;
    }
}