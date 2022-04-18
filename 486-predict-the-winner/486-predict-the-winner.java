class Solution {
    public boolean PredictTheWinner(int[] nums) {
       int[][] dp = new int[nums.length][nums.length];
        int k =0;
        while(k<nums.length){
            int j =k;
            int i =0;
            while(i<nums.length && j<nums.length){
                if(i==j){
                    dp[i][j] = nums[i];
                }else if(Math.abs(j-i)==1){
                    dp[i][j] = Math.max(nums[i],nums[j]);
                }else{
                    dp[i][j] = Math.max(nums[i]+Math.min(dp[i+2][j],dp[i+1][j-1]),nums[j]+Math.min(dp[i][j-2],dp[i+1][j-1]));
                }
                i++;
                j++;
            }
            k++;
        }
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum+nums[i];
        }
        int player1 = dp[0][nums.length-1];
        int player2 = sum-player1;
        if(player2>player1){
            return false;
        }
        return true;
    }
}