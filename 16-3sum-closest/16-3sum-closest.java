class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            int t = target-(nums[i]);
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==target){
                    ans = nums[i]+nums[j]+nums[k];
                    break;
                }else if(nums[i]+nums[j]+nums[k]<target){
                    if(target-nums[j]-nums[k]-nums[i] < Math.abs(target-ans)){
                        ans = nums[j]+nums[k]+nums[i];
                    }
                    j++;
                }else if(nums[i]+nums[j]+nums[k]>target){
                    if(nums[j]+nums[k]+nums[i]-target < Math.abs(target-ans)){
                        ans = nums[j]+nums[k]+nums[i];
                    }
                    k--;
                }
            }
            if(ans==target){
                break;
            }
        }
        return ans;
    }
}