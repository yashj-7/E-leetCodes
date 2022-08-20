class Solution {
    
    class ManComparator implements Comparator<String>{
        public int compare(String a,String b){
            String a1 = a+b;
            String b1 = b+a;
            return b1.compareTo(a1);
        }
    }
    
    public String largestNumber(int[] nums) {  
        String[] arr = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr,new ManComparator());
        String ans = "";
        for(int i=0;i<arr.length;i++){
            ans = ans+""+arr[i];
        }
        if(ans.charAt(0)=='0'){
            return "0";
        }
        return ans;
    }
}