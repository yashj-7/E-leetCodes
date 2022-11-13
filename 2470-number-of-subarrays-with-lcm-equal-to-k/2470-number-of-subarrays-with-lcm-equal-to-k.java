class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            int lcm = nums[i];
            for(int j=i;j<nums.length;j++){
                lcm = LCM(lcm,nums[j]);
                if(lcm==k){
                    ans++;
                }
            }
        }
        return ans;
    }
    public static int findGCD(int a, int b){
        if(b == 0)
          return a;

        return findGCD(b, a%b);
  }
    public static int LCM(int a,int b){
        int gcd =findGCD(a,b);
        return (a*b)/gcd;
    }
}