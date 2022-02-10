class Solution {
    public int largestRectangleArea(int[] heights) {
        
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
        //  for(int i=0;i<arr1.length;i++){
        //     System.out.print(arr1[i]+" ");
        // }   
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
        System.out.println();
        // for(int i=0;i<arr2.length;i++){
        //     System.out.print(arr2[i]+" ");
        // } 
        int max = 0;
        for(int i=0;i<heights.length;i++){
//             if(arr1[i]==-1 && arr2[i]>-1){
//                 if(i==0){
//                     max = Math.max(max,(i+arr2[i])*heights[i]);
//                 }else{
//                     max = Math.max(max,(i+arr2[i]-1)*heights[i]);
//                 }
                
//             }else if(arr1[i]>-1 && arr2[i]==-1){
//                 max = Math.max(max,((i-arr1[i])+heights.length-1-i)*heights[i]);
//             }else if(arr1[i]==-1 && arr2[i]==-1){
//                 max = Math.max(max,heights[i]*heights.length);
//             }else if(arr1[i]>-1 && arr2[i]>-1){
//                 max = Math.max(max, (arr2[i]-arr1[i]-1)*heights[i]);
//             }
            max = Math.max(max,(arr2[i]-arr1[i]-1)*heights[i]);
            //System.out.println(max);
        }
        return max;
    }
}