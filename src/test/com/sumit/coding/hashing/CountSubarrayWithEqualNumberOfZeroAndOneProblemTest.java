package test.com.sumit.coding.hashing;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.com.sumit.coding.hashing.CountSubarrayWithEqualNumberOfZeroAndOneProblem;

public class CountSubarrayWithEqualNumberOfZeroAndOneProblemTest {

    CountSubarrayWithEqualNumberOfZeroAndOneProblem countSubarrayWithEqualNumberOfZeroAndOneProblem;

    @Test
    @Before
    public void before() {
        countSubarrayWithEqualNumberOfZeroAndOneProblem = new CountSubarrayWithEqualNumberOfZeroAndOneProblem();
    }

    @Test
    public void test_checkZeroSum_array1() {
        int[] arr = {1,0, 0, 1, 0, 1, 1};
        Assert.assertEquals(8, countSubarrayWithEqualNumberOfZeroAndOneProblem.countSubarray(arr));
    }

    @Test
    public void test_checkZeroSum_array2() {
        int[] arr = {1, 1, 1, 1, 0};
        Assert.assertEquals(1,countSubarrayWithEqualNumberOfZeroAndOneProblem.countSubarray(arr));
    }

    @Test
    @After
    public void after() {
        countSubarrayWithEqualNumberOfZeroAndOneProblem = null;
    }
}
