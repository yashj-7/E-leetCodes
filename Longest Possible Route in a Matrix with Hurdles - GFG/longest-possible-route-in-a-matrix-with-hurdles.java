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
            
            
            int[] b = IntArray.input(br, 4);
            
            
            int[][] mat = IntMatrix.input(br, a[0], a[1]);
            
            Solution obj = new Solution();
            int res = obj.longestPath(mat,a[0],a[1],b[0],b[1],b[2],b[3]);
            
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int longestPath(int[][] mat,int n,int m,int xs,int ys,int xd,int yd) {
        int ans = 0;
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        boolean[][] vis = new boolean[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            Arrays.fill(vis[i],false);
        }
        if(mat[xs][ys]==0 || mat[xd][yd]==0){
            return -1;
        }
        solve(mat,xs,ys,xd,yd,vis,ans,res);
        if(res[0]==Integer.MIN_VALUE){
            return -1;
        }
        return res[0];
    }
    public static void solve(int[][] mat,int i,int j,int x,int y,boolean[][] vis,int ans, int[] res){
        
        if(i==x && j==y){
             res[0] = Math.max(ans,res[0]);
             return;
        }
        if(vis[i][j] == true){
            return ;
        }
        //System.out.println(i+" "+j);
        vis[i][j] = true;
        if(i+1<mat.length && mat[i+1][j]!=0){
            ans++;
            solve(mat,i+1,j,x,y,vis,ans,res);
            ans--;
        }
        if(i-1>=0 && mat[i-1][j]!=0){
            ans++;
            solve(mat,i-1,j,x,y,vis,ans,res);
            ans--;
        }
        if(j+1<mat[0].length && mat[i][j+1]!=0){
            ans++;
            solve(mat,i,j+1,x,y,vis,ans,res);
            ans--;
        }
        if(j-1>=0 && mat[i][j-1]!=0){
            ans++;
            solve(mat,i,j-1,x,y,vis,ans,res);
            ans--;
        }
        vis[i][j] = false;
        //return res;
    }
}
        
