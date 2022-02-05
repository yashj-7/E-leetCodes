class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       Stack<Integer> s = new Stack();
        HashMap<Integer,Integer> hm = new HashMap();
        for(int i=nums2.length-1;i>=0;i--){
            if(s.empty()){
                hm.put(nums2[i],-1);
                s.push(nums2[i]);
            }else{
                if(s.peek()>nums2[i]){
                    hm.put(nums2[i],s.peek());
                }else if(s.peek()<nums2[i]){
                    while(s.empty()==false && s.peek()<nums2[i]){
                        s.pop();
                    }
                    if(s.empty()){
                        hm.put(nums2[i],-1);
                    }else{
                        hm.put(nums2[i],s.peek());
                    }
                }
                 s.push(nums2[i]);
            }
        }
        int[] x = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            x[i]=hm.get(nums1[i]);
        }
        return x;
    }
}