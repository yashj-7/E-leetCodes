import java.util.*;
class Solution {
    public int majorityElement(int[] nums) {
        int i=0;
        int j=0;
        Hashtable<Integer,Integer> ht1 = new Hashtable<>();
        Arrays.sort(nums);
        while(i<nums.length && j<nums.length){
            if(j==nums.length-1 && nums[j]==nums[i]){
                ht1.put(nums[i],j-i+1);
             }
            if(nums[i]!=nums[j]){
                ht1.put(nums[i],(j-i));
                i=j;
            }else{
                j++;
            }
            
        }
        int max = ht1.get(nums[0]);
        int maxElement = nums[0];
        for(int x=0;x<nums.length;x=x+ht1.get(nums[x])){
            if(ht1.get(nums[x])>max){
                maxElement = nums[x];
                max = ht1.get(nums[x]);
            }
        }
        
        return maxElement;
    }
}