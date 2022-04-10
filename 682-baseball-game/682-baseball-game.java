class Solution {
    public int calPoints(String[] ops) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<ops.length;i++){
            if(ops[i].equals("D")){
                result.add(2*result.get(result.size()-1));
            }else if(ops[i].equals("+")){
                result.add(result.get(result.size()-1)+result.get(result.size()-2));
            }else if(ops[i].equals("C")){
                result.remove(result.size()-1);
            }else{
                result.add(Integer.parseInt(ops[i]));
            }
        }
        int ans = 0;
        for(int i=0;i<result.size();i++){
            ans = ans+result.get(i);
        }
        return ans;
    }
}