class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int point =0;
        if(nums.length==1 && nums[0]==target){
            return 0;
        }else if(nums.length==1 && nums[0]!=target){
            return -1;
        }
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(mid>0 && nums[mid]<nums[mid-1]){
                point = mid;
                break;
            }else if(mid<nums.length-1 && nums[mid]>nums[mid+1]){
                point = mid+1;
                break;
            }else if(nums[mid]<nums[nums.length-1]){
                r = mid-1;
            }else if(nums[mid]>nums[nums.length-1]){
                l=mid+1;
            }
        }
        // System.out.println(point);
        if(nums[point]==target){
            return point;
        }
        int i1 = BinarySearch(nums,0,point-1,target);
        int i2 = BinarySearch(nums,point+1,nums.length-1,target);
        if(i1!=-1){
            return i1;
        }
        if(i2!=-1){
            return i2;
        }
        return -1;
    }
    public static int BinarySearch(int[] nums, int l, int r, int target){
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                l = mid+1;
            }else if(nums[mid]>target){
                r = mid-1;
            }
        }
        return -1;
    }
}