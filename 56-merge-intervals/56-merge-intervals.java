class Solution {
    public int[][] merge(int[][] intervals) {
        int[] pair = new int[2];
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
        pair = intervals[0];
        ArrayList<int[]> list = new ArrayList<int[]>();
        for(int i=1;i<intervals.length;i++){
            if(pair[1]>=intervals[i][0]){
                int higher = Math.max(pair[1],intervals[i][1]);
                pair[1] = higher; 
            }else{
                list.add(pair);
                pair = intervals[i];
            }
        }
        list.add(pair);
        int[][] ans = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}