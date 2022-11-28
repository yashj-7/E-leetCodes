class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,ArrayList<Integer>> winner = new HashMap<>();
        HashMap<Integer,ArrayList<Integer>> looser = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int[] arr = new int[100001];
        for(int i=0;i<matches.length;i++){
            int[] temp = matches[i];
            arr[temp[0]]=1;
            arr[temp[1]]=1;
            max = Math.max(max,Math.max(temp[0],temp[1]));
            if(winner.containsKey(temp[0])){
                ArrayList<Integer> tmp = winner.get(temp[0]);
                tmp.add(temp[1]);
                winner.put(temp[0],tmp);
            }else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(temp[1]);
                winner.put(temp[0],list);
            }
            if(looser.containsKey(temp[1])){
                looser.get(temp[1]).add(temp[0]);
            }else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(temp[0]);
                looser.put(temp[1],list);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> win = new ArrayList<>();
        List<Integer> win2 = new ArrayList<>();
        
        for(int i=1;i<max+1;i++){
            if(arr[i]!=0 && looser.containsKey(i)==false){
                win.add(i);
            }else if(arr[i]!=0 && looser.get(i).size()==1){
                win2.add(i);
            }else{
                continue;
            }
        }
        ans.add(win);
        ans.add(win2);
        return ans;
    }
}