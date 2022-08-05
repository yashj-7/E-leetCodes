class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> hs = new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    //System.out.println("woks");
                    continue;
                }
                if(hs.contains(board[i][j])){
                    System.out.println(board[i][j]);
                    return false;
                }
                hs.add(board[i][j]);
            }
            hs.clear();
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[j][i]=='.'){
                    continue;
                }
                if(hs.contains(board[j][i])){
                     
                    return false;
                }
                hs.add(board[j][i]);
            }
            hs.clear();
        }
        for(int row=0;row<9;row=row+3){
            for(int col=0;col<9;col=col+3){
                for(int r=row;r<row+3;r++){
                    for(int c=col;c<col+3;c++){
                      
                        if(Character.isDigit(board[r][c])==false){
                            
                            continue;
                        }
                        if(hs.contains(board[r][c])){
                            return false;
                        }
                        hs.add(board[r][c]);
                    }
                }
                hs.clear();
            }
        }
        return true;
    }
}