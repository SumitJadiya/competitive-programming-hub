package main.com.sumit.coding.arrays;

public class StockBuySellProblem {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(new StockBuySellProblem().maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
        int maxCurr = 0;
        int maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCurr = Math.max(maxCurr, maxCurr += prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxCurr, maxSoFar);
        }
        return maxSoFar;
    }
}
