class Solution {
    public int wiggleMaxLength(int[] nums) {
        int[][] dp = new int[nums.length][4];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(nums,0,0,dp);
    }
    public static int solve(int[] nums,int i,int ch,int[][] dp){
        if(i==nums.length){
            return 0;
        }
        int n1 = 0;
        int n2 = 0;
        if(dp[i][ch]!=-1){
            return dp[i][ch];
        }
        if(ch==0){
            n1 = 1+solve(nums,i+1,1,dp);
            n2 = solve(nums,i+1,ch,dp);
        }else if(ch==1){
            if(nums[i]-nums[i-1]>0){
                n1 = 1+solve(nums,i+1,2,dp);
                n2 = solve(nums,i+1,ch,dp);
            }else if(nums[i]-nums[i-1]<0){
                n1=1+solve(nums,i+1,3,dp);
                n2 = solve(nums,i+1,ch,dp);
            }
        }else if(ch==2){
            if(nums[i]-nums[i-1]<0){
                n1 = 1+solve(nums,i+1,3,dp);
                n2 = solve(nums,i+1,ch,dp);
            }else{
                n2 = solve(nums,i+1,ch,dp);
            }
        }else if(ch==3){
            if(nums[i]-nums[i-1]>0){
                n1 = 1+solve(nums,i+1,2,dp);
                n2 = solve(nums,i+1,ch,dp);
            }else{
                n2 = solve(nums,i+1,ch,dp);
            }
        }
        return dp[i][ch]=Math.max(n1,n2);
    }
}