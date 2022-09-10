class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                st.pop();
            }else{
                st.push(s.charAt(i));
            }
        }
        StringBuilder ans = new StringBuilder();
        while(st.isEmpty()==false){
            ans =  ans.append(Character.toString(st.pop()));
        }
        return ans.reverse().toString();
    }
}