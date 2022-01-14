class Solution {
    public int majorityElement(int[] nums) {
     int count =0;
        int elem = 0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                elem = nums[i];
            }
            if(nums[i]==elem){
                count=count+1;
            }else{
                count--;
            }
        }
        return elem;
    }
}