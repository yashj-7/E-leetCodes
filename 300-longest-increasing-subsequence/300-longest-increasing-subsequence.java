class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int i=0;i<nums.length+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(nums,0,-1,dp);
    }
    public int solve(int[] nums,int ind,int ind2,int[][] dp){
        
        if(ind==nums.length){
            return 0;
        }
        if( dp[ind][ind2+1]!=-1){
            return dp[ind][ind2+1];
        }
        int pick = (int)-1e9;
        int notPick = (int)-1e9;
        if(ind2<0 || nums[ind]>nums[ind2]){
            pick = 1+solve(nums,ind+1,ind,dp);
            notPick = solve(nums,ind+1,ind2,dp);
        }else{
            notPick = solve(nums,ind+1,ind2,dp);
        }
        return dp[ind][ind2+1]=Math.max(pick,notPick);
        
    }
}