class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int l = matrix[0][0];
        int r = matrix[matrix.length-1][matrix.length-1];
        int ans = Integer.MAX_VALUE;
        while(l<=r){
            int mid = l+(r-l)/2;
            System.out.print(mid+" ");
            int c = count(mid,matrix);
            System.out.print(c);
            System.out.println();
            if(c>=k){
                ans = Math.min(ans,mid);
                r=mid-1;
            }else if(c<k){
                l=mid+1;
            }
        }
        return ans;
    }
    public static int count(int x,int[][] matrix){
        int r =0;
        int ans = 0;
        int c=matrix.length-1;
        while(r<matrix.length){
            if(matrix[r][0]>x){
                break;
            }
            if(matrix[r][c]<=x){
                ans=ans+c+1;
                r++;
                c=matrix.length-1;
            }else if(matrix[r][c]>x){
                c--;
            }
        }
        return ans;
    }
}