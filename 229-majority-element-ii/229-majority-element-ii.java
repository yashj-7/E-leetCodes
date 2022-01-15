class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            }else{
                hm.put(nums[i],1);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(hm.get(nums[i])>nums.length/3 && list.contains(nums[i])==false){
                list.add(nums[i]);
            }
        }
        System.out.println(hm);
        return list;
    }
}