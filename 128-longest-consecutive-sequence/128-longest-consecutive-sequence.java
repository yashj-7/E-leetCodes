class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        System.out.println(hs);
        int count = 1;
        int max_count = 0;
        for(int i=0;i<nums.length;i++){
            if(hs.contains(nums[i]-1)==false){
                int j=1;
                while(hs.contains(nums[i]+j)==true){
                    j++;
                    count++;
                }
            }
            if(max_count<count){
                max_count =  count;
            }
            count=1;
        }
        return max_count;
    }
}