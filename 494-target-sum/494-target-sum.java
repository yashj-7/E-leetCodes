class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums,target,nums.length-1);
    }
    public int solve(int[] nums,int target,int index){
        if(index==0){
            if(target+nums[index]==0 && target-nums[index]==0){
                return 2;
            }
            if(target+nums[index]==0 || target-nums[index]==0){
                return 1;
            }
            return 0;
        }
        int exp1 = solve(nums,target-nums[index],index-1);
        int exp2 = solve(nums,target+nums[index],index-1);
        return exp1+exp2;
    }
}