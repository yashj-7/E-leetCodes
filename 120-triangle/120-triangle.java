class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,triangle,dp);
    }
    public static int solve(int i,int j,List<List<Integer>> list,int[][] dp){
        if(i==list.size()-1){
            return list.get(i).get(j);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int x = list.get(i).get(j) + solve(i+1,j,list,dp);
        int y = list.get(i).get(j) + solve(i+1,j+1,list,dp);
        return dp[i][j] =Math.min(x,y);
    }
}