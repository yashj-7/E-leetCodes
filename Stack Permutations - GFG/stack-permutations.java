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

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            
            int[] B = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.isStackPermutation(N, A, B);
            
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int isStackPermutation(int N, int[] A, int[] B) {
        Stack<Integer> s = new Stack<>();
        
        int i=1;
        int j =0;
        s.push(A[0]);
        while(i<A.length && j<B.length){
            if(s.isEmpty()==false && B[j]==s.peek()){
                s.pop();
                j++;
            }else if(A[i]==B[j]){
                j++;
                i++;
            }
            else{
                s.push(A[i]);
                i++;
            }
            
        }
        if(j<B.length && s.isEmpty()==false){
            while(j<B.length && s.isEmpty()==false){
                if(B[j]!=s.pop()){
                    return 0;
                }
                j++;
            }
            
        }
        if(s.isEmpty()){
            return 1;
        }
        return 0;
    }
}
        
