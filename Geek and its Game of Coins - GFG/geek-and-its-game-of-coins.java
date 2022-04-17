// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String input[] = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int X = Integer.parseInt(input[1]);
            int Y = Integer.parseInt(input[2]);
            Solution ob = new Solution();
            int ans = ob.findWinner(N,X,Y);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    public int findWinner(int N,int X,int Y)
    {
        
        //the dp[i-X] or dp[i-1] or dp[i-Y] shows that if you choose 1 X or Y coins at this tage then who chose the coin at i-1 or i-X or i-Yth stage.
        
        boolean[] dp = new boolean[N+1];
        dp[0] = false;
        dp[1] = true;
        for(int i=2;i<N+1;i++){
            if(i-1>=0){
                dp[i] = !dp[i-1];
            }
            if(dp[i]==true){
                continue;
            }
            if(i-X>=0){
                dp[i] = !dp[i-X];
            }
            if(dp[i]==true){
                continue;
            }
            if(i-Y>=0){
                dp[i] = !dp[i-Y];
            }
            if(dp[i]==true){
                continue;
            }
        }
        return dp[N]==true?1:0;
    }
}