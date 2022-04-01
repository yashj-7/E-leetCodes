class Solution {
    public String longestPalindrome(String s) {
     int[][] dp = new int[s.length()][s.length()];
        // for(int i=0;i<s.length();i++){
        //     for(int j=0;j<s.length();j++){
        //         if(i==j){
        //             dp[i][j]=1;
        //         }
        //         if(i>j){
        //             dp[i][j]=0;
        //         } 
        //     }
        // }
        
        for(int k=0;k<s.length();k++){
            int i =0;
            int j =k;
            while(j<s.length()){
                if(k==0){
                    dp[i][j] =1;
                    
                }else if(k==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=2;
                    }else{
                        dp[i][j]=0;
                    }
                }else{
                    if(s.charAt(i)==s.charAt(j)){
                        if(dp[i+1][j-1]!=0){
                            dp[i][j] = dp[i+1][j-1]+2;    
                        }else{
                            dp[i][j] = 0;
                        }
                        
                    }else{
                        dp[i][j] =0;
                    }   
                }
                i++;
                j++;
            }
        }
        
        
        int max =-1;
        String ans = "";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(dp[i][j]>max){
                    max = Math.max(max,dp[i][j]);
                    ans = s.substring(i,j+1);
                }
                
            }
        }
        System.out.println(max);
        return ans;
    }
}