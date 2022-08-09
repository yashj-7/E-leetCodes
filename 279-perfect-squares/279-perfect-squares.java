class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        if(n<4){
            return n;
        }
        dp[0] = 1;
        dp[1] = 1;
        dp[2]=2;
        dp[3]=3;
        ArrayList<Integer> lastSq= new ArrayList<>();
        lastSq.add(1);
        for(int i=4;i<=n;i++){
            if(isPerfectSquare(i)){
                //prevSq = lastSq;
                lastSq.add(i);
                dp[i] =1;
            }else{
                
                dp[i] = Integer.MAX_VALUE;
                for(int j=lastSq.size()-1;j>=0;j--){
                    dp[i] = Math.min(dp[i],dp[lastSq.get(j)]+dp[i-lastSq.get(j)]);
                }
            }
        }
        return dp[n];
    }
    public static boolean isPerfectSquare(int n){
        int x = (int)Math.pow(n,0.5);
        if(x*x==n){
            return true;
        }
        return false;
    }
}