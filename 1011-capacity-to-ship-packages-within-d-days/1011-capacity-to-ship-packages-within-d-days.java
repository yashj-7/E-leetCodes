class Solution {
    public int shipWithinDays(int[] arr, int D) {
         int r =0;
        int l=Integer.MAX_VALUE;
        int N = arr.length;
        for(int i=0;i<N;i++){
            l=Math.min(l,arr[i]);
            r=r+arr[i];
        }
        // System.out.println(l);
        // System.out.println(r);
        int ans = Integer.MAX_VALUE;
        while(l<=r){
            int mid = l+(r-l)/2;
            // System.out.println(mid);
            // System.out.println(check(arr,mid,D));
            if(check(arr,mid,D)==true){
                ans = Math.min(ans,mid);
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    public static boolean check(int[]arr,int x,int d){
        int reqDays = 1;
        int s = 0;
        for(int i=0;i<arr.length;i++){
            s=s+arr[i];
            if(arr[i]>x){
                return false;
            }
            if(s>x){
                reqDays++;
                s=arr[i];
            }
        }
        if(reqDays<=d){
            return true;
        }else{
            return false;
        }
    }
}