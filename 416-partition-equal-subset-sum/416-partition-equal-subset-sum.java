class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum+nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int ans = solve(nums,sum/2,nums.length);
        if(ans==sum/2){
            return true;
        }
        return false;
    }
    public int solve(int[] nums,int sum,int n){
        int t[][] = new int[n+1][sum+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0 || j==0){
                    t[i][j] = 0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
              if(nums[i-1]>j){
                  t[i][j] = t[i-1][j];
              }else{
                  t[i][j] = Math.max(nums[i-1]+t[i-1][j-nums[i-1]],t[i-1][j]);
              }  
            }   
        }
        return t[n][sum];
    }
}