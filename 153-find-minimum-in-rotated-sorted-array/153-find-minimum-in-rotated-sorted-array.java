class Solution {
    public int findMin(int[] nums) {
        int pivot = -1;
        int l=0;
        int r=nums.length-1;
        if(nums[l]<nums[r]){
            return nums[l];
        }
        while(l<=r){
            int mid = l+(r-l)/2;
            int next = (mid+1)%nums.length;
            int prev = (mid+nums.length-1)%nums.length;
            if(nums[mid]<=nums[next] && nums[mid]<=nums[prev]){
                return nums[mid];
            }else if(nums[mid]>=nums[l] && nums[mid]>nums[r]){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return 0;
    }
    
}