class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for(int j=nums.length-1;j>i;j--){
                int x=i+1;
                int y=j-1;
                while(x<y){
                    if(nums[x]+nums[y]==target-(nums[i]+nums[j])){
                    ArrayList<Integer> list1 = new ArrayList<Integer>();
                    list1.add(nums[i]);
                    list1.add(nums[x]);
                    list1.add(nums[y]);
                    list1.add(nums[j]);
                    if(list.contains(list1)==false){
                        list.add(list1);
                    }
                    x++;
                    y--;
                }else if(nums[x]+nums[y]>target-(nums[i]+nums[j])){
                    y--;
                }else if(nums[x]+nums[y]<target-(nums[i]+nums[j])){
                    x++;
                }
            }
                //System.out.println(list);
            }
            
        }
        return list;
    }
}