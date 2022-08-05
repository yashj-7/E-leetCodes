class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        solve(candidates,target,list,temp,0);
        return list;
    }
    void solve(int[] candidates,int target,List<List<Integer>> list,List<Integer> temp, int i){
        if(target==0){
            list.add(new ArrayList<>(temp));
            return;
        }
        if(target<0){
            return;
        }
        for(int x=i;x<candidates.length;x++){
            if(x>i && candidates[x]==candidates[x-1]){
                continue;
            }
            temp.add(temp.size(),candidates[x]);
            solve(candidates,target-candidates[x],list,temp,x+1);
            temp.remove(temp.size()-1);
        }
    }
}