class Solution {
    class Pair{
        char c;
        int cnt;
        Pair(char c,int cnt){
            this.c = c;
            this.cnt = cnt;
        }
    }
     static class Comp implements Comparator<Pair>{
        public int compare(Pair p1,Pair p2){
            if(p1.cnt<p2.cnt){
                return 1;
            }else if(p1.cnt>p2.cnt){
                return -1;
            }else{
                return 0;
            }
        }
    }
    public String reorganizeString(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comp());
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i),hm.get(s.charAt(i))+1);    
            }else{
                hm.put(s.charAt(i),1);
            }
            
        }
        for(int i=0;i<s.length();i++){
            if(hm.get(s.charAt(i))>(s.length()+1)/2){
                return "";
            }
        }
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                pq.offer(new Pair(s.charAt(i),hm.get(s.charAt(i))));
                hm.remove(s.charAt(i));
            }
        }
        
        String ans = "";
        while(pq.isEmpty()==false){
            Pair p1 = pq.poll();
            Pair p2 = null;
            if(ans.length()!=0 && p1.c==ans.charAt(ans.length()-1)){
                p2 = pq.poll();
                pq.offer(p1);
            }else{
                ans = ans+Character.toString(p1.c);
                p1.cnt = p1.cnt-1;
                if(p1.cnt>0){
                    pq.offer(p1);
                }
            }
            if(p2!=null){
                ans = ans+Character.toString(p2.c);
                p2.cnt=p2.cnt-1;
                if(p2.cnt>0){
                    pq.offer(p2);
                }
            }
        }
        return ans;
    }
}