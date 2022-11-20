class Solution {
    static int m = (int)(Math.pow(10,9)+7);
    public int beautifulPartitions(String s, int k, int minLength) {
        int i=0;
        if(checkPrime(s.charAt(i))==false){
            return 0;
        }
        int[][] dp = new int[s.length()][k+1];
       for(int x=0;x<dp.length;x++){
           Arrays.fill(dp[x],-1);
       }
        if(k==1){
            if(s.length()<minLength){
                return 0;
            }
            if(checkPrime(s.charAt(0))==true && checkPrime(s.charAt(s.length()-1))==false){
                return 1;
            }
            return 0;
        }
        int ans = 0;
        int x = k;
        ans = (helper(s,0,minLength,x,dp))%m;
        return ans;
    }
    public static int helper(String s,int i,int minLength,int k,int[][] dp){
        if(i>=s.length()){
            return 0;
        }
        if(dp[i][k]!=-1){
            return dp[i][k];
        }
        if(k==0 || s.length()-i<minLength){
            return 0;
        }
        if(k==1){
            if(s.length()-i<minLength){
                return 0;
            }
            if(checkPrime(s.charAt(i))==true && checkPrime(s.charAt(s.length()-1))==false){
                return 1;
            }
            return 0;
        }
        // if(checkPrime(s.charAt(i))==false){
        //     return 0;
        // }
        int ans = 0;
        if(checkPrime(s.charAt(i))==true){
            for(int j=i+1;j<s.length();j++){
            if(j-i+1>=minLength && checkPrime(s.charAt(j))==false){
                int x = k-1;
                ans = (ans+helper(s,j+1,minLength,x,dp))%m;
            }
        }
        }
        
        return dp[i][k]=ans;
    }
    public static boolean checkPrime(char x){
        if(x=='2' || x=='3' || x=='5' || x=='7'){
            return true;
        }
        return false;
    }
}