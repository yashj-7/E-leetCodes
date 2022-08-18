class Solution {
    class Pair{
        int num;
        Integer freq;
        
        Pair(int num,Integer freq){
            this.num = num;
            this.freq = freq;
        }
    }
    
    class ManComparator implements Comparator<Pair>{
        public int compare(Pair p1,Pair p2){
            if(p1.freq>p2.freq){
                return -1;
            }else if(p1.freq==p2.freq){
                return 0;
            }else{
                return 1;
            }
        }
    }
    
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int count = 0;
        for(int i=0;i<arr.length;i++){
            count++;
            if(hm.containsKey(arr[i])){
                hm.put(arr[i],hm.get(arr[i])+1);
            }else{
                hm.put(arr[i],1);
            }
        }
        Pair[] p = new Pair[hm.size()];
        int j=0;
        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i])){
                int x = hm.get(arr[i]);
                p[j] = new Pair(arr[i],x);
                j++;
                hm.remove(arr[i]);
            }
        }
        Arrays.sort(p,new ManComparator());
        int ans = count;
        int res=0;
        for(int i=0;i<p.length;i++){
            if(ans<=count/2){
                break;
            }
            res++;
            int x = p[i].freq;
            ans = ans-x;
            
        }
        return res;
    }
}