// { Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 2);
            
            
            int[][] mat = IntMatrix.input(br, a[0], a[1]);
            
            Solution obj = new Solution();
            int res = obj.findShortestPath(mat);
            
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int findShortestPath(int[][] mat) {
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    if(i+1<mat.length && mat[i+1][j]==0){
                        mat[i][j]=2;
                    }
                    if(j+1<mat[0].length && mat[i][j+1]==0){
                        mat[i][j]=2;
                    }
                    if(j-1>=0 && mat[i][j-1]==0){
                        mat[i][j]=2;
                    }
                    if(i-1>=0 &&mat[i-1][j]==0){
                        mat[i][j]=2;
                    }
                }
            }
        }
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==2){
                    mat[i][j]=0;
                }
            }
        }
        boolean[][] track = new boolean[mat.length][mat[0].length];
        for(int i=0;i<track.length;i++){
            Arrays.fill(track[i],false);
        }
        int[] res = new int[1];
        res[0] = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<mat.length;i++){
            solve(mat,i,0,0,res,track);
            ans = Math.min(res[0],ans);
            res[0] = Integer.MAX_VALUE;
        }
        if(ans>=Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
    public static void solve(int[][] mat,int i,int j,int ans,int[] res,boolean[][] track){
        if(mat[i][j]==0){
            return;
        }
        if(ans>res[0]){
            return;
        }
        if(j==mat[0].length-1){
           ans++;
            res[0] = Math.min(res[0],ans);
            return;
        }
        
        track[i][j]=true;
        if(i+1<mat.length && track[i+1][j]==false){
            ans++;
            solve(mat,i+1,j,ans,res,track);
            ans--;
        }
        if(j+1<mat[0].length && track[i][j+1]==false){
            ans++;
            solve(mat,i,j+1,ans,res,track);
            ans--;
        }
        if(i-1>=0 && track[i-1][j]==false){
            ans++;
            solve(mat,i-1,j,ans,res,track);
            ans--;
        }
        if(j-1>=0 && track[i][j-1]==false){
            ans++;
            solve(mat,i,j-1,ans,res,track);
            ans--;
        }
        track[i][j]=false;
    }
}
        
