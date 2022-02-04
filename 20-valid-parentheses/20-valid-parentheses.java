class Solution {
    public boolean isValid(String s) {
        Stack<Character> s1 = new Stack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='{' || s.charAt(i)=='['){
                s1.push(s.charAt(i));
            }else{
                char x = 'A';
                if(s1.empty()==false){
                     x = s1.pop();
                }
                if(s.charAt(i)==')'){
                    if(x!='('){
                        return false;
                    }
                }else if(s.charAt(i)==']'){
                    if(x!='['){
                        return false;
                    }
                }else if(s.charAt(i)=='}'){
                    if(x!='{'){
                        return false;
                    }
                }
            }
        }
        if(s1.empty()==false){
            return false;
        }
        return true;
    }
}