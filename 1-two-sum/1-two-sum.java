import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer,Integer> ht1 = new Hashtable<>();
        int[] arr = new int[2];
        for(int i=0;i<nums.length;i++){
            if(ht1.containsKey(target-nums[i])){
                arr[0] = i;
                arr[1] = ht1.get(target-nums[i]);
            }else{
                ht1.put(nums[i],i);
            }
        }
        return arr;
    }
}