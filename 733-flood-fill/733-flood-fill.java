class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(sr,sc,newColor,image[sr][sc],image);
        return image;
    }
    public static void dfs(int i,int j,int newColor,int oldColor,int[][] image){
        if(i>=image.length || j>=image[0].length || i<0 || j<0){
            return ;
        }
        if(image[i][j]!=oldColor){
            return;
        }
        if(image[i][j]==newColor){
            return;
        }
        image[i][j]=newColor;
        dfs(i+1,j,newColor,oldColor,image);
        dfs(i,j+1,newColor,oldColor,image);
        dfs(i,j-1,newColor,oldColor,image);
        dfs(i-1,j,newColor,oldColor,image);
    }
}