class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            if(target>=matrix[i][0] && target<= matrix[i][matrix[0].length-1]){
                if(binarySearch(i,matrix,target)){
                    //System.out.println(i);
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean binarySearch(int i,int[][] matrix,int target){
        int l=0;
        int r=matrix[0].length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(matrix[i][mid]==target){
               return true; 
            }else if(matrix[i][mid]<target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return false;
    }
}