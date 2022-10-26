class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int currSum = 0;
        hm.put(0,-1);
        for(int i=0;i<nums.length;i++){
            currSum += nums[i];
            if(k!=0) currSum %=k;
            Integer ind = hm.get(currSum);
            if(ind!= null){
                if(i-ind>1) return true;
            }else{
                hm.put(currSum,i);
            }
        }
        return false;
    }
}