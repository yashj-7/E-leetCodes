class LUPrefix {
    
    TreeSet<Integer> ts = new TreeSet<>();
    int n;

    public LUPrefix(int n) {
        for(int i=1;i<=n;i++){
            ts.add(i);
        }
        this.n = n;
    }
    
    public void upload(int video) {
        ts.remove(video);
    }
    
    public int longest() {
        if(ts.size()==n){
            return 0;
        }
        if(ts.isEmpty()){
            return n;
        }
        int x = ts.first();
        return x-1;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */