// { Driver Code Starts
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
}// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int[][] ans = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            Arrays.fill(ans[i],Integer.MAX_VALUE-1);
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    ans[i][j]=0;
                }
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(ans[i][j]!=0){
                    if(i-1>=0){
                        ans[i][j] = Math.min(ans[i][j],ans[i-1][j]+1);
                    }
                    if(j-1>=0){
                        ans[i][j] = Math.min(ans[i][j],ans[i][j-1]+1);
                    }
                    if(i+1<grid.length){
                        ans[i][j] = Math.min(ans[i][j],ans[i+1][j]+1);
                    }
                    if(j+1<grid[0].length){
                        ans[i][j] = Math.min(ans[i][j],ans[i][j+1]+1);
                    }
                }
            }
        }
        
        for(int i=grid.length-1;i>=0;i--){
            for(int j=grid[0].length-1;j>=0;j--){
                if(ans[i][j]!=0){
                    if(i-1>=0){
                        ans[i][j] = Math.min(ans[i][j],ans[i-1][j]+1);
                    }
                    if(j-1>=0){
                        ans[i][j] = Math.min(ans[i][j],ans[i][j-1]+1);
                    }
                    if(i+1<grid.length){
                        ans[i][j] = Math.min(ans[i][j],ans[i+1][j]+1);
                    }
                    if(j+1<grid[0].length){
                        ans[i][j] = Math.min(ans[i][j],ans[i][j+1]+1);
                    }
                }
            }
        }
        return ans;
    }
}