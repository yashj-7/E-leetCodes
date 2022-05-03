class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int start = 0;
        while(start<nums.length && arr[start]==nums[start]){
            start++;
        }
        int end = nums.length-1;
        while(start<end && arr[end]==nums[end]){
            end--;
        }
        return end-start+1;
    }
}