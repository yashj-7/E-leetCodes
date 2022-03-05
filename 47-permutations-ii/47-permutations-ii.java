class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
       for(int i=0;i<nums.length;i++){
           arr.add(nums[i]);
       }
        List<List<Integer>> result = new ArrayList<>();
        solve(arr,new ArrayList<Integer>(),result);
        return result;
    }
    public void solve(ArrayList<Integer> arr,List<Integer> list,List<List<Integer>> result){
        if(arr.size()<=0){
            if(result.contains(list)==false){
                result.add(new ArrayList<>(list));   
            }
            return;
        }
        for(int i=0;i<arr.size();i++){
            int x = arr.get(i);
            list.add(x);
            arr.remove(i);
            solve(arr,list,result);
            list.remove(list.size()-1);
            arr.add(i,x);
        }
    }
}