// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> list = new ArrayList<String>();
        boolean[][] x = new boolean[n][n];
        if(m[0][0]==0){
            list.add("-1");
            return list;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                x[i][j]=true;
            }
        }
        String ans = "";
        solve(list,ans,0,0,x,m);
        return list;
    }
    public static void solve(List<String> list, String ans, int row, int col, boolean[][] n, int[][] m){
       if(row==n.length-1 && col==n[0].length-1){
           list.add(new String(ans));
           return;
       }
       //downward
       if(row+1<n.length && n[row+1][col]==true && m[row+1][col]==1){
           n[row][col]=false;
           String t1 = new String(ans);
           t1 = t1+"D";
           solve(list,t1,row+1,col,n,m);
           n[row][col]=true;
       }
       //right
       if(col+1<n[0].length && n[row][col+1]==true && m[row][col+1]==1){
           n[row][col]=false;
           String t2 = new String(ans);
           t2 = t2+"R";
           solve(list,t2,row,col+1,n,m);
           n[row][col]=true;
       }
       //left
       if(col-1>=0 && n[row][col-1]==true && m[row][col-1]==1){
           n[row][col]=false;
           String t3 = new String(ans);
           t3 = t3+"L";
           solve(list,t3,row,col-1,n,m);
           n[row][col]=true;
       }
       //up
       if(row-1>=0 && n[row-1][col]==true && m[row-1][col]==1){
           n[row][col]=false;
           String t4 = new String(ans);
           t4 = t4+"U";
           solve(list,t4,row-1,col,n,m);
           n[row][col]=true;
       }
    }
}