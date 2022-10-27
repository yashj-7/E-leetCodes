class Solution {
    public int findMaxLength(int[] nums) {
        if(nums.length==2){
            if(nums[0]==0 && nums[1]==1){
                return 2;
            }else if(nums[0]==1 && nums[1]==0){
                return 2;
            }
            else{
                return 0;
            }
        }
       for(int i=0;i<nums.length;i++){
           if(nums[i]==0){
               nums[i]=-1;
           }
       } 
        int[] res = new int[nums.length];
        res[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            res[i]=res[i-1]+nums[i];
        }
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
        HashMap<Integer,Integer> hm= new HashMap<>();
        for(int i=0;i<res.length;i++){
            hm.put(res[i],i);
        }
        hm.put(0,-1);
        int ans = 0;
        for(int i=0;i<res.length;i++){
            ans=Math.max(ans,Math.abs(hm.get(res[i])-i));
        }
        // for(int i=0;i<res.length;i++){
        //     if(res[i]==0){
        //         ans=Math.max()
        //     }
        // }
        return ans;
    }
}