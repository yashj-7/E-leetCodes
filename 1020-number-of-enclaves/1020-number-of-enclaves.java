class Solution {
    class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public int numEnclaves(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[grid.length][grid[0].length];
        for(int i=0;i<grid[0].length;i++){
            if(grid[0][i]==1){
                vis[0][i]=1;
                q.offer(new Pair(0,i));
            }
        }
        for(int i=0;i<grid.length;i++){
            if(grid[i][0]==1){
                vis[i][0]=1;
                q.offer(new Pair(i,0));
            }
        }
        for(int i=0;i<grid.length;i++){
            if(grid[i][grid[0].length-1]==1){
                vis[i][grid[0].length-1]=1;
                q.offer(new Pair(i,grid[0].length-1));
            }
        }
        for(int i=0;i<grid[0].length;i++){
            if(grid[grid.length-1][i]==1){
                vis[grid.length-1][i]=1;
                q.offer(new Pair(grid.length-1,i));
            }
        }
        
        while(q.isEmpty()==false){
            Pair p =q.poll();
            //System.out.println(p.i+" "+p.j);
            if(p.i-1>=0 && grid[p.i-1][p.j]!=0 && vis[p.i-1][p.j]!=1){
                vis[p.i-1][p.j]=1;
                q.offer(new Pair(p.i-1,p.j));
            }
            if(p.i+1<grid.length && grid[p.i+1][p.j]!=0 && vis[p.i+1][p.j]!=1){
                vis[p.i+1][p.j]=1;
                q.offer(new Pair(p.i+1,p.j));
            }
            if(p.j-1>=0 && grid[p.i][p.j-1]!=0 && vis[p.i][p.j-1]!=1){
                vis[p.i][p.j-1]=1;
                q.offer(new Pair(p.i,p.j-1));
            }
            if(p.j+1<grid[0].length && grid[p.i][p.j+1]!=0 && vis[p.i][p.j+1]!=1){
                vis[p.i][p.j+1]=1;
                q.offer(new Pair(p.i,p.j+1));
            }
        }
        int cnt = 0;
        for(int i=0;i<vis.length;i++){
            for(int j=0;j<vis[0].length;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}