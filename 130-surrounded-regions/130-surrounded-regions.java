class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if(m<3 || n<3){
            return;
        }
        for(int i=0;i<m;i++){
           dfs(board,i,0);
            dfs(board,i,n-1);
            
        }
        for(int i=0;i<n;i++){
            dfs(board,0,i);
            dfs(board,m-1,i);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='*'){
                    board[i][j] = 'O';
                }else if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public static void dfs(char[][] board,int i,int j){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length){
            return ;
        }
        if(board[i][j]=='X' || board[i][j]=='*') return;
        board[i][j] = '*';
        dfs(board,i,j-1);
        dfs(board,i,j+1);
        dfs(board,i-1,j);
        dfs(board,i+1,j);
    }
}