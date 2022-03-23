class Solution {
    public int minInsertions(String s) {
        String text1 = s;
        String text2 = revrse(s);
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        
        for(int i=0;i<text1.length()+1;i++){
            dp[i][0] = 0; 
        }
        for(int i=0;i<text2.length()+1;i++){
            dp[0][i] = 0;
        }
        dp[0][0] =0;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        int x= dp[text1.length()][text2.length()];
        return s.length()-x;
    }
    public String revrse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}