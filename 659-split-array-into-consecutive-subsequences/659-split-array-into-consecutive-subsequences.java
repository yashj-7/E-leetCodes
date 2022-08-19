class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer,Integer> am = new HashMap<>();
        HashMap<Integer,Integer> vm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(am.containsKey(nums[i])){
                am.put(nums[i],am.get(nums[i])+1);
            }else{
                am.put(nums[i],1);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(am.getOrDefault(nums[i],0)<=0){
                continue;
            }else if(vm.getOrDefault(nums[i],0)>0){
                vm.put(nums[i],vm.getOrDefault(nums[i],0)-1);
                am.put(nums[i],am.getOrDefault(nums[i],0)-1);
                vm.put(nums[i]+1,vm.getOrDefault(nums[i]+1,0)+1);
            }else if(am.getOrDefault(nums[i],0)>0 && am.getOrDefault(nums[i]+1,0)>0 && am.getOrDefault(nums[i]+2,0)>0){
                am.put(nums[i],am.get(nums[i])-1);
                am.put(nums[i]+1,am.get(nums[i]+1)-1);
                am.put(nums[i]+2,am.get(nums[i]+2)-1);
                vm.put(nums[i]+3,vm.getOrDefault(nums[i]+3,0)+1);
            }else{
                return false;
            }      
        }
        return true;
    }
}