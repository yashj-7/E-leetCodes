class Solution {
    public int longestValidParentheses(String S) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for(int i=1;i<S.length();i++){
            if(S.charAt(i)=='('){
                s.push(i);
            }else{
                if(s.isEmpty()==false && S.charAt(s.peek())=='('){
                    s.pop();
                }else{
                    s.push(i);
                }
            }
        }
        s.push(S.length());
        int ans = 0;
        while(s.isEmpty()==false && s.size()>1){
            int x = s.pop();
            ans = Math.max(ans,x-s.peek()-1);
        }
        ans = Math.max(ans,s.pop()-0);
        return ans;
    }
}