class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit=0;
        int min=Integer.MAX_VALUE;
    
        for(int i=0;i<prices.length;i++){
           min=Math.min(min,prices[i]);
            if(prices[i]-min>maxprofit){
                maxprofit=prices[i]-min;
            }
        }
        
        return maxprofit;
    }
}