class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int[] dp = new int[nums.length];
        int maxSum = Integer.MIN_VALUE;
        dp[0] = nums[0];
        int total_sum = 0;
        for(int i=0;i<nums.length;i++){
            total_sum+=nums[i];
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]+dp[i-1]>nums[i]){
                dp[i] = nums[i]+dp[i-1];
            }else{
                dp[i] = nums[i];
            }
        }
        for(int i=0;i<dp.length;i++){
            maxSum = Math.max(maxSum,dp[i]);
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=-1*nums[i];
        }
        Arrays.fill(dp,0);
        dp[0]=nums[0];
        int minSum = Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            if(nums[i]+dp[i-1]>nums[i]){
                dp[i] = nums[i]+dp[i-1];
            }else{
                dp[i] = nums[i];
            }
        }
        for(int i=0;i<dp.length;i++){
            minSum = Math.max(minSum,dp[i]);
        }
        minSum = -1*minSum;
        System.out.println(minSum);
        System.out.println(maxSum);
        int x = total_sum - minSum;
        System.out.println(x);
        if(maxSum<0){
            return maxSum;
        }
        if(x<maxSum){
            return maxSum;
        }
        return x;
    }
}