class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[0].length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0;i<matrix.length;i++){
            int x = matrix.length-1;
            for(int j=0;j<matrix.length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][x];
                matrix[i][x]=temp;
                x--;
                if(j>=x){
                    break;
                }
            }
        }
    }
}