class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                if(i==j){
                    continue;
                }else{
                    swap(matrix,i,j);
                }
            }
         }
        int k = matrix.length-1;
        while(k>=0 ){
            reverse(matrix[k]);
            k--;
        }
    }
     public static void swap(int[][] mat,int i,int j){
        int temp = mat[i][j];
         mat[i][j] = mat[j][i];
         mat[j][i] = temp;
    }
    public static void reverse(int[] mat){
        int i = 0;
        int j = mat.length-1;
        while(i<j){
            int temp = mat[i];
            mat[i] = mat[j];
            mat[j] = temp;
            i++;
            j--;
        }
    }
}