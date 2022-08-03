class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int j=0;
        int s=0;
        int ans = Integer.MAX_VALUE;
        while(j<nums.length){
            s=s+nums[j];
            // while(s>target){
            //     s=s-nums[i];
            //     i++;
            // }
            //System.out.println(s);
            while(s>=target){
                ans = Math.min(ans,j-i+1);
                s=s-nums[i];
                i++;
            }
            j++;
        }
        if(ans==Integer.MAX_VALUE){
            return 0;
        }
        return ans;
    }
}