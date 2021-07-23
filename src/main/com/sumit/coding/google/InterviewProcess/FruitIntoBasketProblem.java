package main.com.sumit.coding.google.InterviewProcess;

/*
  Problem URL : https://leetcode.com/problems/fruit-into-baskets/
  Input: fruits = [3,3,3,1,2,1,1,2,3,3,4]
  Output: 5
  Explanation: We can pick from trees [1,2,1,1,2].
* */
public class FruitIntoBasketProblem {

    public static void main(String[] args) {
        int[] tree = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(totalFruit(tree));
    }

    // a | b | c
    // second fruit | first fruit | new fruit
    public static int totalFruit(int[] tree) {

        int lastFruit = -1;
        int secondLastFruit = -1;
        int currentSum = 0;
        int maxSum = 0;
        int numberBetweenSecondLastAndNewFruit = 0;

        for (int newFruit : tree) {

            if (lastFruit == newFruit) {
                // if the new fruit is same as last fruit
                currentSum++;
                numberBetweenSecondLastAndNewFruit += 1;
            } else if (secondLastFruit == newFruit) {
                // if the new fruit is same as second last fruit
                currentSum++;
                numberBetweenSecondLastAndNewFruit = 1;
                secondLastFruit = lastFruit;
                lastFruit = newFruit;
            } else {
                // if the new fruit is not present in the basket
                currentSum = numberBetweenSecondLastAndNewFruit + 1;
                numberBetweenSecondLastAndNewFruit = 1;
                secondLastFruit = lastFruit;
                lastFruit = newFruit;
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
