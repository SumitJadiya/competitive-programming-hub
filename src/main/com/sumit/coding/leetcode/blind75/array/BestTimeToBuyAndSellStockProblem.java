package com.sumit.coding.leetcode.blind75.array;

/*
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * */
public class BestTimeToBuyAndSellStockProblem {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(new BestTimeToBuyAndSellStockProblem().maxProfit(prices));

        prices = new int[]{7, 1, 5, 933, 61, 400};
        System.out.println(new BestTimeToBuyAndSellStockProblem().maxProfit(prices));
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     * */
    public int maxProfit(int[] prices) {
        int minPriceSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            int currentProfit = price - minPriceSoFar;
            maxProfit = Math.max(maxProfit, currentProfit);
            minPriceSoFar = Math.min(price, minPriceSoFar);
        }

        return maxProfit;
    }
}
