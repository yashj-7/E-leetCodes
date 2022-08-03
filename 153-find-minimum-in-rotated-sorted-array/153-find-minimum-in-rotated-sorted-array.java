class Solution {
    public int findMin(int[] nums) {
        int pivot = -1;
        int l=0;
        int r=nums.length-1;
        if(nums[l]<nums[r]){
            return nums[l];
        }
        if(nums.length==1){
            return nums[0];
        }
        while(l<=r){
            int mid = l+(r-l)/2;
            if(mid>0 && nums[mid]<nums[mid-1]){
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