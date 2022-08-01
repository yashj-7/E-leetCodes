class Solution {
    public int lengthOfLIS(int[] nums) {
        // int[][] dp = new int[nums.length+1][nums.length+1];
        // for(int i=0;i<nums.length+1;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return solve(nums,0,-1,dp);
        
        
        //tabulation:-
        int[] dp = new int[nums.length];
        dp[0]=1;
        for(int i=1;i<nums.length;i++){
            dp[i] = 1;
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int ans = 0;
        for(int i=0;i<dp.length;i++){
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
    
    //memoized code
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