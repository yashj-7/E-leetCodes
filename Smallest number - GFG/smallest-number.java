// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] inp=read.readLine().split(" ");
            int S=Integer.parseInt(inp[0]);
            int D=Integer.parseInt(inp[1]);

            Solution ob = new Solution();
            System.out.println(ob.smallestNumber(S,D));
        }
    }
}// } Driver Code Ends


class Solution{
    static String smallestNumber(int S, int D){
        String ans = "";
        String[] arr = {"0","1","2","3","4","5","6","7","8","9"};
        int j=0;
        int x = D*9;
        if(S>x){
            return "-1";
        }
        while(j<D){
            if(j==D-1){
                ans = ans+String.valueOf(S);
                break;
            }
            for(int i=0;i<arr.length;i++){
                if(j==0 && i==0){
                    continue;
                }
                if(S-Integer.parseInt(arr[i])<=(D-(j+1))*9){
                    ans = ans+String.valueOf(i);
                    S=S-Integer.parseInt(arr[i]);
                    break;
                }
            }
            j++;
        }
        return ans;
    }
}