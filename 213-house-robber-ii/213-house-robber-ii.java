class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[][] dp = new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int x = nums[0]+solve(nums,1,true,true,dp);
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int y = solve(nums,1,false,false,dp);
        return Math.max(x,y);
    }
    public static int solve(int[] nums,int i,boolean first,boolean last,int[][] dp){
        if(i==nums.length-1){
            if(last==true || first==true){
                return 0;
            }else{
                return nums[i];
            }
        }
        if(last==false){
            if(dp[i][0]!=-1){
                return dp[i][0];
            }
        }else{
            if(dp[i][1]!=-1){
                return dp[i][1];
            }
        }
        int x = Integer.MIN_VALUE;
        int y = Integer.MAX_VALUE;
       if(last==false){
           x = nums[i]+solve(nums,i+1,first,true,dp);
           y = solve(nums,i+1,first,false,dp);
       }else{
           y = solve(nums,i+1,first,false,dp);
       }
        if(last==false){
            dp[i][0] = Math.max(x,y);
        }else{
            dp[i][1] = Math.max(x,y);
        }
        return Math.max(x,y);
    }
}