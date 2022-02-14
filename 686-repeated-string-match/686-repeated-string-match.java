class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count=0;
        StringBuilder sb = new StringBuilder();
        if(a.contains(b)){
            return 1;
        }
     while(sb.toString().length()<=b.length() && sb.toString().contains(b)==false){
         sb = sb.append(a);
         count++;
     }
        System.out.print(sb.toString().contains(b));
        if(sb.toString().contains(b)){
            return count;
        }else if(sb.append(a).toString().contains(b)){
            return count+1;
        }else{
            return -1;
        }
    }
}