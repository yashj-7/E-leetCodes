class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        HashSet<Character> hs = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i),hm.get(s.charAt(i))+1);
            }else{
                hm.put(s.charAt(i),1);
            }
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        hm.put(s.charAt(0),hm.get(s.charAt(0))-1);
        hs.add(s.charAt(0));
        for(int i=1;i<s.length();i++){
            //System.out.println(stack+" "+hs);
            if(stack.peek()<s.charAt(i) && hs.contains(s.charAt(i))==false){
                stack.push(s.charAt(i));
                hm.put(s.charAt(i),hm.get(s.charAt(i))-1);
                hs.add(s.charAt(i));
            }else if(stack.peek()>s.charAt(i) && hs.contains(s.charAt(i))==false){
                while(stack.isEmpty()==false && hm.get(stack.peek())>0 && s.charAt(i)<stack.peek()){
                    char c = stack.pop();
                    hs.remove(c);
                }
                if(hs.contains(s.charAt(i))==false){
                    stack.push(s.charAt(i));
                    hm.put(s.charAt(i),hm.get(s.charAt(i))-1);
                    hs.add(s.charAt(i));
                }
                
            }else{
                hm.put(s.charAt(i),hm.get(s.charAt(i))-1);
            }
        }
        String ans = "";
        while(stack.isEmpty()==false){
            ans = Character.toString(stack.pop())+ans;
        }
        return ans;
    }
}