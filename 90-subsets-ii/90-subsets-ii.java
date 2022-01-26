class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        solve(temp,list,0,nums,nums.length);
        return list;
    }
    public void solve(List<Integer> temp,List<List<Integer>> list,int index, int[] nums,int N){
        if(index==N){
            Collections.sort(temp);
            if(list.contains(temp)==false){
                list.add(temp); 
            }  
            return;
        }
        List<Integer> temp1 = new ArrayList<Integer>(temp);
        List<Integer> temp2 = new ArrayList<Integer>(temp);
        temp1.add(nums[index]);
        solve(temp2,list,index+1,nums,N);
        solve(temp1,list,index+1,nums,N);
        return;
    }
}