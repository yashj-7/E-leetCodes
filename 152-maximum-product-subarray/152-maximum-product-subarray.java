class Solution {
    public int maxProduct(int[] nums) {
        int ma = nums[0];
        int mi = nums[0];
        int ans = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
               int[] arr = swap(ma,mi);
                ma = arr[0];
                mi = arr[1];
            }
            ma = Math.max(nums[i],ma*nums[i]);
            mi = Math.min(nums[i],mi*nums[i]);
            ans = Math.max(ans,ma);
        }
        return ans;
    }
    public int[] swap(int a,int b){
        int[] arr = new int[2];
        int temp = a;
        a = b;
        b = temp;
        arr[0] = a;
        arr[1] = b;
        return arr;
    }
}