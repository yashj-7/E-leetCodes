class Solution {
    public int nthUglyNumber(int n) {
        if(n<=0){
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int a=0;
        int b=0,c=0;
        while(list.size()<n){
            list.add(Math.min(list.get(a)*2,Math.min(list.get(b)*3,list.get(c)*5)));
            if(list.get(list.size()-1)==list.get(a)*2)a++;
            if(list.get(list.size()-1)==list.get(b)*3)b++;
            if(list.get(list.size()-1)==list.get(c)*5)c++;
        }
        return list.get(list.size()-1);
    }
}