class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return solve(s,0,wordDict,"",dp);
    }
    public static boolean solve(String s,int i,List<String> wordDict,String temp,int[] dp){
        if(wordDict.contains(temp)){
            return true;
        }
        if(i==s.length()){
            return true;
        }
        if(dp[i]!=-1){
            return dp[i]==1?true:false;
        }
        boolean t1 = false;
        for(int j=i;j<s.length();j++){
            temp = temp+Character.toString(s.charAt(j));
            if(wordDict.contains(temp)==true){
                if(solve(s,j+1,wordDict,"",dp)==true){
                    return true;
                }
            }
        }
        if(t1==true){
            dp[i] = 1;
            
        }else{
            dp[i] = 0;
        }
        return false;
    }
}