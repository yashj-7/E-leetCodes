class Solution {
    public void sortColors(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        int[] arr = new int[max+1];
        Arrays.fill(arr,0);
        for(int i=0;i<nums.length;i++){
            arr[nums[i]] = arr[nums[i]]+1;
        }
        for(int i=1;i<arr.length;i++){
            arr[i] = arr[i]+arr[i-1];
        }
        int[] a = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            a[arr[nums[i]]-1] = nums[i];
            arr[nums[i]] = arr[nums[i]]-1;
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = a[i];
        }
    }
}