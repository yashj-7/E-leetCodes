class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        solve(temp,list,0,nums,target,nums.length);
        return list;
    }
      public void solve(List<Integer> temp,List<List<Integer>> list,int index, int[] nums,int target,int N){
          if(target<=0 || index==N){
              if(target==0){
                  list.add(temp);
                  return;
              }
              return;
          }
          List<Integer> temp1 = new ArrayList<Integer>(temp);
          List<Integer> temp2 = new ArrayList<Integer>(temp);
          temp1.add(nums[index]);
          solve(temp1,list,index,nums,target-nums[index],N);
          solve(temp2,list,index+1,nums,target,N);
      }
}