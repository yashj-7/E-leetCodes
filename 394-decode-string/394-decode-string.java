class Solution {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> ans = new Stack<>();
        int i=0;
        String res = "";
        while(i<s.length()){
            if(s.charAt(i)=='['){
                ans.push(res);
                res="";
                i++;
            }else if(s.charAt(i)==']'){
                int cnt = count.pop();
                StringBuilder tmp = new StringBuilder(ans.pop());
                for(int j=0;j<cnt;j++){
                    tmp.append(res);
                }
                res = tmp.toString();
                i++;
            }else if(Character.isDigit(s.charAt(i))){
                String c = "";
                while(Character.isDigit(s.charAt(i))){
                    c=c+Character.toString(s.charAt(i));
                    i++;
                }
                //System.out.println(c);
                count.push(Integer.parseInt(c));
            }else{
               res=  res+Character.toString(s.charAt(i));
                i++;
            }
        }
        return res;
    }
}