class Solution {
    public int myAtoi(String s) {
        String str = s.trim();
        int j=0;
        int i=0;
        if(str.length()==0){
            return 0;
        }
        if(str.charAt(0)=='+' || str.charAt(0)=='-'){
            i=1;
        }
        int flag=0;
        while(i<str.length()){
            if(Character.isDigit(str.charAt(i))==false){
                j=i;
                break;
            }else{
                flag=1;
            }
            i++;
        }
        if(flag==0){
            return 0;
        }
        if(str.charAt(0)=='-'){
            try{
             return -Integer.parseInt(str.substring(1,i));   
            }catch(NumberFormatException nfe){
                return Integer.MIN_VALUE;
            }    
        }else{
            try{
                return Integer.parseInt(str.substring(0,i));
            }catch(NumberFormatException nfe){
                return Integer.MAX_VALUE;
            } 
        }
    }
}