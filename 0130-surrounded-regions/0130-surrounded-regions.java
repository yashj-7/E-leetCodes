class Solution {
    public void solve(char[][] board) {
        int i=0;
        int[][] vis= new int[board.length][board[0].length];
        for(int j=0;j<board[0].length;j++){
            if(board[i][j]=='O' && vis[i][j]!=1){
                //vis[i][j]=1;
                dfs(i,j,vis,board);
            }
        }
        for(int j=0;j<board.length;j++){
            if(board[j][i]=='O' && vis[j][i]!=1){
                //vis[i][j]=1;
                dfs(j,i,vis,board);
            }
        }
        i = board.length-1;
        for(int j=0;j<board[0].length;j++){
            if(board[i][j]=='O' && vis[i][j]!=1){
                //vis[i][j]=1;
                dfs(i,j,vis,board);
            }
        }
        i=board[0].length-1;
        for(int j=0;j<board.length;j++){
            if(board[j][i]=='O' && vis[j][i]!=1){
                //vis[i][j]=1;
                dfs(j,i,vis,board);
            }
        }
        // for(int x=0;x<board.length;x++){
        //     for(int j=0;j<board[0].length;j++){
        //         System.out.print(vis[x][j]+" ");
        //     }
        //     System.out.println();
        // }
        for(int x=0;x<board.length;x++){
            for(int j=0;j<board[0].length;j++){
                if(vis[x][j]==0 && board[x][j]=='O'){
                    board[x][j]='X';
                }
            }
        }   
    }
    public static void dfs(int i,int j,int[][] vis,char[][] board){
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1 || board[i][j]=='X' || vis[i][j]==1){
            return ;
        }   
        vis[i][j]=1;
        dfs(i-1,j,vis,board);
        dfs(i+1,j,vis,board);
        dfs(i,j+1,vis,board);
        dfs(i,j-1,vis,board);
    }
}