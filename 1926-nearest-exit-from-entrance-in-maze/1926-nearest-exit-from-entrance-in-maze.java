class Solution {
    class Pair{
        int a;
        int b;
        int c;
        Pair(int a,int b,int c){
            this.a=a;
            this.b=b;
            this.c=c;
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(entrance[0],entrance[1],0));
        int ans = Integer.MAX_VALUE;
        while(q.isEmpty()==false){
            Pair p = q.poll();
            if(maze[p.a][p.b]=='+'){
                continue;
            }
            maze[p.a][p.b]='+';
            if((p.a==0 || p.a==maze.length-1 || p.b==0 || p.b==maze[0].length-1) && p.c>0){
                ans = Math.min(ans,p.c);
            }
            if(p.a-1>=0 && maze[p.a-1][p.b]!='+'){
                q.offer(new Pair(p.a-1,p.b,p.c+1));
            }
            if(p.a+1<maze.length && maze[p.a+1][p.b]!='+'){
                q.offer(new Pair(p.a+1,p.b,p.c+1));
            }
            if(p.b-1>=0 && maze[p.a][p.b-1]!='+'){
                q.offer(new Pair(p.a,p.b-1,p.c+1));
            }
            if(p.b+1<maze[0].length && maze[p.a][p.b+1]!='+'){
                q.offer(new Pair(p.a,p.b+1,p.c+1));
            } 
        }
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}