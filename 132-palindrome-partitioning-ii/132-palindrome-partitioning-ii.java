class Solution {
    public int minCut(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(s,0,s.length()-1,dp);
    }
    public int solve(String s,int i,int j,int[][] dp){
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(isPalindrome(s,i,j)==true){
            dp[i][j]=0;
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        //check if both left is palindrome or not, cozif left isnt palindrome, there is no need to make any cut as we need both sides to be a palindrome
        for(int k=i;k<=j-1;k++){
            if(isPalindrome(s, i, k)){
            int partitions = 1+solve(s, k+1, j,dp);
            min = Math.min(min, partitions);                
        }
            
        }
        return dp[i][j]=min;
    }
    public static boolean isPalindrome(String s,int i,int j){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}