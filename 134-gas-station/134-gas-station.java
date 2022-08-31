class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int local = 0;
        int start = 0;
        for(int i=0;i<gas.length;i++){
            total += gas[i]-cost[i];
            local+= gas[i]-cost[i];
            if(local<0){
                local=0;
                start = i+1;
            }
        }
        if(total<0){
            return -1;
        }
        return start;
    }
}