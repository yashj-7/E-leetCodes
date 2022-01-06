class Solution {
    public int maxProfit(int[] prices) {
        int minimal = Integer.MAX_VALUE;
        int profit = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minimal){
                minimal = prices[i];
                System.out.println(minimal);
            }else{
                if(prices[i]-minimal>profit){
                    profit = prices[i]-minimal;
                }
            }
        }
        return profit;
    }
}