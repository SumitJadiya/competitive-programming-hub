package main.com.sumit.coding.topics.arrays;

/*
 * URL - https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 * */
public class BestTimeToBuyAndSellStockProblem {

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(new BestTimeToBuyAndSellStockProblem().maxProfit(nums));
    }

    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxSum = 0;

        for (int price : prices) {
            if (price < minPrice) minPrice = price;
            else if (maxSum < price - minPrice) maxSum = price - minPrice;
        }

        return maxSum;
    }
}
