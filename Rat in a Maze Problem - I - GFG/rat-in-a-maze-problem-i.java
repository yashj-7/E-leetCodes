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
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean[][] b = new boolean[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(b[i],false);
        }
        if(m[0][0]==0){
            return list;
        }
        solution(list,m,0,0,sb,b);
        return list;
    }
    public static void solution(ArrayList<String> list , int[][] m , int i , int j,StringBuilder ans,boolean[][] b){
        
        if(i==m.length-1 && j==m.length-1){
            list.add(ans.toString());
            return;
        }
        b[i][j] = true;
        if(i+1<m.length && m[i+1][j]==1 && b[i+1][j]==false){
            ans.append("D");
            solution(list,m,i+1,j,ans,b);
            ans.delete(ans.length()-1,ans.length());
        }
        if(j+1<m.length && m[i][j+1]==1 && b[i][j+1]==false){
            ans.append("R");
            solution(list,m,i,j+1,ans,b);
            ans.delete(ans.length()-1,ans.length());
        }
        if(i-1>=0 && m[i-1][j]==1 && b[i-1][j]==false){
            ans.append("U");
            solution(list,m,i-1,j,ans,b);
            ans.delete(ans.length()-1,ans.length());
        }
        if(j-1>=0 && m[i][j-1]==1 && b[i][j-1]==false){
            ans.append("L");
            solution(list,m,i,j-1,ans,b);
            ans.delete(ans.length()-1,ans.length());
        }
        b[i][j]=false;
    }
}