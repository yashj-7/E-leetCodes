class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList();
        List<String> temp = new ArrayList();
        solve(temp,list,0,s);
        return list;
    }
    public void solve(List<String> temp, List<List<String>> list, int index, String s){
        if(index==s.length()){
            list.add(new ArrayList(temp));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                temp.add(s.substring(index,i+1));
                solve(temp,list,i+1,s);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}