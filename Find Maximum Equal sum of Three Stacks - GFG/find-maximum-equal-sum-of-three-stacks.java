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
            
            int[] a = IntArray.input(br, 3);
            
            
            int[] S1 = IntArray.input(br, a[0]);
            
            
            int[] S2 = IntArray.input(br, a[1]);
            
            
            int[] S3 = IntArray.input(br, a[2]);
            
            Solution obj = new Solution();
            int res = obj.maxEqualSum(a[0],a[1],a[2], S1, S2, S3);
            
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int maxEqualSum(int N1,int N2,int N3, int[] S1, int[] S2, int[] S3) {
        int s1 = 0;
        int s2 = 0;
        int s3 = 0;
        for(int i=0;i<S1.length;i++){
            s1 = s1+S1[i];
        }
        for(int i=0;i<S2.length;i++){
            s2 = s2+S2[i];
        }
        for(int i=0;i<S3.length;i++){
            s3 = s3+S3[i];
        }
        int i=0;
        int j=0;
        int k=0;
        while(i<N1 && j<N2 && k<N3 ){
            if(s1==s2 && s2==s3){
                return s1;
            }
            if((s1>=s2 && s2>s3) || (s1>s2 && s1>=s3)){
                s1 = s1-S1[i];
                i++;
            }else if((s2>=s1 && s2>s3) || (s2>s1 && s2>=s3)){
                s2 = s2-S2[j];
                j++;
            }else if((s3>=s1 && s3>s2) || (s3>s1 && s3>=s2)){
                s3 = s3-S3[k];
                k++;
            }
        }
        
        return 0;
    }
}
        
