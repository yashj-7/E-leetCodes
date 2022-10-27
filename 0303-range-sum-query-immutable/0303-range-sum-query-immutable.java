class NumArray {

    int[] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length];
        sum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            sum[i]=sum[i-1]+nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        int ans = sum[right];
        if(left>0){
            ans = ans-sum[left-1];
        }
        return ans;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */