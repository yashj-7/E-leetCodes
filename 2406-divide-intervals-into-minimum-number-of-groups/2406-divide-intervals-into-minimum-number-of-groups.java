class Solution {
    public int minGroups(int[][] intervals) {
        int[] a = new int[intervals.length];
        int[] b = new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            a[i]=intervals[i][0];
            b[i]=intervals[i][1];
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int i=1;
        int j=0;
        int count = 1;
        int ans = 1;
        while(i<a.length && j<b.length){
            if(a[i]<=b[j]){
                count++;
                i++;
            }else{
                count--;
                j++;
            }
            ans=Math.max(ans,count);
        }
        return ans;
    }
}