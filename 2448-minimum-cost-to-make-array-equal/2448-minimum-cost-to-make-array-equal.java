class Solution {
    
    class ManComparator implements Comparator<Pair>{
        public int compare(Pair p1,Pair p2){
            if(p1.num>p2.num){
                return 1;
            }else if(p1.num<p2.num){
                return -1;
            }else{
                return 0;
            }
        }
    }
    
    class Pair{
        int num;
        int cost;
        Pair(int num,int cost){
            this.num=num;
            this.cost=cost;
        }
    }
    public long minCost(int[] nums, int[] cost) {
        long totalSum = 0;
        for(int i=0;i<cost.length;i++){
            totalSum = totalSum+cost[i];
        }
        Pair[] p =new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            p[i]=new Pair(nums[i],cost[i]);
        }
        long medianIndex = totalSum/2;
        Arrays.sort(p,new ManComparator());
        // for(int i=0;i<p.length;i++){
        //     System.out.println(p[i].num);
        // }
        long temp = 0;
        long ele = -1;
        long ele2 = -1;
        for(int i=0;i<nums.length;i++){
            temp = temp+p[i].cost;
            if(temp>=medianIndex){
               ele = p[i].num; 
                break;
            }
        }
        temp=0;
        for(int i=0;i<nums.length;i++){
            temp = temp+p[i].cost;
            if(temp>=medianIndex+1){
               ele2 = p[i].num; 
                break;
            }
        }
        long ans = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==ele){
                continue;
            }
            ans = ans+(Math.abs(ele-nums[i]))*cost[i];
        }
        long ans2 = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==ele2){
                continue;
            }
            ans2 = ans2+(Math.abs(ele2-nums[i]))*cost[i];
        }
        long res = Math.min(ans,ans2);
        System.out.println(ele+" "+ele2);
        return res;
    }
}