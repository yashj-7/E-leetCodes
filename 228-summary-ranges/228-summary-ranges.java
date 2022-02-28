class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list  = new ArrayList<>();
        int i=0;
        int j=0;
        while(j<nums.length){
            if(j<nums.length-1 && nums[j]==nums[j+1]-1){
                j++;
            }else if(i==j){
                String ans = String.valueOf(nums[i]);
                list.add(ans);
                j++;
                i++;
            }
            else{
                String ans = String.valueOf(nums[i])+"->"+String.valueOf(nums[j]);
                list.add(ans);
                i=j+1;
                j++;
            }
        }
        return list;
    }
}