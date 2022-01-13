class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = matrix.length-1;
        int point =-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(l==r){
                point = l;
            }
            if(matrix[mid][0]==target){
                return true;
            }else if(matrix[mid][0]>target){
                r = mid-1;
            }else if(matrix[mid][0]<target){
                if(matrix[mid][matrix[mid].length-1]>=target){
                    l = mid;
                    r=mid;
                    point = l;
                    break;
                }else{
                    l=mid+1;
                }
            }
        }
        if(point==-1){
            return false;
        }
        int left = 0;
        int right = matrix[0].length-1;
        System.out.println(point);
        while(left<=right){
            int mid = (left+right)/2;
            if(matrix[point][mid]==target){
                return true;
            }else if(matrix[point][mid]<target){
                left = mid+1;
            }else if(matrix[point][mid]>target){
                right = mid-1;
            }
        }
        return false;
    }
}