class Solution {
    public void sortColors(int[] nums) {
        mergeSort(nums,0,nums.length-1);
    }
    public static void mergeSort(int[] a,int beg,int end){
        if(beg<end){
             int mid = (beg+end)/2;
            mergeSort(a,beg,mid);
            mergeSort(a,mid+1,end);
            merge(a,beg,mid,end);
        }
    }
    public static void merge(int[] a,int start,int mid,int end){
        
        int[] arr = new int[end-start+1];
        int i = start;
        int j = mid+1;
        int k=0;
        while(i<=mid && j<=end){
            if(a[i]<=a[j]){
                arr[k]=a[i];
                i++;
            }else if(a[i]>a[j]){
                arr[k]=a[j];
                j++;
            }
            k++;
        }
        if(i>mid && j<=end){
            while(j<=end){
                arr[k]=a[j];
                j++;
                k++;
            }
        }else if(i<=mid && j>end){
            while(i<=mid){
                arr[k]=a[i];
                i++;
                k++;
            }
        }
        int y=0;
        for(int l=start;l<=end;l++){
            a[l]=arr[y];
            y++;
        }
    }
}