class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] arr = new int[nums.length];
        int i=0;
        int j=nums.length-1;
        for(int k=0;k<nums.length;k++){
            if(nums[k]%2==0){
                arr[i] = nums[k];
                i++;
            }else{
                arr[j] = nums[k];
                j--;
            }
        }
        return arr;
    }
}