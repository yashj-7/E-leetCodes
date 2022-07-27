class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lo = 0;
        int hi = nums1.length;
        int partition = (nums1.length+nums2.length+1)/2;
        double ans = 0.0;
        if(nums1.length==0){
            if(nums2.length%2==0){
                int x = nums2[nums2.length/2];
                int y = nums2[(nums2.length/2)-1];
                return (double)((x+y)/2.0);
            }else{
                return (double)(nums2[(nums2.length-1)/2]);
            }
        }
        if(nums2.length==0){
            if(nums1.length%2==0){
                int x = nums1[nums1.length/2];
                int y = nums1[(nums1.length/2)-1];
                return (double)((x+y)/2.0);
            }else{
                return (double)(nums1[(nums1.length-1)/2]);
            }
        }
        while(lo<=hi){
            int cut1=lo+(hi-lo)/2;
            int cut2 = partition-cut1;
            if(cut1>partition){
                hi = cut1-1;
                continue;
            }
            if(cut2>partition || cut2>nums2.length){
                lo=cut1+1;
                continue;
            }
            // if(cut1+cut2>partition){
            //     lo=cut1+1;
            //     continue;
            // }
            int l1 = Integer.MIN_VALUE;
            if(cut1-1>=0){
                l1 = nums1[cut1-1];
            } 
            int l2 = Integer.MIN_VALUE;
            if(cut2-1>=0 ){
                l2 = nums2[cut2-1];
            }
            int r1 = Integer.MAX_VALUE;
            if(cut1>=0 && cut1<nums1.length){
                r1 = nums1[cut1];
            }
            int r2 = Integer.MAX_VALUE;
            if(cut2>=0 && cut2<nums2.length){
                r2 = nums2[cut2];
            }
            if(l1<=r2 && l2<=r1){
                if((nums1.length+nums2.length)%2==0){
                    ans = (double)(Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                    return ans;
                }else{
                    return (double)Math.max(l1,l2);
                }
            }else if(l1>r2){
                hi = cut1-1;
            }else if(l2>r1){
                lo = cut1+1;
            }
        }
        return 0.0;
    }
}