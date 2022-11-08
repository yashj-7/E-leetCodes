//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char board[][])
    {
        // code here
        int i=0;
        int[][] vis= new int[board.length][board[0].length];
        for(int j=0;j<board[0].length;j++){
            if(board[i][j]=='O' && vis[i][j]!=1){
                dfs(i,j,vis,board);
            }
        }
        for(int j=0;j<board.length;j++){
            if(board[j][i]=='O' && vis[j][i]!=1){
                dfs(j,i,vis,board);
            }
        }
        i = board.length-1;
        for(int j=0;j<board[0].length;j++){
            if(board[i][j]=='O' && vis[i][j]!=1){
                dfs(i,j,vis,board);
            }
        }
        i=board[0].length-1;
        for(int j=0;j<board.length;j++){
            if(board[j][i]=='O' && vis[j][i]!=1){
                dfs(j,i,vis,board);
            }
        }
        for(int x=0;x<board.length;x++){
            for(int j=0;j<board[0].length;j++){
                if(vis[x][j]==0 && board[x][j]=='O'){
                    board[x][j]='X';
                }
            }
        } 
        return board;
    }
    public static void dfs(int i,int j,int[][] vis,char[][] board){
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1 || board[i][j]=='X' || vis[i][j]==1){
            return ;
        }   
        vis[i][j]=1;
        dfs(i-1,j,vis,board);
        dfs(i+1,j,vis,board);
        dfs(i,j+1,vis,board);
        dfs(i,j-1,vis,board);
    }
}