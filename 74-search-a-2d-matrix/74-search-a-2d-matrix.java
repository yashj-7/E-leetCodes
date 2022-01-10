class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int temp = 0;
        for(int i=0;i<matrix.length;i++){
            if(matrix.length==1 || matrix[0][0]>target){
                break;
            }
            if(i==matrix.length-1 && matrix[i][0]<target){
                temp =i;
                break;
            }else if(matrix[i][0]>target){
             temp = i-1;
             break;
         }else if(matrix[i][0]==target){
             return true;
         }
        }
        System.out.println(temp);
        for(int i=0;i<matrix[temp].length;i++){
            if(matrix[temp][i]==target){
                return true;
            }
        }
        return false;
    }
}