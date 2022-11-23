class Solution {
    static int[] res;
    static HashMap<Integer,ArrayList<Integer>> hm;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
         hm = new HashMap<>();
        for(int i=0;i<quiet.length;i++){
            hm.put(i,new ArrayList<>());
        }
        for(int i=0;i<richer.length;i++){
            ArrayList<Integer> list = hm.get(richer[i][1]);
            list.add(richer[i][0]);
        }
        //System.out.print(hm);
        res = new int[quiet.length];
        Arrays.fill(res,-1);
        for(int i=0;i<quiet.length;i++){
                res[i] = dfs(i,quiet);   
        }
        return res;
    }
    public static int dfs(int i,int[] quiet){
        if(res[i]!=-1){
            return res[i];
        }
        ArrayList<Integer> list = hm.get(i);
        int ans = i;
        for(Integer j: list){
            int x = dfs(j,quiet);
            res[j]=x;
            if(quiet[ans]>quiet[x]){
                ans = x;
            }
        }
        return ans;
    }
}