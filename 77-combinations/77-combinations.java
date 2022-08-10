class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            temp.add(i);
            solve(temp,i+1,k,n,list);
            temp.remove(temp.size()-1);
        }
        return list;
    }
    public static void solve(List<Integer> temp,int i,int k,int n,List<List<Integer>> list){
        if(temp.size()==k){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int x=i;x<=n;x++){
            temp.add(x);
            //System.out.println(temp);
            solve(temp,x+1,k,n,list);
            temp.remove(temp.size()-1);
        }
    }
}