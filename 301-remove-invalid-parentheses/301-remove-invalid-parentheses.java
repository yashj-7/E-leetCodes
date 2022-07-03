class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        HashMap<String,Boolean> ans = new HashMap<>();
        int x = getMin(s);
        solve(list,ans,x,s);
        if(list.size()==0){
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)!=')' && s.charAt(i)!='('){
                    list.add(Character.toString(s.charAt(i)));
                }
            }
        }
        return list;
    }
    public static int getMin(String str){
        Stack<Character> s = new Stack<>();
        
        for(int i=0;i<str.length();i++){
            Character ch = str.charAt(i);
            if(ch=='('){
                s.push(ch);
            }else if(ch==')'){
                if(s.size()==0){
                    s.push(ch);
                }else if(s.peek()=='('){
                    s.pop();
                }else if(s.peek()==')'){
                    s.push(ch);
                }
            }
        }
        return s.size();
    }
    public static void solve(List<String> list,HashMap<String,Boolean> ans,int mr, String s){
        try{
            if(ans.get(s)){
            return;
        }
        }catch(NullPointerException npe){
            ans.put(s,true);    
        }
        
        
        if(mr==0){
            int x = getMin(s);
            if(x==0){
                list.add(s);
            }
            return;
        }
        for(int i=0;i<s.length();++i){
            String left = s.substring(0,i);
            String right = s.substring(i+1,s.length());
            String join= left+right;
            solve(list,ans,mr-1,join);
        }
    }
}