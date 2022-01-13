class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])==true){
                hm.replace(nums[i],hm.get(nums[i])+1);
            }else{
                hm.put(nums[i],1);
            }
        }
        int c = (int)nums.length/2;
        for(int i=0;i<nums.length;i++){
            if(hm.get(nums[i])>c){
                return  nums[i];
            }
        }
        return 1;
    }
}