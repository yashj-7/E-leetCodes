class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
       int count1 =0;
        int elem1= Integer.MAX_VALUE;
        int count2 = 0;
        int elem2 = Integer.MAX_VALUE-1;
        for(int i=0;i<nums.length;i++){
            if(count1==0 && nums[i]!=elem2){
                elem1 = nums[i];
            }else if(count2==0 && nums[i]!=elem1){
                elem2 = nums[i];
            }
            if(nums[i]==elem1){
                count1=count1+1;
            }else if(nums[i]==elem2){
                count2=count2+1;
            }else{
                count1--;
                count2--;
            }
        }
        int mcount1 = 0;
        int mcount2 = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==elem1){
                mcount1++;
            }
            if(nums[i]==elem2){
                mcount2++;
            }
        }
        if(mcount1>nums.length/3){
            list.add(elem1);
        }
        if(mcount2>nums.length/3 ){
            list.add(elem2);
        }
        return list;
    }
}