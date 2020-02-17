package main.com.sumit.coding.math;

/**
 * Problem URL:
 * https://www.interviewbit.com/problems/mathbug01/
 */
public class PrimeNumberProblem {
    public static void main(String[] args) {
        PrimeNumberProblem primeNumberProblem = new PrimeNumberProblem();
        if (primeNumberProblem.isPrime(1) == 1)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    /**
     * Method that checks for prime number
     *
     * @param A input
     * @return boolean value that describes whether number is prime or not
     */
    private int isPrime(int A) {
        int upperLimit = (int) (Math.sqrt(A));
        for (int i = 2; i <= upperLimit; i++) {
            if (A % i == 0) return 0;
        }

        if (A == 1)
            return 0;

        return 1;
    }
}
