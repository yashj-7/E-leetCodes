class Solution {
    public int maximalRectangle(char[][] matrix) {
       ArrayList<int[]> list = new ArrayList();
        for(int i=0;i<matrix.length;i++){
          if(i==0){
              int[] arr = new int[matrix[0].length];
              for(int j=0;j<matrix[0].length;j++){
                  arr[j] = Character.getNumericValue(matrix[i][j]);
              }
              list.add(arr);
          }else{
              int[] arr = new int[matrix[0].length];
              for(int j=0;j<matrix[0].length;j++){
                  if(Character.getNumericValue(matrix[i][j])==1){
                      arr[j] = list.get(i-1)[j]+1;
                  }else{
                      arr[j] = 0;
                  }
              }
              list.add(arr);
          }  
        }
        int ans = 0;
        for(int i=0;i<list.size();i++){
            ans = Math.max(ans,MAH(list.get(i)));
        }
        return ans;
    }
    public int MAH(int[] heights){
        class Pair{
            int val;
            int ind;
            Pair(int val,int ind){
                this.val = val;
                this.ind = ind;
            }
        }
        
        int[] arr1 = new int[heights.length];
        int[] arr2 = new int[heights.length];
        Stack<Pair> s = new Stack();
        s.push(new Pair(heights[0],0));
        arr1[0] = -1;
        for(int i=1;i<heights.length;i++){
            if(s.peek().val<heights[i]){
                arr1[i] = s.peek().ind;
                s.push(new Pair(heights[i],i));
            }else if(s.peek().val>=heights[i]){
                while(s.isEmpty()==false && s.peek().val >= heights[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                    arr1[i]=-1;
                    s.push(new Pair(heights[i],i));
                }else{
                    arr1[i] = s.peek().ind;
                    s.push(new Pair(heights[i],i));
                }
            }else if(s.peek().val==heights[i]){
                arr1[i]=arr1[i-1];
                s.push(new Pair(heights[i],i));
            }
        }  
        s.clear();
        arr2[heights.length-1] = heights.length;
        s.push(new Pair(heights[heights.length-1],heights.length-1));
        for(int j=heights.length-2;j>=0;j--){
            if(s.peek().val<heights[j]){
                arr2[j]=s.peek().ind;
                s.push(new Pair(heights[j],j));
            }else if(s.peek().val>=heights[j]){
                while(s.isEmpty()==false && s.peek().val>=heights[j]){
                    s.pop();
                }
                if(s.isEmpty()){
                    arr2[j] = heights.length;
                    s.push(new Pair(heights[j],j));
                }else{
                    arr2[j] = s.peek().ind;
                    s.push(new Pair(heights[j],j));
                }
            }else if(s.peek().val==heights[j]){
                arr2[j]=arr2[j+1];
                while(s.isEmpty()==false && s.peek().val==heights[j]){
                    s.pop();
                }
                s.push(new Pair(heights[j],j));
            }
        }
        int max = 0;
        for(int i=0;i<heights.length;i++){
            max = Math.max(max,(arr2[i]-arr1[i]-1)*heights[i]);
        }
        return max;
    }
}