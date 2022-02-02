class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='.'){
                        for(char c='1';c<='9';c++){
                        if(isValid(board,i,j,c)){
                            board[i][j] = c;
                            if(solve(board)){
                                return true;
                            }else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
                
            }
        }
        return true;
    }
    public static boolean isValid(char[][] board, int x, int y, char val){
        // String t = String.valueOf(value);
        // char val = t.charAt(0);
        for(int i=0;i<board.length;i++){
            if(board[i][y]==val){
                return false;
            }
        }
        for(int i =0;i<board.length;i++){
            if(board[x][i]==val){
                return false;
            }
        }
        int si = x/3 * 3;
        int sj = y/3 * 3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[si+i][sj+j]==val){
                    return false;
                }
            }
        }
        return true;
    }
}