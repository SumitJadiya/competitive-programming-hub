package test.com.sumit.coding.hashing;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.com.sumit.coding.hashing.ZeroSumSubarrayProblem;

public class ZeroSumSubarrayProblemTest {

    ZeroSumSubarrayProblem zeroSumSubarrayProblem;

    @Test
    @Before
    public void before(){
        zeroSumSubarrayProblem = new ZeroSumSubarrayProblem();
    }

    @Test
    public void test_checkZeroSum_array1(){
        int[] arr = {0, 0, 5, 5, 0, 0};
        Assert.assertEquals(6,zeroSumSubarrayProblem.checkZeroSum(arr));
    }

    @Test
    public void test_checkZeroSum_array2(){
        int[] arr = {6, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        Assert.assertEquals(4,zeroSumSubarrayProblem.checkZeroSum(arr));
    }

    @Test
    public void test_checkZeroSum_array3(){
        int[] arr = { 10, 2, -2, -20, 10 };
        Assert.assertEquals(2,zeroSumSubarrayProblem.checkZeroSum(arr));
    }

    @Test
    @After
    public void after(){
        zeroSumSubarrayProblem = null;
    }
}
