// { Driver Code Starts
//initial code
import java.util.*;
import java.lang.*;
class InterLeaveString
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            String a =sc.next();
            String b = sc.next();
            String c = sc.next();
            Solution g=new Solution();
        
            System.out.println(g.isInterLeave(a,b,c)==true?1:0);
            t--;
        }
    }
}

// } Driver Code Ends


/*you are required to complete this method */
class Solution {
	public boolean isInterLeave(String a,String b,String c)
	{
	    int[][][] dp = new int[a.length()][b.length()][c.length()];
	    for(int i=0;i<a.length();i++){
	        for(int j=0;j<b.length();j++){
	            Arrays.fill(dp[i][j],-1);
	        }
	    }
          return solve(a,b,c,0,0,0,dp);
	}
	public static boolean solve(String a,String b,String c,int i,int j,int k,int[][][] dp){
	    if(k>=c.length()){
	        return true;
	    }
	    if(i>=a.length() && j>=b.length()){
	        return false;
	    }
	   // if(j<b.length() && i>=a.length() && b.substring(j,b.length()).equals(c.substring(k,c.length()))){
	   //     return true;
	   // }
	   // if(i<a.length() && j>=b.length() && a.substring(i,a.length()).equals(c.substring(k,c.length()))){
	   //     return true;
	   // }
	    if(i<a.length() && j<b.length() && dp[i][j][k]!=-1){
	        return dp[i][j][k]==1?true:false;
	    }
	    
	    boolean t1 = false;
	    boolean t2 = false;
	    if(i<a.length() && a.charAt(i)==c.charAt(k)){
	        t1 = solve(a,b,c,i+1,j,k+1,dp);
	    }
	    if(j<b.length() && b.charAt(j)==c.charAt(k)){
	        t2 = solve(a,b,c,i,j+1,k+1,dp);
	    }
	    if(i<a.length() && j<b.length() && (t1||t2 == true)){
	        dp[i][j][k] = 1;
	    }else if(i<a.length() && j<b.length() && (t1||t2 == false)){
	        dp[i][j][k] = 0;
	    }
	    return t1||t2;
	}
}

