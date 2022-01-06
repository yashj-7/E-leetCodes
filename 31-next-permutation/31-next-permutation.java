class Solution {
    public void nextPermutation(int[] nums) {
        int index1 = -1;
        int index2 = -1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index1 = i;
                break;
            }
        }
        if(index1==-1){
            reverse(nums,0,nums.length-1);
            return;
        }
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>nums[index1]){
                index2 = i;
                break;
            }
        }
        nums = swap(nums,index1,index2);
        nums = reverse(nums,index1+1,nums.length-1);
    }
    public static int[] swap(int[] nums,int ind1,int ind2){
        int temp = nums[ind1];
        nums[ind1] = nums[ind2];
        nums[ind2] = temp;
        return nums;
    }
    public static int[] reverse(int[] a,int index1,int index2){
        while(index1<index2){
            swap(a,index1,index2);
            index1++;
            index2--;
        }
        return a;
    } 
    
}