// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int e = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] A = new int[2*e];
            int[] B = new int[2*e];
            
            for(int i=0; i<2*e; i++)
            {
                A[i] = Integer.parseInt(S1[i]);
                B[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.checkMirrorTree(n,e,A,B));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int checkMirrorTree(int n, int e, int[] A, int[] B) {
        HashMap<Integer,Stack<Integer>> hm = new HashMap<>();
        for(int i=0;i<A.length;i=i+2){
            if(hm.containsKey(A[i])){
                Stack<Integer> s = hm.get(A[i]);
                s.push(A[i+1]);
                hm.put(A[i],s);
            }else{
                Stack<Integer> s = new Stack<>();
                s.push(A[i+1]);
                hm.put(A[i],s);
            }
        }
        for(int j=0;j<B.length;j=j+2){
            if(hm.get(B[j]).pop()!=B[j+1]){
                return 0;
            }
            //hm.get(B[j]).pop();
        }
        
        return 1;
    }
};