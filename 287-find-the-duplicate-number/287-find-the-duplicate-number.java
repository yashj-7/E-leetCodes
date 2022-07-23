class Solution {
    public int findDuplicate(int[] arr) {
        int i=0;
        while(i<arr.length){
            if(arr[i]!=i+1){
                if(arr[arr[i]-1]==arr[i]){
                    i++;
                    continue;
                }
                int temp = arr[arr[i]-1];
                arr[arr[i]-1] = arr[i];
                arr[i] = temp;
            }else{
                i++;
            }
        }
        int ans = 0;
        for(i=0;i<arr.length;i++){
            if(arr[i]!=i+1){
                ans = arr[i];
                break;
            }
        }
        return ans;
    }
}