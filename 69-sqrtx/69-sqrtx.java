class Solution {
    public int mySqrt(int x) {
        long l=1;
        long r=(long)x;
        long ans = 0;
        while(l<=r){
            long mid = l+(r-l)/2;
            if(mid*mid==x){
                return (int)mid;
            }
            else if(mid*mid>x){
                r=mid-1;
            }else{
                ans = (long)Math.max(ans,mid);
                l=mid+1;
            }
        }
        // if(ans==Integer.MIN_VALUE){
        //     return 0;
        // }
        return (int)ans;
    }
}