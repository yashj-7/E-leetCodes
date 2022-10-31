class Solution {
    public int destroyTargets(int[] nums, int space) {
        Map<Integer, Integer> dCount = new HashMap<>();
        for(int num : nums)
            dCount.put(num%space, dCount.getOrDefault(num%space, 0) + 1);
        int destroy = 1, answer = Integer.MAX_VALUE;
        for(int num: nums){
            int curDestroy = dCount.get(num % space);
            if(curDestroy > destroy || (curDestroy == destroy && num < answer)){
               destroy = curDestroy;
               answer = num;
            }
        }
        return answer;
    }
}