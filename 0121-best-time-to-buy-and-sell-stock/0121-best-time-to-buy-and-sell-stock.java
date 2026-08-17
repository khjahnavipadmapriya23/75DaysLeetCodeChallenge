class Solution {
    public int maxProfit(int[] prices) {
        int buyStock = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            buyStock = Math.min(buyStock, prices[i]);

            int currentProfit = prices[i] - buyStock;

            profit = Math.max(profit, currentProfit);
        }

        return profit;
    }
}