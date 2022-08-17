class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            //System.out.println(s);
            if(tokens[i].equals("+")){
                int x1 = s.pop();
                int x2 = s.pop();
                s.push(x1+x2);
            }else if(tokens[i].equals("-")){
                int x2 = s.pop();
                int x1 = s.pop();
                s.push(x1-x2);
            }else if(tokens[i].equals("*")){
                int x1 = s.pop();
                int x2 = s.pop();
                s.push(x1*x2);
            }else if(tokens[i].equals("/")){
                int x2 = s.pop();
                int x1 = s.pop();
                s.push(x1/x2);
            }else{
                s.push(Integer.parseInt(tokens[i]));
            }
        }
        return s.pop();
    }
}