class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] vis = new int[board.length][board[0].length];
        boolean ans = false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(word.charAt(0)==board[i][j]){
                    ans = helper(i,j,board,word,vis,0);     
                }
                if(ans){
                    return ans;
                }
            }
        }
        return ans;
    }
    public static boolean helper(int i,int j,char[][] board,String word,int[][] vis,int index){
        if(index==word.length()){
            return true;
        }
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1 || board[i][j]!=word.charAt(index) || vis[i][j]==1){
            return false;
        }
        vis[i][j]=1;
        boolean t1 = helper(i+1,j,board,word,vis,index+1);
        boolean t2 = helper(i-1,j,board,word,vis,index+1);
        boolean t3 = helper(i,j+1,board,word,vis,index+1);
        boolean t4 = helper(i,j-1,board,word,vis,index+1);
        vis[i][j]=0;
        return t1||t2||t3||t4;
    }
}