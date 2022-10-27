public class Solution {
    public int subarraySum(int[] nums, int k) {
        int s = 0, result = 0;
        Map<Integer, Integer> sum = new HashMap<>();
        sum.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            if (sum.containsKey(s - k)) {
                result += sum.get(s - k);
            }
            sum.put(s, sum.getOrDefault(s, 0) + 1);
        }
        
        return result;
    }
}