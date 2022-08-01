class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        dp[0] = 1;
        count[0]=1;
        int mx = 1;
        for(int i=1;i<nums.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(1+dp[j]>dp[i]){
                        dp[i] = 1+dp[j];
                        count[i]=count[j];
                    }else if(1+dp[j]==dp[i]){
                        count[i] += count[j];
                    }
                } 
            }
            if(dp[i]==1){
                count[i]=1;
            }
            mx = Math.max(mx,dp[i]);
        }
        int ans = 0;
        for(int i=0;i<count.length;i++){
            if(dp[i]==mx){
                ans += count[i];
            }
        }
        return ans;
    }
}