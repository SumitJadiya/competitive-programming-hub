package main.com.sumit.coding.topics.math;

/**
 * Problem URL:
 * https://www.interviewbit.com/problems/mathbug01/
 */
public class PrimeNumberProblem {
    public static void main(String[] args) {
        PrimeNumberProblem primeNumberProblem = new PrimeNumberProblem();
        System.out.println((primeNumberProblem.isPrime(11)) ? "Yes" : "No");
    }

    /**
     * Method that checks for prime number
     *
     * @param num input
     * @return boolean value that describes whether number is prime or not
     */
    public boolean isPrime(int num) {
        int sqrtNum = (int) Math.sqrt(num);

        if (num <= 1) return false;

        for (int i = 2; i <= sqrtNum; i++)
            if (num % i == 0)
                return false;

        return true;
    }
}
