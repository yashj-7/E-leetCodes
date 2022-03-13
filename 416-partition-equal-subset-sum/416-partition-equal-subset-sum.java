class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum+nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int[][] t = new int[nums.length+1][(sum/2)+1];
        for(int i=0;i<nums.length+1;i++){
            for(int j=0;j<(sum/2)+1;j++){
                t[i][j] = -1;
            }
        }
        int ans = solve(nums,sum/2,nums.length,t);
        System.out.print(ans);
        if(ans==sum/2){
            return true;
        }
        return false;
    }
    public int solve(int[] nums,int sum,int n,int[][] t){
        if(n==0 || sum==0){
            return 0;
        }
        if(nums[n-1]>sum){
            return t[n][sum] = solve(nums,sum,n-1,t);
        }
        if(t[n][sum]!=-1){
            return t[n][sum];
        }
        return t[n][sum] = Math.max(nums[n-1]+solve(nums,sum-nums[n-1],n-1,t),solve(nums,sum,n-1,t));
    }
}