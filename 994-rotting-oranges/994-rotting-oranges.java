class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
             if(grid[i][j]==2){
                 q.add(new int[]{i,j});
                 count++;
             }else if(grid[i][j]==1){
                 count++;
             }   
            }
        }
        int min = 0;
        int flag = q.size();
        while(q.isEmpty()==false){
            ArrayList<int[]> list = new ArrayList();
            while(!q.isEmpty()){
                list.add(q.remove());
            }
           
            for(int i=0;i<list.size();i++){
                int x = list.get(i)[0];
                int y = list.get(i)[1];
                if(x-1>=0 && grid[x-1][y]==1){
                    q.offer(new int[]{x-1,y});
                    grid[x-1][y] =2;
                    flag++;
                }
                if(y-1>=0 && grid[x][y-1]==1){
                    q.offer(new int[]{x,y-1});
                    grid[x][y-1] =2;
                    flag++;
                }
                if(y+1<grid[0].length && grid[x][y+1]==1){
                    q.offer(new int[]{x,y+1});
                    grid[x][y+1]=2;
                    flag++;
                }
                if(x+1<grid.length && grid[x+1][y]==1){
                    q.offer(new int[]{x+1,y});
                    grid[x+1][y]=2;
                    flag++;
                }
                 
               
            }
            if(q.isEmpty()==false){
                    min++;
                }
        }
        if(flag<count){
            return -1;
        }
        
        return min;
    }
}