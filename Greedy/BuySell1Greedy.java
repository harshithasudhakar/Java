class BuySell1Greedy {
    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for(int i = 0; i<prices.length; i++){
            minValue = Math.min(prices[i], minValue);
            maxProfit = Math.max(maxProfit, prices[i]-minValue);
        }

        return maxProfit;
    }
}
