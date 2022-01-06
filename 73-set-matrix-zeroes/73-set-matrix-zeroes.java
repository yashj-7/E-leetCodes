class Solution {
    public void setZeroes(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int col1 = 1;
        int col2 =1;
        //value in matrix[0][0] is not 0 is denoted by col=1
        if(a[0][0]==0){
            col1 = 2;
            col2 =2;
        }
        //value in matrix[0][0] is already 0 is denoted by col=2;
        //if col = 0 it denotes matrix[0][0] is set to zero by another element
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0||j==0)){
                    if(a[i][j]==0){
                        a[i][0]=0;
                    a[0][j]=0;
                    if(col1!=2 || col2!=2){
                        if(i==0){
                            col1=3;
                        }else if(j==0){
                            col2=4;
                        }
                    }
                }
                    
                }else if(a[i][j]==0){
                    a[0][j]=0;
                    a[i][0]=0;
                }
            }
        }
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==0){
                    if(a[0][0]==0 && (col1==2||col1==3)){
                        a[i][j]=0;
                    }
                }else if(j==0){
                    if(a[0][0]==0 && (col2==2||col2==4)){
                        a[i][j]=0;
                    }
                }else if(a[i][j]!=0){
                    if(a[0][j]==0 || a[i][0]==0){
                        a[i][j]=0;
                    }
                }
            }
        }
    }
}