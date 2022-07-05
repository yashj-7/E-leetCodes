class Solution {
    public int totalNQueens(int n) {
        String arr[][] = new String[n][n];
        List<List<String>> list = new ArrayList();
        List<String> temp = new ArrayList();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = ".";
            }
        }
        String s = "";
        for(int i=0;i<n;i++){
            s = s+".";
        }
        solve(temp,list,s,arr,0);
        return list.size();
    }
    public void solve(List<String> temp, List<List<String>> list, String s, String[][] arr, int row){
        if(row==arr.length){
            list.add(new ArrayList(temp));
            return;
        }
            StringBuffer str = new StringBuffer(s);
             for(int col=0;col<arr.length;col++){
                 if(isSafe(arr,row,col)){
                    arr[row][col] = "Q";
                    str.setCharAt(col,'Q');
                    temp.add(str.toString());
                    solve(temp,list,s,arr,row+1);
                    arr[row][col] = ".";
                    temp.remove(temp.size()-1);
                    str.setCharAt(col,'.');   
                 }
            }   
    }
    public static boolean isSafe(String[][] arr,int row,int col){
        for(int i=row-1,j=col;i>=0;i--){
            if(arr[i][j]=="Q"){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(arr[i][j]=="Q"){
                return false;
            }
        }
        for(int i=row-1,j=col+1; i>=0 && j<arr.length;i--,j++){
            if(arr[i][j]=="Q"){
                return false;
            }
        }
        return true;
    }
}