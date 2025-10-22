class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // store min price so far
        int maxProfit = 0; // store max profit

        for (int price : prices) {
            // update minimum price
            minPrice = Math.min(minPrice, price);

            // calculate profit if sold today
            int profit = price - minPrice;

            // update max profit
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}
