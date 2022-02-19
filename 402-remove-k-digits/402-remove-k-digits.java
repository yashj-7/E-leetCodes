class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> s = new Stack<>();
        int i=0;
        if(k==num.length()){
            return "0";
        }
        while(i<num.length()){
            if(s.isEmpty()==false && s.peek()>num.charAt(i)){
                while(k>0 && !s.isEmpty() && s.peek()>num.charAt(i)){
                    k--;
                    s.pop();
                }
            }
            s.push(num.charAt(i));
            i++;
        }
        if(k>0){
            while(k>0){
                s.pop();
                k--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty())
            sb.append(s.pop());
        sb.reverse();
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();
        
    }
}