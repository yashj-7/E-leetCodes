class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long result = 0;
        
        for(int i=0;i<arr.length;i++){
            long[] c = new long[101];
            for(int j=i+1;j<arr.length;j++){
                int k = target-arr[i]-arr[j];
                if(k>=0 && k<=100 && c[k]>=1){
                    result = (result + c[k]);
                    result = result%1000000007;
                }
                c[arr[j]]++;
            }
        }
        return (int)result;
    }
}