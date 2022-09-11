class Solution {
    public boolean increasingTriplet(int[] nums) {
        int x1=-1;
        int x2=-1;
        int x3=-1;
        x1=nums[0];
        boolean b1 = true;
        boolean b2 = false;
        boolean b3 = false;
        for(int i=1;i<nums.length;i++){
        if(b1==true && b2==true && b3==true && x1<x2 && x2<x3){
            return true;
        }
            if(nums[i]>x1){
                if(nums[i]>x2 && b2==false){
                    x2=nums[i];
                    b2=true;
                }else if(nums[i]<x2){
                    x2=nums[i];
                    b2=true;
                }
                else if(nums[i]>x2 && nums[i]>x3 && b3==false){
                    x3=nums[i];
                    b3=true;
                }else if(nums[i]<x3){
                    x3=nums[i];
                    b3=true;
                }
            }else if(nums[i]<x1){
                x1=nums[i];
            }
        }
        System.out.println(x1+" "+x2+" "+x3);
        if(b1==true && b2==true && b3==true && x1<x2 && x2<x3){
            return true;
        }
        return false;
    }
}