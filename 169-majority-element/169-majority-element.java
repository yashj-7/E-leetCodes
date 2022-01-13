class Solution {
    public int majorityElement(int[] nums) {
     Arrays.sort(nums);
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(count>=Math.ceil(nums.length/2)){
                return nums[i];
            }
            if(i==0){
                count++;
            }else if(nums[i]==nums[i-1]){
                count++;
            }else{
                count=1;
            }
            
        }
        return nums[0];
    }
}