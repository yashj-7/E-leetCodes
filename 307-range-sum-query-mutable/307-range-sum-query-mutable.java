class NumArray {
    static int[] seg;
    static int[] num;
    public NumArray(int[] nums) {
        num = new int[nums.length];
        num = nums;
        seg = new int[4*nums.length];
        build(0,0,num.length-1);
    }
    
    public void update(int index, int val) {
        num[index]=val;
        updateTree(index,val,0,0,num.length-1);
        
    }
    public void updateTree(int index,int val,int i,int low,int high){
         if(low==high && index==low){
            seg[i]=val;
             return;
        }else if(low==high){
             return;
         }
        int mid = low+(high-low)/2;
        if(index>=low && index<=high){
            updateTree(index,val,2*i+1,low,mid);
            updateTree(index,val,2*i+2,mid+1,high);
        }else if(index >high){
            return;
        }else if(index<low){
            return;
        }
       
        seg[i] = seg[2*i+1]+seg[2*i+2];
        
    }
    public int sumRange(int left, int right) {
        return query(0,0,num.length-1,left,right);
    }
    public static void build(int i,int low,int high){
        if(low==high){
            seg[i] = num[low];
            return;
        }
        int mid = low+(high-low)/2;
        build(2*i+1,low,mid);
         build(2*i+2,mid+1,high); 
        seg[i] = seg[2*i+1]+seg[2*i+2];
    }
    public static int query(int i,int low,int high, int l ,int r){
        if(l<=low && r>=high){
            return seg[i];
        }
        if(l>high || r<low){
            return 0;
        }
        int mid = low+(high-low)/2;
        int x = query(2*i+1,low,mid,l,r);
        int y = query(2*i+2,mid+1,high,l,r);
        return x+y;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */