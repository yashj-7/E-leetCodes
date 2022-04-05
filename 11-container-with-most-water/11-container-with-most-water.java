class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int cap = 0;
        // int move=1;
        while(i<j ){
            if((j-i)*Math.min(height[i],height[j])>=cap){
                cap = (j-i)*Math.min(height[i],height[j]);
            }
            if(height[i]>height[j]){
                j--;
            }else if(height[i]<height[j]){
                i++;
            }else if(height[i]==height[j]){
                j--;
                i++;
            }
        }
        return cap;
    }
}