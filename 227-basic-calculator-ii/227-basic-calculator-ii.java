class Solution {
    public int calculate(String s) {
        int num=0;
        char sign= '+';
         s = s.replaceAll("\\s", "");
        //System.out.println("rhis"+s);
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++){
           
            if(i==s.length()-1){
                num=num*10+Character.getNumericValue(s.charAt(i));
                
                if(sign=='+'){
                    st.push(num);
                }else if(sign=='-'){
                    st.push(-num);
                }else if(sign=='*'){
                    int x1 = st.pop();
                    int x2 = num;
                    st.push(x1*x2);
                }else if(sign=='/'){
                    int x1 = st.pop();
                    int x2 = num;
                    st.push(x1/x2);
                }
                break;
            }
            if(Character.isDigit(s.charAt(i))){
                num = num*10+Character.getNumericValue(s.charAt(i));
            }
            else if(Character.isDigit(s.charAt(i))==false && s.charAt(i)!=' '){
                if(sign=='-'){
                    st.push(-1*num);
                }
                if(sign=='+'){
                    st.push(num);
                }  
                if(sign=='*'){
                    int x1 = st.pop();
                    st.push(x1*num);
                }
                if(sign=='/'){
                    int x1 = st.pop();
                    st.push(x1/num);
                }
                sign = s.charAt(i);
                num= 0;
            }
            else if(s.charAt(i)==' '){
                if(sign=='+'){
                    st.push(num);
                    num=0;
                }else if(sign=='-'){
                    st.push(-num);
                    num=0;
                }else if(sign=='*'){
                    int x1 = st.pop();
                    int x2 = st.pop();
                    st.push(x1*x2);
                }else if(sign=='/'){
                    int x1 = st.pop();
                    int x2 = st.pop();
                    st.push(x1/x2);
                }
            }
        }
        int ans = 0;
        while(st.isEmpty()==false){
            ans += st.pop();
        }
        return ans;
    }
}