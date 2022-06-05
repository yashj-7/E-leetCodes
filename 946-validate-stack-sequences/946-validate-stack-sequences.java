class Solution {
    public boolean validateStackSequences(int[] A, int[] B) {
        Stack<Integer> s = new Stack<>();
        
        int i=1;
        int j =0;
        s.push(A[0]);
        while(i<A.length && j<B.length){
            if(s.isEmpty()==false && B[j]==s.peek()){
                s.pop();
                j++;
            }else if(A[i]==B[j]){
                j++;
                i++;
            }
            else{
                s.push(A[i]);
                i++;
            }
            
        }
        if(j<B.length && s.isEmpty()==false){
            while(j<B.length && s.isEmpty()==false){
                if(B[j]!=s.pop()){
                    return false;
                }
                j++;
            }
            
        }
        if(s.isEmpty()){
            return true;
        }
        return false;
    }
}