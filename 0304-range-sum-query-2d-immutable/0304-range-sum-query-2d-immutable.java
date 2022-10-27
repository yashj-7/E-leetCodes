class NumMatrix {
    
    int[][] sum;

    public NumMatrix(int[][] matrix) {
        sum = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            sum[i][0] = matrix[i][0];
            for(int j=1;j<matrix[0].length;j++){
                sum[i][j] = sum[i][j-1]+matrix[i][j];
            }
        }
        for(int i=0;i<matrix[0].length;i++){
            for(int j=1;j<matrix.length;j++){
                sum[j][i] = sum[j][i]+sum[j-1][i];
            }
        }
        // for(int i=0;i<sum.length;i++){
        //     for(int j=0;j<sum[0].length;j++){
        //         System.out.print(sum[i][j]+" ");
        //     }
        //     System.out.println();
        // }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = sum[row2][col2];
        if(row1>0){
            ans = ans-sum[row1-1][col2];
        }
        if(col1>0){
            ans=ans-sum[row2][col1-1];
        }
        if(row1>0 && col1>0){
            ans = ans+sum[row1-1][col1-1];
        }
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */