class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int j=0;
        while(j<nums.length){
            int n=nums[j];
            if(i<2 || n>nums[i-2]){
                nums[i]=n;
                i++;
            }
            j++;
        }
        return i;
    }
}