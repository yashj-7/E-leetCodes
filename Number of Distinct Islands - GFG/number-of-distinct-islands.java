//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
   static class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }

    int countDistinctIslands(int[][] grid) {
        HashSet<List<List<Integer>>> hs =new HashSet<>();
        int[][] vis = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && vis[i][j]!=1){
                    List<List<Integer>> list = new ArrayList<>();
                    dfs(i,j,i,j,vis,list,grid);
                    hs.add(list);
                }
            }
        }
        return hs.size();
    }
    public static void dfs(int i,int j,int x,int y,int[][] vis,List<List<Integer>> list,int[][] grid){
        if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1 || vis[i][j]==1 || grid[i][j]==0){
            return ;
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(i-x);
        temp.add(j-y);
        list.add(temp);
        vis[i][j]=1;
        dfs(i-1,j,x,y,vis,list,grid);
        dfs(i+1,j,x,y,vis,list,grid);
        dfs(i,j-1,x,y,vis,list,grid);
        dfs(i,j+1,x,y,vis,list,grid);
    }
}
