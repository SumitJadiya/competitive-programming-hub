package main.com.sumit.coding.topics.math;

public class FindNthDigitProblem {

    public static void main(String[] args) {

        int n = 11;
        System.out.println(new FindNthDigitProblem().findNthDigit(n));
    }

    public int findNthDigit(int n) {
        if (n < 10) return n;

        double lastBaseDCountTotal = 9;
        double lastBase = 10;

        double prevBaseDCountTotal = 0;
        double digitCount = 1;

        //Find the interval of powers of 10 where Nth digit lives by looking at number of total digits
        while (n > lastBaseDCountTotal) {
            digitCount++;
            prevBaseDCountTotal = lastBaseDCountTotal;
            lastBaseDCountTotal += 9 * digitCount * lastBase;
            lastBase *= 10;
        }

        //then we find how many digits we need after subtracting the total number of digits in the previous interval
        //and calculate how many numbers we need in the new interval to make up for the difference
        double remainingCount = n - prevBaseDCountTotal;
        int whereItsAt = (int) ((lastBase / 10 - 1d) + Math.ceil(remainingCount / digitCount));

        //after this, we need to find which character of the number it is
        //we need to look at the remainder of the division operation so, we use modulus
        double mod = remainingCount % digitCount;
        int whichChar = (int) ((mod == 0 ? digitCount : mod) - 1d);
        return Character.getNumericValue(String.valueOf(whereItsAt).charAt(whichChar));
    }
}
