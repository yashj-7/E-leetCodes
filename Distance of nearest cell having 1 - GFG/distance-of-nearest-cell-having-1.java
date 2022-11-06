//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    class Pair{
        int i;
        int j;
        int level;
        Pair(int i,int j,int level){
            this.i=i;
            this.j=j;
            this.level=level;
        }
    }
    public int[][] nearest(int[][] grid)
    {
        int[][] mat = new int[grid.length][grid[0].length];
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    mat[i][j]=0;
                    q.offer(new Pair(i,j,0));
                    vis[i][j] = true;
                }
            }
        }
        while(q.isEmpty()==false){
            Pair p = q.poll();
            int r = p.i;
            int c = p.j;
            if(r-1>=0 && vis[r-1][c]==false){
                vis[r-1][c]=true;
                q.offer(new Pair(r-1,c,p.level+1));
                mat[r-1][c]=p.level+1;
            }
            if(r+1<grid.length && vis[r+1][c]==false){
                vis[r+1][c]=true;
                q.offer(new Pair(r+1,c,p.level+1));
                mat[r+1][c]=p.level+1;
            }
            if(c-1>=0 && vis[r][c-1]==false){
                vis[r][c-1]=true;
                q.offer(new Pair(r,c-1,p.level+1));
                mat[r][c-1]=p.level+1;
            }
            if(c+1<grid[0].length && vis[r][c+1]==false){
                vis[r][c+1]=true;
                q.offer(new Pair(r,c+1,p.level+1));
                mat[r][c+1]=p.level+1;
            }
        }
        return mat;
    }
}